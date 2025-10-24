package com.YourDost.controller;

import com.YourDost.model.Todo;
import com.YourDost.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    @Autowired
    TodoRepository todoRepository ;

    @GetMapping("/")
    ResponseEntity<?> Hello(){
         return ResponseEntity.ok("Simple To-Do CRUD API Backend is Live ");
    }

    @GetMapping("/todos")
    ResponseEntity<?> getTodos(){
        List<Todo> res =  todoRepository.findAll();
        return  ResponseEntity.ok(res);
    }

    @PutMapping("/todos/{id}")
    ResponseEntity<?> updateTodos( @PathVariable("id") String id  , @RequestBody Todo data ){

        if (!todoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found");
        }

        data.setId(id);

        todoRepository.save(data); //
        return ResponseEntity.ok("todo update succesfully");
    }



}
