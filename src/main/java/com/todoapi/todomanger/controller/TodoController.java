package com.todoapi.todomanger.controller;

import com.todoapi.todomanger.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.todoapi.todomanger.model.Todo;
import java.util.*;
@RestController
@RequestMapping("/todos")
public class TodoController {
    Logger logger= LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todoService;
    @PostMapping("/create")
    public ResponseEntity<Todo >  createTodo(@RequestBody Todo todo){
        logger.info("Create Todo");
        Todo todo1=todoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }
   @GetMapping("/getAllTodo")
    public ResponseEntity<List<Todo>> getAlltodoHandler(){
        return new ResponseEntity<>(todoService.getAllTodo(),HttpStatus.OK);
    }

    @GetMapping("/getTodo/{todoID}")
    public ResponseEntity<Todo> getTodo(@PathVariable int todoID){
        Todo todo1=todoService.getTodoWithID(todoID);
        return new ResponseEntity<>(todo1,HttpStatus.OK);
    }

    @PutMapping("/updateTodo/{todoID}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo newtodo,
                                           @PathVariable int todoID){
        Todo todo=todoService.updateTodo(todoID,newtodo);
        //return new ResponseEntity(todoService.updateTodo(todoID,newtodo),
        // HttpStatus.OK);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/deleteTodo/{todoID}")
    public ResponseEntity<String> deleteTodo(@PathVariable int todoID){
        todoService.deleteTodo(todoID);
        return ResponseEntity.ok("Successfully deleted");
    }
}
