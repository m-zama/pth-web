package jp.co.stylez.zama.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.stylez.zama.form.EntryForm;

@Controller
public class InputController {

	@GetMapping("input")
	public String input(Model model,EntryForm entryFrom){
//		if(result.hasErrors()){
//			return "index";
//		}
		model.addAttribute(entryFrom);
		return "registration/input";
	}
}
