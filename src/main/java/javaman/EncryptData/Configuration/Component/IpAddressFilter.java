package javaman.EncryptData.Configuration.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class IpAddressFilter extends OncePerRequestFilter{
    
    @Value("${api.key.ipthreat}") 
    private String API_KEY; 

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestUri = request.getRequestURI();

        if ("/api-ip/threat".equals(requestUri)) {
            String apiKey = request.getHeader("API-Key");

            if (API_KEY.equals(apiKey)) {
                filterChain.doFilter(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden: Dumbed Asshole");
            }
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
       
    }
}
