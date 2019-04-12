package hr.java.web.pavlovic.moneyapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //TODO: zamijenti za bazu
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("user").password(passwordEncoder.encode("user")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        //TODO: razvrzstati uloge i promjeniti nacin dohvata autorizacije
        http.authorizeRequests()
                .antMatchers("/expense/**")
                .hasAnyRole("USER","ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/expense/new", true)
                .and()
                .logout()
                .logoutSuccessUrl("/login");
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

}
