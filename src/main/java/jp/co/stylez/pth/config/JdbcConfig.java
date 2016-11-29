package jp.co.stylez.pth.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@PropertySource("classpath:persistence.properties")
public class JdbcConfig {

    @Value("${dataSource.driverClassName}")
    private String driver;
    @Value("${dataSource.url}")
    private String url;
    @Value("${dataSource.username}")
    private String username;
    @Value("${dataSource.password}")
    private String password;
	
    @Autowired
    BasicDataSource dataSource;
    
    
    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(driver);
    	dataSource.setUrl(url);;
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	return dataSource;
    }
    
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
    	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    	return namedParameterJdbcTemplate;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(){
    	JdbcTemplate jdbcTemplate = new JdbcTemplate();
    	jdbcTemplate.setDataSource(dataSource);
    	return jdbcTemplate;
    }
}
