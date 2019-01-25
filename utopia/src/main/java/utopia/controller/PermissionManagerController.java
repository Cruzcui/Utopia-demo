package utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sys/permission")
public class PermissionManagerController {
	@RequestMapping("/permissionManager.page")
	public ModelAndView permission() {
		return new ModelAndView("permissionManager");
	}
}
