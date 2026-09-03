package javaman.EncryptData.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javaman.EncryptData.AuthenticationSuccessHandler;
import javaman.EncryptData.UsersAccount.MyUserDetailService;
import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {
    
    private final MyUserDetailService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(csrf->csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .ignoringRequestMatchers("/logout")
                )
                .headers(headers -> headers
                        .contentSecurityPolicy(csp -> csp.policyDirectives("frame-ancestors 'self'")) // Allow iframes from same origin
                )

                .authorizeHttpRequests(registry->{
                    registry.requestMatchers("/nipds/**","/login/**","/api/session-status","/api-ip/threat","/tailwind/**").permitAll();
                    registry.requestMatchers("/images/signal-2025-01-20-115314.png","/css/**","/js/**","/assets/**","/plugins/**","/adminlte-2.3.10/**","/superadmin/app.js").permitAll();
                    registry.requestMatchers("/api/**","/api/session-status","/uploads/**").hasAnyRole("USER","ADMIN");
                    registry.requestMatchers("/user/protecteddata/**","/user/civilianschooling/**","/user/collateralassignment/**").hasRole("USER");
                    registry.requestMatchers("/units/**","/protecteddata/**","/personnelprofile/**","/assignments/**","/civilianschooling/**","/collateralassignment/**","/create_user/**","/allenlisted","/etadetereenlistment/**","/uploadfile/**","/militaryschooling/**","/notifications/**","/allofficer/**","/printallpersonnel/**","/promotions/**","/retirement/**","/signature/**").hasRole("ADMIN");
                    registry.requestMatchers("/admin/**","/superadmin/app.js").hasRole("SUPERADMIN");
                   registry.requestMatchers("/printreport/**").hasAnyRole("SUPERADMIN","ADMIN");
                    registry.requestMatchers("/assignments/**").authenticated();
                    registry.requestMatchers("/uploads_profile_picture/**").hasAnyRole("USER", "ADMIN");
                    registry.anyRequest().authenticated();
 

                })
                .formLogin(httpSecurityFormLoginConfigurer ->{
                	httpSecurityFormLoginConfigurer
                            .loginPage("/login")
                            .successHandler(new AuthenticationSuccessHandler())
                            .permitAll();
                })
                .logout(logoutConfigurer -> {
                    logoutConfigurer
                            .logoutUrl("/logout") // URL for logging out
                            .logoutSuccessUrl("/login?logout") 
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID")
                            .permitAll(); // Allow all to access the logout URL
                })
                .sessionManagement(session ->session

                        .invalidSessionUrl("/login?sessionExpired=true")
                        .sessionFixation().migrateSession()
                        .maximumSessions(1)
                            .maxSessionsPreventsLogin(true)
                            .expiredUrl("/login?sessionExpired=true")
                )
                
                .build();
    }

    @Bean
    public static HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

      // ✅ ADD THIS SECTION (serves /uploads/** from file system)
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads_profile_picture/**")
                .addResourceLocations("file:uploads_profile_picture/");
    }

}
