package jp.co.stylez.zama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.stylez.zama.form.EntryForm;

@Controller
public class ConfirmController {

	@PostMapping("confirm")
	public String confirm(Model model,@Validated @ModelAttribute EntryForm entryForm,BindingResult result){
		if(result.hasErrors()){
			return "registration/input";
		}
		model.addAttribute(entryForm);
		return "registration/confirm";
	}
}
