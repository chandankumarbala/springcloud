package com.poc.lb.filters;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class BasicSecurityFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(BasicSecurityFilter.class);

	@Override
	public Object run() throws ZuulException {
	
		
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    
	    log.info("Intercepted call to ."+request.getServerName());
	    
	    if(request.getHeader("Authorization")==null)
	    	log.info("No `Authorization` headers found.");
	   
	   
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
