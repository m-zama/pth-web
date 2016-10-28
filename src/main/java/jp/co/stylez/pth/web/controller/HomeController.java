package jp.co.stylez.pth.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.stylez.pth.web.dto.UserDto;
import jp.co.stylez.pth.web.form.HomeForm;
import jp.co.stylez.pth.web.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@GetMapping("home")
	public String entry(Model model){
		List<UserDto> userList = userService.findUserAll();
		model.addAttribute("userList",userList);
		return "home/home";
	}
	@PostMapping("home")
	public String entry(Model model,@Validated @ModelAttribute HomeForm entryForm,BindingResult result){
		if(result.hasErrors()){
			return "/index";
		}
		List<UserDto> userList = userService.findUserAll();
		model.addAttribute("userList",userList);
		return "home/home";
	}
}
