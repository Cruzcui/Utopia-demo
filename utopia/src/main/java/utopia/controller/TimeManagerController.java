package utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("content/time")
public class TimeManagerController {
	@RequestMapping("/timeManager.page")
	public ModelAndView time() {
		return new ModelAndView("timeManager");
	}
}
