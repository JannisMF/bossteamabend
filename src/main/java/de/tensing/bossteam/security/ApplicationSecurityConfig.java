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

import static de.tensing.bossteam.security.ApplicationUserRole.*;

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
                .antMatchers("/player/*").hasRole(BOSSTEAMER.name())
                .antMatchers("/player/1").hasRole(P1.name())
                .antMatchers("/player/2").hasRole(P2.name())
                .antMatchers("/player/3").hasRole(P3.name())
                .antMatchers("/player/4").hasRole(P4.name())
                .antMatchers("/player/5").hasRole(P5.name())
                .antMatchers("/player/6").hasRole(P6.name())
                .antMatchers("/player/7").hasRole(P7.name())
                .antMatchers("/player/8").hasRole(P8.name())
                .antMatchers("/player/9").hasRole(P9.name())
                .antMatchers("/player/10").hasRole(P10.name())
                .antMatchers("/player/11").hasRole(P11.name())
                .antMatchers("/player/12").hasRole(P12.name())
                .antMatchers("/player/13").hasRole(P13.name())
                .antMatchers("/player/14").hasRole(P14.name())
                .antMatchers("/player/15").hasRole(P15.name())
                .antMatchers("/player/16").hasRole(P16.name())
                .antMatchers("/player/17").hasRole(P17.name())
                .antMatchers("/player/18").hasRole(P18.name())
                .antMatchers("/player/19").hasRole(P19.name())
                .antMatchers("/player/20").hasRole(P20.name())
                .antMatchers("/player/21").hasRole(P21.name())
                .antMatchers("/player/22").hasRole(P22.name())
                .antMatchers("/player/23").hasRole(P23.name())
                .antMatchers("/player/24").hasRole(P24.name())
                .antMatchers("/player/25").hasRole(P25.name())
                .antMatchers("/player/26").hasRole(P26.name())
                .antMatchers("/player/27").hasRole(P27.name())
                .antMatchers("/player/28").hasRole(P28.name())
                .antMatchers("/player/29").hasRole(P29.name())
                .antMatchers("/player/30").hasRole(P30.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
    private UserDetails createNewUser(String username, String password, ApplicationUserRole role) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(role.name())
                .build();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails bossTeamUser = createNewUser("bossteam", "bittekeinbit3", BOSSTEAMER);
        UserDetails jannismfUser = createNewUser("jannismf", "s0nnenschule", ADMIN);
        UserDetails p1User = createNewUser("p1", "rennen", P1);
        UserDetails p2User = createNewUser("p2", "laib", P2);
        UserDetails p3User = createNewUser("p3", "abendessen", P3);
        UserDetails p4User = createNewUser("p4", "schuppen", P4);
        UserDetails p5User = createNewUser("p5", "lippe", P5);
        UserDetails p6User = createNewUser("p6", "eidechsen", P6);
        UserDetails p7User = createNewUser("p7", "schiff", P7);
        UserDetails p8User = createNewUser("p8", "alarm", P8);
        UserDetails p9User = createNewUser("p9", "vorschlag", P9);
        UserDetails p10User = createNewUser("p10", "ekel", P10);
        UserDetails p11User = createNewUser("p11", "handel", P11);
        UserDetails p12User = createNewUser("p12", "streichholz", P12);
        UserDetails p13User = createNewUser("p13", "meisterschaft", P13);
        UserDetails p14User = createNewUser("p14", "pferde", P14);
        UserDetails p15User = createNewUser("p15", "stretch", P15);
        UserDetails p16User = createNewUser("p16", "paket", P16);
        UserDetails p17User = createNewUser("p17", "vers", P17);
        UserDetails p18User = createNewUser("p18", "kohl", P18);
        UserDetails p19User = createNewUser("p19", "steuer", P19);
        UserDetails p20User = createNewUser("p20", "ehe", P20);
        UserDetails p21User = createNewUser("p21", "termin", P21);
        UserDetails p22User = createNewUser("p22", "menge", P22);
        UserDetails p23User = createNewUser("p23", "eimer", P23);
        UserDetails p24User = createNewUser("p24", "hammer", P24);
        UserDetails p25User = createNewUser("p25", "knie", P25);
        UserDetails p26User = createNewUser("p26", "wurzel", P26);
        UserDetails p27User = createNewUser("p27", "bewegung", P27);
        UserDetails p28User = createNewUser("p28", "sprache", P28);
        UserDetails p29User = createNewUser("p29", "tante", P29);
        UserDetails p30User = createNewUser("p30", "wissenschaft", P30);

        return new InMemoryUserDetailsManager(
                bossTeamUser,
                jannismfUser
        );
    }
}
