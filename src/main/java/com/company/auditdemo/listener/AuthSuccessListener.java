package com.company.auditdemo.listener;

import com.company.auditdemo.session.ClientSession;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class AuthSuccessListener {

    @EventListener
    public void onAuthSuccess(AuthenticationSuccessEvent event) {
        String ip = null;
        ServletRequestAttributes attrs =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs != null) {
            HttpServletRequest req = attrs.getRequest();
            ip = getClientIp(req);
        }
        ClientSession.storeIp(ip);
    }

    private String getClientIp(HttpServletRequest request) {
        String xff = request.getHeader("X-Forwarded-For");
        if (xff != null && !xff.isBlank()) {
            // XFF có thể dạng "client, proxy1, proxy2" -> lấy phần đầu
            return xff.split(",")[0].trim();
        }
        String xReal = request.getHeader("X-Real-IP");
        return (xReal != null && !xReal.isBlank()) ? xReal : request.getRemoteAddr();
    }


}
