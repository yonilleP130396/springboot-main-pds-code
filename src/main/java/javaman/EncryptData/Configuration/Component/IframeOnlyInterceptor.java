package javaman.EncryptData.Configuration.Component;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class IframeOnlyInterceptor implements HandlerInterceptor {

    @Override
    @SuppressWarnings("ConvertToStringSwitch")
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String secFetchDest = request.getHeader("Sec-Fetch-Dest");

        if (secFetchDest != null && secFetchDest.equals("iframe")) {
            return true; // allow if request is within an iframe
        }

        
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities() != null) {
            for (GrantedAuthority authority : auth.getAuthorities()) {
                String role = authority.getAuthority();
                if ("ROLE_SUPERADMIN".equals(role)) {
                    response.sendRedirect("/admin");
                    return false;
                }else if ("ROLE_ADMIN".equals(role)) {
                    response.sendRedirect("/protecteddata");
                    return false;
                } else if ("ROLE_USER".equals(role)) {
                    response.sendRedirect("/user/protecteddata");
                    return false;
                }
            } 
        }

        return false;
    }


    }

