package com.todoapi.todomanger.dao;


import com.todoapi.todomanger.model.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo=new Todo();
        todo.setTodoId(rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setStatus(rs.getBoolean("status"));
        todo.setCreationDate(rs.getDate("creationdate"));
        todo.setTodoDate(rs.getDate("tododate"));
        return todo;
    }
}
