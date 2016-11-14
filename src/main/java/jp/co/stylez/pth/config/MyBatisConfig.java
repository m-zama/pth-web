package jp.co.stylez.pth.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@Configuration
//@PropertySource("classpath:persistence.properties")
//@MapperScan("jp.co.stylez.pth.web.mapper")
public class MyBatisConfig {

    @Value("${dataSource.driverClassName}")
    private String driver;
    @Value("${dataSource.url}")
    private String url;
    @Value("${dataSource.username}")
    private String username;
    @Value("${dataSource.password}")
    private String password;
    @Value("${sqlSessionFactoryBean.configLocation}")
    private Resource configLocation;
    
    @Autowired
    private DriverManagerDataSource dataSource;
    
    @Bean(destroyMethod = "close")
    public DriverManagerDataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName(driver);
    	dataSource.setUrl(url);;
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    	sqlSessionFactoryBean.setDataSource(dataSource);
        return (SqlSessionFactory)sqlSessionFactoryBean.getObject();
    }

}
