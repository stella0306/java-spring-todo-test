package com.springtest.study.controller;

import com.springtest.study.dto.TodoRequest;
import com.springtest.study.dto.TodoResponse;
import com.springtest.study.entity.Todo;
import com.springtest.study.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor // 생성자 주입을 위한 Lombok 어노테이션
public class TodoController {

    private final TodoService todoService; // final로 선언하여 Lombok을 통해 생성자 주입

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest request) {
        TodoResponse todoResponse = todoService.createTodo(request);
        return new ResponseEntity<>(todoResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TodoResponse> getAllTodos() {
        return todoService.getAllTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(
            @PathVariable Long id,
            @RequestBody TodoRequest request) {
        TodoResponse todoResponse = todoService.updateTodo(id, request);
        return new ResponseEntity<>(todoResponse, HttpStatus.OK);
    }
}
