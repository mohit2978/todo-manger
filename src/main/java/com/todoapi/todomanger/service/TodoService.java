package com.todoapi.todomanger.service;

import com.todoapi.todomanger.dao.TodoDao;
import com.todoapi.todomanger.exceptions.ResourceNotFoundException;
import com.todoapi.todomanger.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Component
public class TodoService {
    @Autowired
   TodoDao todoDao;
   Logger logger= LoggerFactory.getLogger(TodoService.class);
   Random rand=new Random();
    public Todo createTodo(Todo todo){

        todo.setCreationDate(new Date());
        todoDao.saveTodo(todo);
        logger.info("added todo"+todo );
        return todo;
    }
    public List<Todo> getAllTodo() {
        return todoDao.getAllTodo();
    }

    public Todo getTodoWithID(int todoID) {
        Todo t1= todoDao.getTodo(todoID);
        logger.info("todo is"+t1);
        return t1;
    }

    public Todo updateTodo(int todoID,Todo newtodo) {
       todoDao.updateTodo(todoID,newtodo);
        return newtodo;
    }

    public void deleteTodo(int todoID) {
       todoDao.deleteTodo(todoID);
    }
}
