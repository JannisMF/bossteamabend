package de.tensing.bossteam.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static de.tensing.bossteam.security.ApplicationUserRole.ADMIN;
import static de.tensing.bossteam.security.ApplicationUserRole.BOSSTEAMER;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired


    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(BOSSTEAMER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails bossTeamUser = User.builder()
                .username("bossteam")
                .password(passwordEncoder.encode("bittekeinbit3"))
                .roles(BOSSTEAMER.name())
                .build();

        UserDetails jannismfUser = User.builder()
                .username("jannismf")
                .password(passwordEncoder.encode("(jan5mnis)"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                bossTeamUser,
                jannismfUser
        );
    }
}
