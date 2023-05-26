package com.todoapi.todomanger.service;

import com.todoapi.todomanger.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Component
public class TodoService {
   List<Todo> todoDB=new ArrayList<>();
   Logger logger= LoggerFactory.getLogger(TodoService.class);
   Random rand=new Random();
    public Todo createTodo(Todo todo){
        int id= rand.nextInt((int)1e8);
        todo.setTodoId(id);
        todoDB.add(todo);
        logger.info("added todo"+todo );
        return todo;
    }
    public List<Todo> getAllTodo() {
        return todoDB;
    }

    public Todo getTodoWithID(int todoID) {
        Todo t1= todoDB.stream().filter(todo -> todoID==todo.getTodoId())
                .findAny().get();
        logger.info("todo is"+t1);
        return t1;
    }

    public Todo updateTodo(int todoID,Todo newtodo) {
        List<Todo>newtodoDB=todoDB.stream().map(t->{
            if(t.getTodoId()==todoID){
                t.setContent(newtodo.getContent());
                t.setTitle(newtodo.getTitle());
                t.setStatus(newtodo.getStatus());
                return t;
            }else{
                return t;
            }
        }).collect(Collectors.toList());
        todoDB=newtodoDB;
        return newtodo;
    }

    public void deleteTodo(int todoID) {
       List<Todo>newDB= todoDB.stream().filter(t->t.getTodoId()!=todoID)
                .collect(Collectors.toList());
       todoDB=newDB;
    }
}
