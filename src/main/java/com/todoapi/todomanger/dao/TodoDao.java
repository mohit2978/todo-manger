package com.todoapi.todomanger.dao;


import com.todoapi.todomanger.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
        String query="Insert into Todos(id,title,content,status,tododate,creationdate)" +
                "values(?,?,?,?,?,?)";
        //you can also put all the question mark value as parameter update() function
        //take var args
        //jdbcTemplate.update(query,todo.getTodoId(),todo.getTitle(),
        //                todo.getContent(),todo.getStatus()
        //        ,todo.getTodoDate(),todo.getCreationDate()); is valid
        int rowAfftected=jdbcTemplate.update(query,new Object[]{todo.getTodoId(),todo.getTitle(),
                todo.getContent(),todo.getStatus()
        ,todo.getTodoDate(),todo.getCreationDate()});
        logger.info("Rows Affected {} ",rowAfftected);
        return todo;
    }

}
