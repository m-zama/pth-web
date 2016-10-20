package jp.co.stylez.zama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.stylez.zama.form.EntryForm;

@Controller
public class CompleteController {

	@PostMapping("complete")
	public String confirm(Model model,EntryForm entryForm,BindingResult result){
		if(result.hasErrors()){
			return "registration/input";
		}
		model.addAttribute(entryForm);
		return "registration/complete";
	}
}
