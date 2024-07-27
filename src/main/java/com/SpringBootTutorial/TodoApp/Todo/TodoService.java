package com.SpringBootTutorial.TodoApp.Todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class TodoService {
    public static List<Todo> todos = new ArrayList<>();
    private static int todoCount=1;
    static {
        todos.add(new Todo(todoCount++,"ayon","To do 1", LocalDate.now(),false)) ;
        todos.add(new Todo(todoCount++,"ayon","To do 2", LocalDate.now(),false)) ;
        todos.add(new Todo(todoCount++,"ayon","To do 3", LocalDate.now(),false)) ;
    }
    public void addTodo(String username, String description , LocalDate date,boolean done){
        todos.add(new Todo(
                todoCount++,username,description,date,done
        ));
    }

    public int getTodoCount(){
        return todoCount;
    }

    public void deleteById(int id){
        Todo toDelete = null;
        for(Todo todo : todos){
            if(todo.getSerialNo()==id) {
                toDelete=todo;
                break;
            }
        }
        todos.remove(toDelete);
    }

    public Todo findById(int id){
        for(Todo todo : todos){
            if(todo.getSerialNo()==id) {
                return todo;
            }
        }
        return null;
    }

    public void update(Todo todo){
        Todo toDelete = this.findById(todo.getSerialNo());
        todos.remove(toDelete);
        todos.add(todo);
    }

    public List<Todo> findTodosByUsername(String name){
        List<Todo> filteredTodos = new ArrayList<>();
        for(Todo todo : todos){
            if(todo.getUserName().equals(name)) filteredTodos.add(todo);
        }
        return filteredTodos;
    }
}
