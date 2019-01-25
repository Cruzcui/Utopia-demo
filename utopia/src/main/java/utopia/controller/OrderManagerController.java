package utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reserve/order")
public class OrderManagerController {
	@RequestMapping("/orderManager.page")
	public ModelAndView order() {
		return new ModelAndView("orderManager");
	}
}
