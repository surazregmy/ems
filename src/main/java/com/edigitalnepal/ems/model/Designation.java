package com.edigitalnepal.ems.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Designation extends BaseModel {
    String title;
    String organization;
    String dateOfJoined;
    @ManyToOne
    User user;
}
