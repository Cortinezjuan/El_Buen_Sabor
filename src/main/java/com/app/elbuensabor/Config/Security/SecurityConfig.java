//package com.app.elbuensabor.Config.Security;
//
//import com.app.elbuensabor.Config.ApplicationRole;
////import com.app.elbuensabor.Servicio.UserDetailsServiceImpl;
//import com.app.elbuensabor.Servicio.UserDetailsServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@EnableWebSecurity
//@Configuration
////@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//   //JwtRequestFilter jwtRequestFilter;
//
//
//
//    private static final String[] publicEndpoint = {
//            "/pedido/**",
//            "/usuario/**",
//            "/factura/**"
//
//    };
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .cors()
//                .and()
//                .authorizeRequests()
//
//                .antMatchers(publicEndpoint).permitAll()
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
//                ;
//                //.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
//                //.exceptionHandling()
//                //.authenticationEntryPoint(new Http403ForbiddenEntryPoint());
//    }
//    BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoders() {
//        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
//        return bCryptPasswordEncoder;
//    }
//
//    @Autowired
//    UserDetailsServiceImpl userDetailsServiceImpl;
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        //Especificar el encargado del login y encriptacion del password
//        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoders());
//    }
//}
