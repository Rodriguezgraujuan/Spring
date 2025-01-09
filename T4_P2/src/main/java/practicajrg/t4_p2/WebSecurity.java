package practicajrg.t4_p2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import practicajrg.t4_p2.Service.UsuarioService;

import java.util.List;

@Configuration
public class WebSecurity {
    private final UsuarioService usuarioService;
    // Método con la autorización
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                //Autorizar rutas
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                //El resto requieren autenticacion
                                .anyRequest().authenticated()
                )
                //Creara la pagina de login automaticamente
                .formLogin(login -> login
                        .defaultSuccessUrl("/private", true).permitAll()
                )
                //Creara el logout automaticmente
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );
        return http.build();
    }

    //Metodo de autenticacion
    @Bean
    public UserDetailsService userDetailsService() {
        return myUserDetailsService();
    }

    //Codificación
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
