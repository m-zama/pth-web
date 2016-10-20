package jp.co.stylez.zama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.stylez.zama.form.EntryForm;

@Controller
public class indexController {

	@RequestMapping(value = "/",method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
		EntryForm entryForm = new EntryForm();
		model.addAttribute(entryForm);
		return "index";
	}
}
