package utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sys/log")
public class LogManagerController {
	@RequestMapping("/logManager.page")
	public ModelAndView log() {
		return new ModelAndView("logManager");
	}
}
