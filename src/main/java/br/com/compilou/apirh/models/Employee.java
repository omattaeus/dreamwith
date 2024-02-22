package br.com.compilou.apirh.models;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String surname;
    @Column(nullable = false, length = 20)
    private String gender;
    @Column(name = "date", nullable = false, length = 50)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private String office;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<Depedents> dependents;

    public Employee() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public List<Depedents> getDependents() {
        return dependents;
    }

    public void setDependents(List<Depedents> dependents) {
        this.dependents = dependents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(gender, employee.gender) && Objects.equals(date, employee.date) && Objects.equals(email, employee.email) && Objects.equals(office, employee.office) && Objects.equals(dependents, employee.dependents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, gender, date, email, office, dependents);
    }
}