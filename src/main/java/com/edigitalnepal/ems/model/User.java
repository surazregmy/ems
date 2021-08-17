package com.edigitalnepal.ems.model;

import javax.persistence.Entity;

@Entity
public class User extends BaseModel {
    String username;
    String password;
}
