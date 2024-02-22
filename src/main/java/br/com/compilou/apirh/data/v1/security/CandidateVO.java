package br.com.compilou.apirh.data.v1.security;

import br.com.compilou.apirh.models.Vacancy;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "rg", "nameCandidate", "email", "vacancy"})
public class CandidateVO extends RepresentationModel<CandidateVO>
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String rg;
    private String nameCandidate;
    private String email;
    private Vacancy vacancy;

    public CandidateVO() {}

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNameCandidate() {
        return nameCandidate;
    }

    public void setNameCandidate(String nameCandidate) {
        this.nameCandidate = nameCandidate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CandidateVO that = (CandidateVO) o;
        return Objects.equals(key, that.key) && Objects.equals(rg, that.rg) && Objects.equals(nameCandidate, that.nameCandidate) && Objects.equals(email, that.email) && Objects.equals(vacancy, that.vacancy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, rg, nameCandidate, email, vacancy);
    }
}
