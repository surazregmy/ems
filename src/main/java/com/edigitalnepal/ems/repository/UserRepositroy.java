package com.edigitalnepal.ems.repository;

import com.edigitalnepal.ems.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositroy extends JpaRepository<User, Long> {
}
