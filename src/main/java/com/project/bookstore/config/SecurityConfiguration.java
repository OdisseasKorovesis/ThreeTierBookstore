package com.project.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/index.html", "/").permitAll()
                .antMatchers("/adminDash.html").access("hasRole('ADMIN')")
                .antMatchers("/createPublisher.html").access("hasRole('ADMIN')")
                .antMatchers("/createGenre.html").access("hasRole('ADMIN')")
                .antMatchers("/createLanguage.html").access("hasRole('ADMIN')")
                .antMatchers("/createBook.html").access("hasRole('ADMIN')")
                .antMatchers("/createAuthor.html").access("hasRole('ADMIN')")
                .and().formLogin().loginPage("/login2.html").loginProcessingUrl("/login2.html").defaultSuccessUrl("/index.html")
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .logoutSuccessUrl("/index.html")
                .invalidateHttpSession(true) // set invalidation state when logout
                .deleteCookies("JSESSIONID");
        //.authenticationEntryPoint(authEntryPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("john123").password("password").roles("ADMIN");
    }

}
