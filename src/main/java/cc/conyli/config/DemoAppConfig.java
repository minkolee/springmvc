package cc.conyli.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "cc.conyli")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Autowired
    private Environment environment;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public DataSource securityDataSource() {
        //利用C3PO创建连接池
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
        //设置连接池对象的数据库属性
        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
            securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
            securityDataSource.setUser(environment.getProperty("jdbc.user"));
            securityDataSource.setPassword(environment.getProperty("jdbc.password"));

            logger.info(">>>> jdbc.url=" + environment.getProperty("jdbc.url"));
            logger.info(">>>> jdbc.user=" + environment.getProperty("jdbc.user"));
        } catch (PropertyVetoException ex) {
            throw new RuntimeException(ex);
        }
        //设置连接池的连接属性
        securityDataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
        securityDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
        securityDataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
        securityDataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

        return securityDataSource;
    }

}
