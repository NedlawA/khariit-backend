package com.khariit;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArRootRepository
    extends JpaRepository<Root, Integer> {

    List<Root> findByEngLetters(String engLetters);
    List<Root> findByLetters(String letters);

}
