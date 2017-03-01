package jp.co.stylez.pth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jp.co.stylez.pth.service.impl.UserLoginService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserLoginService userLoginService;
	
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .eraseCredentials(true)
            .userDetailsService(userLoginService);
//            .passwordEncoder(passwordEncoder());
    }
	
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		
		http.authorizeRequests()
		.antMatchers("/", "/favicon.ico", "/resources/**", "/signup").permitAll()
		.anyRequest().authenticated().and()
		.formLogin()
		.loginPage("/")
		.permitAll()
		.failureUrl("/")
		.defaultSuccessUrl("/home")
		.loginProcessingUrl("/authenticate").usernameParameter("email").passwordParameter("password").and()
		.logout().logoutSuccessUrl("/")
		.and()
		.csrf().disable();
	}
    @Bean(name = "authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
