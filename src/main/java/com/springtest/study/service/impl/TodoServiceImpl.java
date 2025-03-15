package com.springtest.study.service.impl;

import com.springtest.study.dto.TodoRequest;
import com.springtest.study.dto.TodoResponse;
import com.springtest.study.entity.Todo;
import com.springtest.study.repository.TodoRespository;
import com.springtest.study.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // 생성자 주입을 위한 LomBok 어노테이션
public class TodoServiceImpl implements TodoService {
    private final TodoRespository todoRespository; // final로 선언하여 Lombok을 통해 생성자 주입

    // 작업 생성
    @Override
    public TodoResponse createTodo(TodoRequest request) {
        Todo todo = new Todo();
        todo.setTask(request.getTask());
        todo.setCompleted(false);
        Todo savedTodo = todoRespository.save(todo);

        TodoResponse todoResponse = new TodoResponse();
        todoResponse.setId(savedTodo.getId());
        todoResponse.setTask(savedTodo.getTask());
        todoResponse.setCompleted(savedTodo.isCompleted());

        return todoResponse;
    }

    // 작업 모두 가져오기
    @Override
    public List<TodoResponse> getAllTodos() {
        return todoRespository.findAll().stream()
                .map(todo -> {
                    TodoResponse todoResponse = new TodoResponse();
                    todoResponse.setId(todo.getId());
                    todoResponse.setTask(todo.getTask());
                    todoResponse.setCompleted(todo.isCompleted());
                    return todoResponse;
                })
                .collect(Collectors.toList());
    }

    // 작업 삭제
    @Override
    public void deleteTodo(Long id) {
        todoRespository.deleteById(id);
    }

    // 작업 수정

    @Override
    public TodoResponse updateTodo(Long id, TodoRequest request) {
        Todo todo = todoRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id " + id));

        todo.setTask(request.getTask());
        Todo updatedTodo = todoRespository.save(todo);

        TodoResponse todoResponse = new TodoResponse();
        todoResponse.setId(updatedTodo.getId());
        todoResponse.setTask(updatedTodo.getTask());
        todoResponse.setCompleted(updatedTodo.isCompleted());

        return todoResponse;
    }
}
