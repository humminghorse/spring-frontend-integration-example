package info.keik.todo.app;

import info.keik.todo.model.Todo;
import info.keik.todo.service.TodoService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("todos", todoService.getAll());
		return "todos";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Todo> create(Todo todo) {
		todo.setId(new Date().getTime());
		return new ResponseEntity<Todo>(todoService.add(todo), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestParam("complete") Boolean complete) {
		if (complete)
			todoService.complete(id);
		else
			todoService.uncomplete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Void> destroy(@PathVariable Long id) {
		todoService.destroy(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
