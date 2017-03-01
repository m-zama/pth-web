package jp.co.stylez.pth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.stylez.pth.web.form.LoginForm;

@Controller
public class LoginController {

	@PostMapping("login")
	public ModelAndView execute(@Validated LoginForm form, BindingResult result) {
		ModelAndView mv = new ModelAndView("forward:/home");
		if (result.hasErrors()) {
			mv.setViewName("redirect:/");
			return (mv);
		}

		return (mv);
	}
}
