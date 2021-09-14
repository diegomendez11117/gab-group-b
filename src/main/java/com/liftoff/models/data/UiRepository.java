package com.liftoff.models.data;

import com.liftoff.models.Ui;
import com.liftoff.models.Welcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UiRepository extends JpaRepository<Ui, Integer> {
}
