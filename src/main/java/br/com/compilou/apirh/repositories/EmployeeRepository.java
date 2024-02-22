package br.com.compilou.apirh.repositories;

import br.com.compilou.apirh.models.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Modifying
    @Query("UPDATE Employee b SET b.enabled = false WHERE b.id =:id")
    void disableEmployee(@Param("id") Long id);
}