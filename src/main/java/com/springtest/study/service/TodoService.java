package com.springtest.study.service;

import com.springtest.study.dto.TodoRequest;
import com.springtest.study.dto.TodoResponse;

import java.util.List;

public interface TodoService {
    TodoResponse createTodo(TodoRequest request);
    List<TodoResponse> getAllTodos();
    void deleteTodo(Long id);
    TodoResponse updateTodo(Long id, TodoRequest request);
}
