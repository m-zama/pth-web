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

import jp.co.stylez.pth.service.UserService;
import jp.co.stylez.pth.web.entity.UserEntity;
import jp.co.stylez.pth.web.form.HomeForm;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	// @Autowired
	// private UserDao userDao;

	@GetMapping("home")
	public String entry(Model model) {
		List<UserEntity> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "home/home";
	}

	@PostMapping("home")
	public String entry(Model model, @Validated @ModelAttribute HomeForm homeForm, BindingResult result) {
		if (result.hasErrors()) {
			return "/index";
		}
		// JPA
		List<UserEntity> userList = userService.findAll();
		model.addAttribute("userList", userList);

		// SpringJDBC
		// List<UserBean> userList = userDao.findAll();
		// model.addAttribute("userList",userList);

		return "home/home";
	}
}
