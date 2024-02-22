package br.com.compilou.apirh.services;

import br.com.compilou.apirh.controllers.EmployeeController;
import br.com.compilou.apirh.data.v1.security.EmployeeVO;
import br.com.compilou.apirh.exceptions.handler.RequiredObjectIsNullException;
import br.com.compilou.apirh.exceptions.handler.ResourceNotFoundException;
import br.com.compilou.apirh.mapper.DozerMapper;
import br.com.compilou.apirh.models.Employee;
import br.com.compilou.apirh.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class EmployeeService {

    private final Logger logger = Logger.getLogger(EmployeeService.class.getName());

    @Autowired
    private EmployeeRepository emp;

    @Autowired
    PagedResourcesAssembler<EmployeeVO> assembler;

    public List<EmployeeVO> findAllEmployee() {

        logger.info("Finding all book!");

        var employees = DozerMapper.parseListObjects(emp.findAll(), EmployeeVO.class);
        employees
                .stream()
                .forEach(p -> p.add(linkTo(methodOn(EmployeeController.class).findById(p.getKey())).withSelfRel()));
        return employees;
    }

    public PagedModel<EntityModel<EmployeeVO>> findAllEmployeeByPageable(Pageable pageable){

        logger.info("Finding all employees!");

        var personPage = emp.findAll(pageable);

        var personVosPage = personPage.map(p -> DozerMapper.parseObject(p, EmployeeVO.class));
        personVosPage.map(p -> {
            try {
                return p.add(linkTo(methodOn(EmployeeController.class)
                        .findById(p.getKey())).withSelfRel());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Link link = linkTo(methodOn(EmployeeController.class).findAll(pageable.getPageNumber(),
                pageable.getPageSize(), "asc")).withSelfRel();

        return assembler.toModel(personVosPage, link);
    }

    public EmployeeVO findEmployeeById(Long id) {

        logger.info("Finding one book!");

        var entity = emp.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, EmployeeVO.class);
        vo.add(linkTo(methodOn(EmployeeController.class).findById(id)).withSelfRel());
        return vo;
    }

    public EmployeeVO createEmployee(EmployeeVO employee) {

        if (employee == null) throw new RequiredObjectIsNullException();

        logger.info("Creating one employee!");

        var entity = DozerMapper.parseObject(employee, Employee.class);
        var vo =  DozerMapper.parseObject(emp.save(entity), EmployeeVO.class);
        vo.add(linkTo(methodOn(EmployeeController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public EmployeeVO updateEmployee(EmployeeVO employee) {

        if (employee == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one employee!");

        var entity = emp.findById(employee.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(employee.getName());
        entity.setSurname(employee.getSurname());
        entity.setGender(employee.getGender());
        entity.setDate(employee.getDate());
        entity.setEmail(employee.getEmail());
        entity.setOffice(employee.getOffice());

        var vo =  DozerMapper.parseObject(emp.save(entity), EmployeeVO.class);
        vo.add(linkTo(methodOn(EmployeeController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    @Transactional
    public EmployeeVO disableEmployee(Long id) throws Exception {

        logger.info("Disabling one employee!");

        emp.disableEmployee(id);

        var entity = emp.findById(id)
                .orElseThrow(() -> new RequiredObjectIsNullException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(entity, EmployeeVO.class);
        vo.add(linkTo(methodOn(EmployeeController.class).findById(id)).withSelfRel());
        return vo;
    }

    public void deleteEmployee(Long id) {

        logger.info("Deleting one employee!");

        var entity = emp.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        emp.delete(entity);
    }
}
