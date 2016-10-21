package jp.co.stylez.pth.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.stylez.pth.web.form.HomeForm;
import jp.co.stylez.pth.web.service.UserService;



@Controller
public class CompleteController {

	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService userService;
	
	@PostMapping("complete")
	public String confirm(Model model,HomeForm entryForm,BindingResult result){
		if(result.hasErrors()){
			return "registration/input";
		}
		
		String test = userService.signupUser(entryForm.createUserDto());
		System.out.println(test);
		
		model.addAttribute(entryForm);
		return "registration/complete";
	}
}
