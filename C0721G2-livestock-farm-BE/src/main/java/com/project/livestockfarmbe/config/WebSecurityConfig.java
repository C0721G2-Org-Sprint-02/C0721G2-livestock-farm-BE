package com.project.livestockfarmbe.config;

import com.project.livestockfarmbe.accessdenied.CustomAccessDeniedHandler;
import com.project.livestockfarmbe.jwt.JwtAuthenticationEntryPoint;
import com.project.livestockfarmbe.jwt.JwtFilter;
import com.project.livestockfarmbe.service.account.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                // C??c trang kh??ng y??u c???u login
                .antMatchers("/api/public/**", "/api/news/list", "/api/news/N-**", "/**/*.jpg", "/**/*.png","/api/buy_individual/**")
                .permitAll()
                //phan quyen
                .and().authorizeRequests().antMatchers("/api/news/**","/api/cages/**", "/api/individual/**","/api/treatement/**")
                .hasAnyRole("EMPLOYEE", "ADMIN")
                .and().authorizeRequests().antMatchers("/api/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().cors()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                // make sure we use stateless session; session won't be used to
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // Add a filter to validate the tokens with every request
//        th??m l???c filter tr?????c khi x??c th???c
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
}
