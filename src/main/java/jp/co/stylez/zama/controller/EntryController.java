package jp.co.stylez.zama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.stylez.zama.form.EntryForm;

@Controller
public class EntryController {

	@GetMapping("home")
	public String entry(){
		return "redirect:/";
	}
	@PostMapping("home")
	public String entry(Model model,@Validated @ModelAttribute EntryForm entryForm,BindingResult result){
		if(result.hasErrors()){
			return "/index";
		}
		return "home/home";
	}
}
