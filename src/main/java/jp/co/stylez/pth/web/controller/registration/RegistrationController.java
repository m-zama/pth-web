package jp.co.stylez.pth.web.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.stylez.pth.service.UserService;
import jp.co.stylez.pth.web.form.HomeForm;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	// SpringJdbc
	// @Autowired
	// private UserDao userDao;

	@GetMapping("input")
	public String input(Model model, HomeForm homeForm) {

		model.addAttribute(homeForm);
		return "registration/input";
	}

	@PostMapping("confirm")
	public String confirm(Model model, @Validated HomeForm homeForm, BindingResult result) {
		if (result.hasErrors()) {
			return "registration/input";
		}
		model.addAttribute(homeForm);
		return "registration/confirm";
	}

	@PostMapping("complete")
	public String complete(Model model, HomeForm homeForm, BindingResult result) {
		if (result.hasErrors()) {
			return "registration/input";
		}
		// SpringJdbc
		// userDao.insertUser(entryForm.createUserBean());
		
		// JPA
		userService.createUser(homeForm.createUserEntity());

		model.addAttribute(homeForm);
		return "registration/complete";
	}
}
