package com.liftoff.models.data;

import com.liftoff.models.Welcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UIRepository extends JpaRepository<Welcome, Integer> {
}
