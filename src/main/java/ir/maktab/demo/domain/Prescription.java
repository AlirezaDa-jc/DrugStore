package ir.maktab.demo.domain;

import ir.maktab.demo.base.domains.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alireza.d.a
 */
@NoArgsConstructor
@Data
@Entity
public class Prescription  extends BaseEntity<Long> implements Serializable {

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String issueDate;

    @Column(nullable = false)
    private String visitDate;

    @ManyToOne
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        patient.addPrescription(this);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
}
