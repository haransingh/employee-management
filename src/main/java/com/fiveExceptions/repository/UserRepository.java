package com.fiveExceptions.repository;

import com.fiveExceptions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
