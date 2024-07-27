package com.SpringBootTutorial.TodoApp.TodoRepository;

import com.SpringBootTutorial.TodoApp.Todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends
        JpaRepository<Todo, Integer> {

        public List<Todo> findByUserName(String username);
}
