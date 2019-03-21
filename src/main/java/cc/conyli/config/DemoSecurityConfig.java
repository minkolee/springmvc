package cc.conyli.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //使用不加密的密码验证
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        //使用数据连接池作为验证来源
        auth.jdbcAuthentication().dataSource(securityDataSource);

        //添加用户，使用内存验证
//        auth.inMemoryAuthentication()
//                .withUser(users.username("jenny").password("test123").roles("EMPLOYEE", "MANAGER", "ADMIN"))
//                .withUser(users.username("minko").password("test123").roles("EMPLOYEE", "MANAGER"))
//                .withUser(users.username("cony").password("test123").roles("EMPLOYEE"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leader/**").hasRole("MANAGER")
                .antMatchers("/system/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied/");
    }

    @Autowired
    private DataSource securityDataSource;
}
