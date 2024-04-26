package com.project.project.repository;

import com.project.project.entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<OurUsers, Long> {
    Optional<OurUsers> findByUsername(String username);
    boolean existsByUsername(String username);
}
