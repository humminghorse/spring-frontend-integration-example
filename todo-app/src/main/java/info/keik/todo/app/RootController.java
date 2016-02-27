package info.keik.todo.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

	@RequestMapping
	public String root() {
		return "redirect:/todos";
	}

}
