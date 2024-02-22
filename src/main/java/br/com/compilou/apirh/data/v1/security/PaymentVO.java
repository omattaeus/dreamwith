package br.com.compilou.apirh.data.v1.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class PaymentVO extends RepresentationModel<EmployeeVO>
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private long key;
    private String cnpj;
    private String nameCompany;
    private String addressCompany;
    private BigDecimal inss;
    private BigDecimal fgts;
    private BigDecimal union;
    private BigDecimal voucher;
    private BigDecimal advances;
    private BigDecimal netSalary;
    private BigDecimal grossSalary;
    private Date workDays;
    private Date extraHours;

    public PaymentVO(){}

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getAddressCompany() {
        return addressCompany;
    }

    public void setAddressCompany(String addressCompany) {
        this.addressCompany = addressCompany;
    }

    public BigDecimal getInss() {
        return inss;
    }

    public void setInss(BigDecimal inss) {
        this.inss = inss;
    }

    public BigDecimal getFgts() {
        return fgts;
    }

    public void setFgts(BigDecimal fgts) {
        this.fgts = fgts;
    }

    public BigDecimal getUnion() {
        return union;
    }

    public void setUnion(BigDecimal union) {
        this.union = union;
    }

    public BigDecimal getVoucher() {
        return voucher;
    }

    public void setVoucher(BigDecimal voucher) {
        this.voucher = voucher;
    }

    public BigDecimal getAdvances() {
        return advances;
    }

    public void setAdvances(BigDecimal advances) {
        this.advances = advances;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(BigDecimal netSalary) {
        this.netSalary = netSalary;
    }

    public BigDecimal getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(BigDecimal grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Date getWorkDays() {
        return workDays;
    }

    public void setWorkDays(Date workDays) {
        this.workDays = workDays;
    }

    public Date getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(Date extraHours) {
        this.extraHours = extraHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PaymentVO paymentVO = (PaymentVO) o;
        return key == paymentVO.key && Objects.equals(cnpj, paymentVO.cnpj) && Objects.equals(nameCompany, paymentVO.nameCompany) && Objects.equals(addressCompany, paymentVO.addressCompany) && Objects.equals(inss, paymentVO.inss) && Objects.equals(fgts, paymentVO.fgts) && Objects.equals(union, paymentVO.union) && Objects.equals(voucher, paymentVO.voucher) && Objects.equals(advances, paymentVO.advances) && Objects.equals(netSalary, paymentVO.netSalary) && Objects.equals(grossSalary, paymentVO.grossSalary) && Objects.equals(workDays, paymentVO.workDays) && Objects.equals(extraHours, paymentVO.extraHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, cnpj, nameCompany, addressCompany, inss, fgts, union, voucher, advances, netSalary, grossSalary, workDays, extraHours);
    }
}
