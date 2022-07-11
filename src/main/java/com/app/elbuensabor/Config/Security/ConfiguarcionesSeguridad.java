package com.app.elbuensabor.Config.Security;

import com.app.elbuensabor.Config.ApplicationRole;
import com.app.elbuensabor.Servicio.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class ConfiguarcionesSeguridad extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoders() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception{
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoders());
        }

    private static final String[] publicEndpoint = {
            "/pedido/**",
            "/usuario/**",
            "/factura/**"

    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/css/*", "/js/*", "/img/*", "/**").permitAll()
                .and().formLogin()
                .loginPage("/login") // Que formulario esta mi login
                .loginProcessingUrl("/logincheck")
                .usernameParameter("username") // Como viajan los datos del logueo
                .passwordParameter("password")// Como viajan los  datos del logueo
                .defaultSuccessUrl("/inicio") // A que URL viaja
                .permitAll()
                .and().logout() // Aca configuro la salida
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll().and().csrf().disable();

//
//                http.csrf()
//                .disable()
//                .cors()
//                .and()
//                .authorizeRequests()
//
//                //.antMatchers(publicEndpoint).permitAll()
//                .antMatchers(HttpMethod.POST, "/factura/**").hasRole(ApplicationRole.ADMIN.getName())
//                .antMatchers(HttpMethod.GET, "/factura/**").hasRole(ApplicationRole.ADMIN.getName())
//                .antMatchers(HttpMethod.PUT, "/factura/**").hasRole(ApplicationRole.ADMIN.getName())
//                .antMatchers(HttpMethod.POST, "/usuario/**").hasRole(ApplicationRole.ADMIN.getName())
//                .antMatchers(HttpMethod.GET, "/usuario/**").hasRole(ApplicationRole.ADMIN.getName())
//                .antMatchers(HttpMethod.PUT, "/usuario/**").hasRole(ApplicationRole.ADMIN.getName())
//                .antMatchers(HttpMethod.POST, "/pedido/**").hasRole(ApplicationRole.ADMIN.getName())
//                .antMatchers(HttpMethod.GET, "/pedido/**").hasRole(ApplicationRole.ADMIN.getName())
//                .antMatchers(HttpMethod.PUT, "/pedido/**").hasRole(ApplicationRole.ADMIN.getName())
//                .antMatchers(HttpMethod.POST, "/factura/**").hasRole(ApplicationRole.CAJERO.getName())
//                .antMatchers(HttpMethod.GET, "/factura/**").hasRole(ApplicationRole.CAJERO.getName())
//                .antMatchers(HttpMethod.PUT, "/factura/**").hasRole(ApplicationRole.CAJERO.getName())
//                .antMatchers(HttpMethod.POST, "/pedido/**").hasRole(ApplicationRole.CAJERO.getName())
//                .antMatchers(HttpMethod.GET, "/pedido/**").hasRole(ApplicationRole.CAJERO.getName())
//                .antMatchers(HttpMethod.PUT, "/pedido/**").hasRole(ApplicationRole.CAJERO.getName())
//                .antMatchers(HttpMethod.POST, "/pedido/**").hasRole(ApplicationRole.COCINERO.getName())
//                .antMatchers(HttpMethod.GET, "/pedido/**").hasRole(ApplicationRole.COCINERO.getName())
//                .antMatchers(HttpMethod.PUT, "/pedido/**").hasRole(ApplicationRole.COCINERO.getName())
//                .anyRequest()
//                .authenticated()
//                .and()
//                //.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
//
//    }


    }
}
