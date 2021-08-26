package com.liftoff.models.data;

import com.liftoff.models.Welcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WelcomeRepository extends JpaRepository<Welcome, Integer> {
}
