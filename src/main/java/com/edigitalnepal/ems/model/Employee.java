package com.edigitalnepal.ems.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Employee extends BaseModel {
    @ManyToOne
    User user;
    @OneToMany
    Set<Designation> designations;
}
