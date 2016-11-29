package jp.co.stylez.pth.web.controller;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.stylez.pth.service.ResourceService;
import jp.co.stylez.pth.web.bean.JsonBean;
import jp.co.stylez.pth.web.form.HomeForm;

@Controller
public class IndexController {


	@Autowired
	ResourceService resourceService;
	
	@RequestMapping(value = "/",method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model,Locale locale) throws IOException{
		HomeForm entryForm = new HomeForm();
		model.addAttribute(entryForm);
		
		JsonBean jsonBean = resourceService.accessJsonResource();
		model.addAttribute(jsonBean);
		
		return "index";
	}
}
