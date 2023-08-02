package com.khariit.dao;
import java.util.List;

import com.khariit.models.Root;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArRootRepository
    extends JpaRepository<Root, Integer> {

    Iterable findByEngLetters(String engLetters);
    Iterable findByLetters(String letters);

}
