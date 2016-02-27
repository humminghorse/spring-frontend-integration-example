package info.keik.todo.service;

import info.keik.todo.model.Todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoServiceMock implements TodoService {

	private List<Todo> todos = new ArrayList<>();

	{
		todos.add(new Todo(1L, "Attach signature", true));
		todos.add(new Todo(2L, "Buy milk", false));
		todos.add(new Todo(3L, "Call Carol", false));
	}

	@Override
	public List<Todo> getAll() {
		return todos;
	}

	@Override
	public Todo add(Todo todo) {
		todos.add(todo);
		return todo;
	}

	@Override
	public void complete(Long id) {
		toggleComplete(id, true);
	}

	@Override
	public void uncomplete(Long id) {
		toggleComplete(id, false);
	}

	private void toggleComplete(Long id, Boolean complete) {
		Todo targetTodo = todos.stream()
				.filter(todo -> id.equals(todo.getId()))
				.findAny()
				.get();

		targetTodo.setComplete(complete);
	}

	@Override
	public void destroy(Long id) {
		Todo destroyee = todos.stream()
				.filter(todo -> id.equals(todo.getId()))
				.findAny()
				.get();

		todos.remove(destroyee);
	}
}
