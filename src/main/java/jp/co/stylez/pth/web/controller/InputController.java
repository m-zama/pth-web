package jp.co.stylez.pth.web.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.stylez.pth.web.form.HomeForm;

@Controller
public class InputController {


	
	@GetMapping("input")
	public String input(Model model,HomeForm entryForm){
//		if(result.hasErrors()){
//			return "index";
//		}
		

		model.addAttribute(entryForm);
		return "registration/input";
	}
}
