package com.khariit;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArRootRepository
    extends JpaRepository<Root, Integer>{
}
