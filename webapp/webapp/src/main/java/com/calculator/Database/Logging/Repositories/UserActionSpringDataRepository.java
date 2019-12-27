package com.calculator.Database.Logging.Repositories;

import com.calculator.Database.Logging.Entities.UserActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActionSpringDataRepository extends JpaRepository<UserActionEntity, Integer> {
}
