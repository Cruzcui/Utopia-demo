package utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sys/role")
public class RoleManagerController {
	@RequestMapping("/roleManager.page")
	public ModelAndView role() {
		return new ModelAndView("roleManager");
	}
}
