package com.example.Spring_boot_rest.config;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private  UserDetailsService userDetailsService;


//     authentication Provider
@Bean
public AuthenticationProvider authProvider() {
//    we connect databse using dao
    DaoAuthenticationProvider provider =
            new DaoAuthenticationProvider(userDetailsService);

//    provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//     lec 160
    provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

    return provider;
}






    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){

        http.csrf(customizer -> customizer.disable());


//         for authentication
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());


//         form loginn page
        http.formLogin(Customizer.withDefaults());
 http.httpBasic(Customizer.withDefaults());

//  changing session id or new sessio id
 http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }



////         without lambda
//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf=new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> Configurer) {
//                Configurer.disable();
//            }
//        };
//        http.csrf(custCsrf);
//
//        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp=new
//                Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//                    @Override
//                    public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry Registry) {
//                     Registry.anyRequest().authenticated();
//
//                    }
//                };
//        http.authorizeHttpRequests(custHttp);
//
//
//
//




//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user= User
//                .withDefaultPasswordEncoder()
//                .username("Aashish")
//                .password("12345")
//                .roles("USER")
//                .build();
//        UserDetails admin= User
//                .withDefaultPasswordEncoder()
//                .username("admin")
//                .password("123456")
//                .roles("ADMIN")
//                .build();
//
//// you can create multiple user or pass multiple user
//        return new InMemoryUserDetailsManager(user,admin);
//
//    }

}
