package com.todoapi.todomanger.dao;


import com.todoapi.todomanger.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoDao {

    JdbcTemplate jdbcTemplate;
    Logger logger= LoggerFactory.getLogger(this.getClass());

    TodoDao(@Autowired JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
        String query="Create table IF NOT EXISTS todomanager.Todo (" +
                "id int primary key,title varchar(255),content varchar(500)," +
                "status boolean ,tododate datetime,creationdate datetime)";
        int val=jdbcTemplate.update(query);
        logger.info("TODo TABLE CREATED");
    }


    //save todo in DB
    public Todo saveTodo(Todo todo){
        String query="Insert into todomanager.todo(id,title,content,status,tododate,creationdate)" +
                "values(?,?,?,?,?,?)";
        //you can also put all the question mark value as parameter update() function
        //take var args
        //jdbcTemplate.update(query,todo.getTodoId(),todo.getTitle(),
        //                todo.getContent(),todo.getStatus()
        //        ,todo.getTodoDate(),todo.getCreationDate()); is valid
        int rowAfftected=jdbcTemplate.update(query,new Object[]{todo.getTodoId(),todo.getTitle(),
                todo.getContent(),todo.getStatus(),
                todo.getTodoDate(),todo.getCreationDate()});
        logger.info("Rows Affected {} ",rowAfftected);
        return todo;
    }

    //get singleToDo
    public Todo getTodo(int id){
        String query="Select * from todomanager.todo where id=?";
        Todo todo=jdbcTemplate.queryForObject(query,
                new BeanPropertyRowMapper<Todo>(Todo.class),new Object[]{id});
        return todo;
    }

    public List<Todo> getAllTodo(){
        String query="Select * from todomanager.todo";
        List<Todo> todo=jdbcTemplate.query(query,
                new BeanPropertyRowMapper<Todo>(Todo.class));
        return todo;
    }

    public Todo updateTodo(Todo todo){
        String query="Update todomanager.todo set title=?,content=?," +
                "status=?,tododate=?,creationdate=?" +
                "where id=?";
        int rowAfftected=jdbcTemplate.update(query,new Object[]{todo.getTitle(),
                todo.getContent(),todo.getStatus(),
                todo.getTodoDate(),todo.getCreationDate(),todo.getTodoId()});
        logger.info("Rows Affected {} ",rowAfftected);
        return todo;
    }

    public  void deleteTodo(int id){
        String query="Delete from todomanager.todo where id=?";
        int row=jdbcTemplate.update(query,new Object[]{id});
        logger.info("Row affected {}",row);
    }
}
