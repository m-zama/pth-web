package jp.co.stylez.pth.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@ComponentScan("jp.co.stylez.pth.web.controller")
@EnableAspectJAutoProxy
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private static final String MESSAGE_SOURCE = "classpath:messages";

    private static final String RESOURCES_LOCATION = "/resources/";
    private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";

    private static final String JAVA_SCRIPT_LOCATION = "/js/";
    private static final String JAVA_SCRIPT_HANDLER = JAVA_SCRIPT_LOCATION + "**";

    private static final String CSS_LOCATION = "/css/";
    private static final String CSS_HANDLER = CSS_LOCATION + "**";
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
        .addResourceHandler(RESOURCES_HANDLER, JAVA_SCRIPT_HANDLER, CSS_HANDLER)
        .addResourceLocations(RESOURCES_LOCATION, JAVA_SCRIPT_LOCATION, CSS_LOCATION);
    }

	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(MESSAGE_SOURCE);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(5);
		return messageSource;
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieName("locale");
		resolver.setDefaultLocale(Locale.JAPANESE);
		return resolver;
	}
	
	@Bean
	public ObjectMapper objectMapper(){
		return Jackson2ObjectMapperBuilder.json().build();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new LocaleChangeInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/resource/**")
		.excludePathPatterns("/**/*.html");
	}
}
