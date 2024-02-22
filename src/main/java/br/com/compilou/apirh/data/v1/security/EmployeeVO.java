package br.com.compilou.apirh.data.v1.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "name", "surname", "gender", "date", "email", "office"})
public class EmployeeVO extends RepresentationModel<EmployeeVO>
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private long key;
    private String name;
    private String surname;
    private String gender;
    private Date date;
    private String email;
    private String office;

    public EmployeeVO() {}

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EmployeeVO that = (EmployeeVO) o;
        return key == that.key && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(gender, that.gender) && Objects.equals(date, that.date) && Objects.equals(email, that.email) && Objects.equals(office, that.office);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, name, surname, gender, date, email, office);
    }
}
