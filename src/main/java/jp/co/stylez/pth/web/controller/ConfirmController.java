package jp.co.stylez.pth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.stylez.pth.web.form.HomeForm;

@Controller
public class ConfirmController {

	@PostMapping("confirm")
	public String confirm(Model model,@Validated @ModelAttribute HomeForm homeForm,BindingResult result){
		if(result.hasErrors()){
			return "registration/input";
		}
		model.addAttribute(homeForm);
		return "registration/confirm";
	}
}
