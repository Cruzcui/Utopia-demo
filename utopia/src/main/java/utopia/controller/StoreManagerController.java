package utopia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/content/store")
public class StoreManagerController {
	@RequestMapping("/storeManager.page")
	public ModelAndView store() {
		return new ModelAndView("storeManager");
	}
}
