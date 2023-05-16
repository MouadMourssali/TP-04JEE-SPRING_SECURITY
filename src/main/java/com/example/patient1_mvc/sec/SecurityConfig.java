package com.example.patient1_mvc.sec;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build(), // Pas d'utilisation du password encoder"{noop}1234"
                User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("USER","ADMIN").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin().loginPage("/login").permitAll(); // indiquer qu'on a utilisé un formulaire de login personnalisé qui va etre accessible par tout le monde
        httpSecurity.authorizeHttpRequests().requestMatchers("/webjars/**").permitAll(); // configure les autorisations pour les différentes URL de l'application
        httpSecurity.rememberMe();
        httpSecurity.authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated(); // indique que toutes les autres requêtes nécessitent une authentification.
        httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized"); // configure la page d'erreur qui sera affichée si un utilisateur non autorisé tente d'accéder à une page protégée.
        return httpSecurity.build();
    }
}
