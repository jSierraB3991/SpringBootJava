package com.example.tenancy.config;

import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter
{
	private static final Logger LOG = Logger.getLogger(RequestInterceptor.class.getName());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String requestURI = request.getRequestURI();
		String tenantID = request.getHeader("X-TenantID");
		
		LOG.info("RequestURI::" + requestURI +" || Search for X-TenantID  :: " + tenantID);
		
		if (!Optional.ofNullable(tenantID).isPresent()) {
            response.getWriter().write("X-TenantID not present in the Request Header");
            response.setStatus(400);
            return false;
        }
		TenantContext.setCurrentTenant(tenantID);
		return true;
	}
}
