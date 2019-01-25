package utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/content/villa")
public class VillaManagerController {
	@RequestMapping("/villaManager.page")
	public ModelAndView villa() {
		return new ModelAndView("villaManager");
	}
}
