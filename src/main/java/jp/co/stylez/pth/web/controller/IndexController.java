package jp.co.stylez.pth.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.stylez.pth.service.ResourceService;
import jp.co.stylez.pth.service.UserService;
import jp.co.stylez.pth.web.bean.JsonBean;
import jp.co.stylez.pth.web.entity.UserEntity;
import jp.co.stylez.pth.web.form.LoginForm;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	
	@Autowired
	ResourceService resourceService;
	
	@RequestMapping(value = "/",method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model,Locale locale) throws IOException{
		LoginForm loginForm = new LoginForm();
		model.addAttribute(loginForm);
		
		JsonBean jsonBean = resourceService.accessJsonResource();
		model.addAttribute(jsonBean);
		
		// JPA
		List<UserEntity> userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		return "index";
	}
}
