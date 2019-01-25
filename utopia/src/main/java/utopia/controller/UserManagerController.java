package utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sys/user")
public class UserManagerController {
	@RequestMapping("/userManager.page")
	public ModelAndView user() {
		return new ModelAndView("userManager");
	}
}
