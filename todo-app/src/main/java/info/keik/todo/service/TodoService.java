package info.keik.todo.service;

import info.keik.todo.model.Todo;

import java.util.List;

public interface TodoService {

	/**
	 * @return all todos
	 */
	List<Todo> getAll();

	/**
	 * @param todo new todo to add
	 * @return added todo a
	 */
	Todo add(Todo todo);

	/**
	 * @param id id of todo to complete
	 */
	void complete(Long id);

	/**
	 * @param id id of todo to uncomplete
	 */
	void uncomplete(Long id);

	/**
	 * @param id id of todo to destroy
	 */
	void destroy(Long id);

}
