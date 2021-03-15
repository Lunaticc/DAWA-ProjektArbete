package dawaprojekt.dawaprojekt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
        public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                    .dataSource(dataSource)
                    .usersByUsernameQuery("select username, password, enabled from user where username=?")
                    .authoritiesByUsernameQuery("select username, role from user where username=?");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.authorizeRequests()
                    .antMatchers("/*").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/bidder/**").hasRole("BIDDER")
                    .antMatchers("/seller/**").hasRole("SELLER")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().permitAll()
                    .and()
                    .formLogin().loginPage("/login").defaultSuccessUrl("/signIn").permitAll()
                    .and()
                    .logout().permitAll()
                    .logoutSuccessUrl("/login");

            http.cors().and().csrf().disable();
        }
}