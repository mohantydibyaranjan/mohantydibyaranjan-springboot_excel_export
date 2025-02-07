package com.nt.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EMP")
public class Emp {

    @Id
    @Column(name = "EMPNO")
    private Integer empNo;

    @Column(name = "ENAME")
    private String eName; // Mapped to the ENAME column in the database

    @Column(name = "JOB")
    private String job;

    @Column(name = "MGR")
    private Integer mgr;

    @Column(name = "HIREDATE")
    private LocalDate hireDate;

    @Column(name = "SAL")
    private Double sal;

    @Column(name = "COMM")
    private Double comm;

    @Column(name = "DEPTNO")
    private Integer deptNO;

    @Column(name = "CMM")
    private Integer cmm;

    @Column(name = "DEPT_NO")
    private Integer dept_no;

    @Column(name = "E_NAME")
    private String e_name; // This maps to the E_NAME column in the database

    @Column(name = "HIRE_DATE")
    private LocalDate hire_date; // Mapped to HIRE_DATE in the database

    @Column(name = "SALARY")
    private Double salary; // Mapped to SALARY in the database
}
