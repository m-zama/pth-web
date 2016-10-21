package jp.co.stylez.pth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.stylez.pth.web.form.HomeForm;

@Controller
public class HomeController {

	@GetMapping("home")
	public String entry(){
		return "home/home";
	}
	@PostMapping("home")
	public String entry(Model model,@Validated @ModelAttribute HomeForm entryForm,BindingResult result){
		if(result.hasErrors()){
			return "/index";
		}
		return "home/home";
	}
}
