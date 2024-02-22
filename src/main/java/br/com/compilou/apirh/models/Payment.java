package br.com.compilou.apirh.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "folha_pagamento")
public class Payment extends Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
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

    public Payment() {}

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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
        Payment payment = (Payment) o;
        return Objects.equals(ID, payment.ID) && Objects.equals(cnpj, payment.cnpj) && Objects.equals(nameCompany, payment.nameCompany) && Objects.equals(addressCompany, payment.addressCompany) && Objects.equals(inss, payment.inss) && Objects.equals(fgts, payment.fgts) && Objects.equals(union, payment.union) && Objects.equals(voucher, payment.voucher) && Objects.equals(advances, payment.advances) && Objects.equals(netSalary, payment.netSalary) && Objects.equals(grossSalary, payment.grossSalary) && Objects.equals(workDays, payment.workDays) && Objects.equals(extraHours, payment.extraHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ID, cnpj, nameCompany, addressCompany, inss, fgts, union, voucher, advances, netSalary, grossSalary, workDays, extraHours);
    }
}
