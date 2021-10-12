package com.smeekens.eindopdracht.eindopdracht.repository;

import com.smeekens.eindopdracht.eindopdracht.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
