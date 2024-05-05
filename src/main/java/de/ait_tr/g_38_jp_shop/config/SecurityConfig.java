package de.ait_tr.g_38_jp_shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(x->x
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(x->x
                        .requestMatchers(HttpMethod.GET, "/products/all").permitAll()
                        .requestMatchers(HttpMethod.GET, "/products").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/totalQuantity").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/totalQuantity").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/totalPrice").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/averagePrice").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/update").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/delete").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/delete/title").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/restore").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/customers/all").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/customers/all/active").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/customers/save").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults()).build();
    }


}
