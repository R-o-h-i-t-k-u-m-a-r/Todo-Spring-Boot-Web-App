package com.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.todo.model.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static  int todosCount;

	static {
		todos.add(new Todo(++todosCount, "rohit", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "rohit", "Learn DevOps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "rohit", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}
	
//	public List<Todo> findByUsername(String username){
//		return todos;
//	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}

	public void deleteTodo(int id) {
		//List<Todo> collect = todos.stream().filter(todo->todo.getId()!=id).collect(Collectors.toList());
		//todos = collect;
		todos.removeIf(todo->todo.getId()==id);
		
	}

	public Todo findById(int id) {
		Todo result = todos.stream().filter(todo->todo.getId()==id).findFirst().get();
		return result;
	}

	public void updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		//Todo result = findById(todo.getId());
		//result.setDescription(todo.getDescription());
		todos.stream()
		.filter(x->x.getId()==todo.getId())
		.findFirst()
		.ifPresent(x->{
			x.setDescription(todo.getDescription());
			x.setTargetDate(todo.getTargetDate());
		});
		
	}

}
