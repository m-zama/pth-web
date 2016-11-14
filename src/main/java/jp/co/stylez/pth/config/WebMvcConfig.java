package jp.co.stylez.pth.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("jp.co.stylez.pth.web.controller")
public class WebMvcConfig extends WebMvcConfigurerAdapter{

//	   private static final String MESSAGE_SOURCE = "classpath:messages.properties";
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry){
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
//    @Bean(name = "messageSource")
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename(MESSAGE_SOURCE);
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setCacheSeconds(5);
//        return messageSource;
//    }
}
