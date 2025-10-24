package com.YourDost.controller;

import com.YourDost.model.Todo;
import com.YourDost.repository.TodoRepository;
import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @PostMapping("/todos")
    ResponseEntity<?> addTodos( @RequestBody Todo data ){

        if(data.getTitle() == "" || data.getTitle() == null){
            return ResponseEntity.badRequest().body("pls add the title");
        }

        Optional<Todo> res= Optional.of(todoRepository.save(data));
        return ResponseEntity.ok(res) ;
    }

    @PutMapping("/todos/{id}")
    ResponseEntity<?> updateTodos( @PathVariable("id") String id  , @RequestBody Todo saveData ){

        if (!todoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found");
        }

        saveData.setId(id);
        todoRepository.save(saveData); //
    return ResponseEntity.ok("todo update successfully");
    }

    @DeleteMapping("/todos/{id}")
    ResponseEntity<?> deleteTodos( @PathVariable("id") String id  ){

        if (!todoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found");
        }

        todoRepository.deleteById(id);

        return ResponseEntity.ok("todo delete successfully");
    }


}
