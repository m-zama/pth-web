package jp.co.stylez.pth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.stylez.pth.web.form.HomeForm;

@Controller
public class IndexController {

	@RequestMapping(value = "/",method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
		HomeForm entryForm = new HomeForm();
		model.addAttribute(entryForm);
		return "index";
	}
}
