package br.com.compilou.apirh.controllers;

import br.com.compilou.apirh.repositories.CandidateRepository;
import br.com.compilou.apirh.repositories.DepedentsRepository;
import br.com.compilou.apirh.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rh/search")
public class SearchController {

    @Autowired
    private CandidateRepository candidate;
    @Autowired
    private DepedentsRepository depedent;
    @Autowired
    private EmployeeRepository employee;
}