package cc.conyli.config;

import cc.conyli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider());


        //使用不加密的密码验证
//        User.UserBuilder users = User.withDefaultPasswordEncoder();

        //使用数据连接池作为验证来源
//        auth.jdbcAuthentication().dataSource(securityDataSource)
//                .usersByUsernameQuery("SELECT user_id, pw, active from members where user_id=?")
//                .authoritiesByUsernameQuery("SELECT user_id, role from roles where user_id=?");

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
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied/");
    }

//    @Autowired
//    private DataSource securityDataSource;


    //初始化一个bcrypt编码Bean
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //创建认证提供器
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
}
