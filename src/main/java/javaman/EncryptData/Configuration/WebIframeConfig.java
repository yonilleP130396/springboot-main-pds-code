package javaman.EncryptData.Configuration;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javaman.EncryptData.Configuration.Component.IframeOnlyInterceptor;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebIframeConfig implements WebMvcConfigurer {


    private final IframeOnlyInterceptor iframeOnlyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(iframeOnlyInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/tailwind/**","/nipds/**","/uploads_profile_picture/**","/login/**","/api/session-status","/images/**","/css/**","/js/**","/assets/**","/plugins/**","/adminlte-2.3.10/**","/protecteddata","/user/protecteddata","/api/**","/api-ip/threat","/admin/**","/superadmin/**","/uploads/**");
    
    }
}
