package com.SpringBootTutorial.TodoApp.TodoController;

import com.SpringBootTutorial.TodoApp.Todo.Todo;
import com.SpringBootTutorial.TodoApp.Todo.TodoService;
import com.SpringBootTutorial.TodoApp.TodoRepository.TodoRepository;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoApplicationControl {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository ;


    @RequestMapping("/todo-list")
    public String getTodoList(ModelMap modelMap){

        List<Todo> todos = todoRepository.findByUserName( getUsername() );
        modelMap.put("todos",todos);
        return "todoList";
    }

    @RequestMapping(value="/add-todo" , method = RequestMethod.GET)
    public String addTodo(ModelMap map){
        String name = getUsername();
        Todo todo = new Todo(todoService.getTodoCount() ,name , "",
                LocalDate.now().plusYears(1) ,false);
        map.put("todo" , todo);
        return "addTodo";
    }

    @RequestMapping(value="/add-todo" , method = RequestMethod.POST)
    public String addedTodo( ModelMap map, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()) {
            return "addTodo" ;
        }

        String name = getUsername();
        todo.setUserName(name);
        todoRepository.save(todo);

        return "redirect:todo-list";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        return "redirect:todo-list";
    }

    @RequestMapping(value="update-todo" , method = RequestMethod.GET)
    public String updateTodoGet(@RequestParam int id, ModelMap map){
        Todo todo = todoRepository.findById(id).get();
        map.put("todo",todo);
        return "addTodo";
    }

    @RequestMapping(value="update-todo" , method = RequestMethod.POST)
    public String updateTodoPost(@Valid  Todo todo, ModelMap map){
        todo.setUserName(getUsername());
        todoRepository.save(todo);
        return "redirect:todo-list";
    }

    public String getUsername(){
        Authentication authentication =
                SecurityContextHolder.getContext()
                        .getAuthentication();
        return authentication.getName();
    }

}
