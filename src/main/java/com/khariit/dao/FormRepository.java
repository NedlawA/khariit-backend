package com.khariit.dao;

import com.khariit.models.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormRepository extends JpaRepository<Form, Integer> {
    List findByRootId(Integer rootId);

}
