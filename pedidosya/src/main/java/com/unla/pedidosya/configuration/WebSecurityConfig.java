package com.unla.pedidosya.configuration;

import com.unla.pedidosya.service.UserDetailsServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(7);
    }

    String[] resources = new String[]{
        "/include/**",
        "/css/**",
        "/icons/**",
        "/images/**",
        "/js/**",
        "/layer/**"
    };
    //aca ir cargando las paginas accesibles para cada tipo de usuario
    String[] vendedor = new String[]{

    };

    String[] comprador = new String[]{

    };

    String[] repartidor = new String[]{

    };
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()
            .antMatchers(resources).permitAll()
            .antMatchers("/","/login").permitAll()
            .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error=true")
                    .usernameParameter("username")
                    .passwordParameter("password")
            .and()
                .rememberMe().key("uniqueAndSecret").rememberMeParameter("recuerdame").tokenValiditySeconds(86400)
            .and()
                .logout()
                    .permitAll()
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/login?logout")
            .and()
                .exceptionHandling().accessDeniedPage("/403");

    }
    
}
