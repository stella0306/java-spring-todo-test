package com.springtest.study.repository;

import com.springtest.study.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRespository extends JpaRepository<Todo, Long> {
}
