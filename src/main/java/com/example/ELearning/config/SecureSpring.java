package com.example.ELearning.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecureSpring extends WebSecurityConfigurerAdapter {

    public static final String[] SWAGGER_PATTERNS = {
            "/v2/api-docs", "/configuration/ui",
            "/swagger-resources", "/configuration/security",
            "/swagger-ui.html", "/webjars/**"};

    Logger logger = LogManager.getLogger (SecureSpring.class);
    @Autowired
    UserDetailsService myCredentialsUserService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("MyCredentialsUserService"+myCredentialsUserService.toString());
        auth.userDetailsService(myCredentialsUserService)
                .passwordEncoder(passwordEncoder);
//        auth.inMemoryAuthentication()
//                .withUser("smadhu")
//                .password("smadhu")
//                .roles("USER");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/courses").hasRole("USER")
                .antMatchers (SWAGGER_PATTERNS).permitAll ()
                .anyRequest().permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }




}
