package utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/content/city")
public class CityManagerController {
	@RequestMapping("/cityManager.page")
	public ModelAndView city() {
		return new ModelAndView("cityManager");
	}
}
