package com.todoapi.todomanger;

import com.todoapi.todomanger.dao.TodoDao;
import com.todoapi.todomanger.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

import static java.time.LocalTime.now;

@SpringBootApplication
public class TodoMangerApplication implements CommandLineRunner {
	@Autowired
     TodoDao todoDao;
	public static void main(String[] args) {

		SpringApplication.run(TodoMangerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Todo> res=todoDao.getAllTodo();
		res.stream().forEach(s-> System.out.println(s));
		todoDao.deleteTodo(111);
		System.out.println("After--------------------------------");
		List<Todo> res1=todoDao.getAllTodo();
		res1.stream().forEach(s-> System.out.println(s));
	}
}
