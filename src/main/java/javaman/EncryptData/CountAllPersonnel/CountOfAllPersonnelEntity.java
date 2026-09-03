package javaman.EncryptData.CountAllPersonnel;


import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vw_status_definition_category_count")
@Immutable
@Getter
@Setter
public class CountOfAllPersonnelEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "active")
    private Long active;

    @Column(name = "active_enlisted")
    private Long activeEnlisted;

    @Column(name = "active_officer")
    private Long activeOfficer;

    @Column(name = "awol")
    private Long awol;

    @Column(name = "change_fosrating")
    private Long changeFosrating;

    @Column(name = "discharge")
    private Long discharge;

    @Column(name = "disease")
    private Long disease;

    @Column(name = "due_for_retirement")
    private Long dueForRetirement;

    @Column(name = "relieved")
    private Long relieved;

    @Column(name = "resigned")
    private Long resigned;

    @Column(name = "retired")
    private Long retired;
}

