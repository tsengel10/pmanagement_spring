package com.example.mvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.mvc.HitCounter;

public class GlobalInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private HitCounter hitCounter;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		hitCounter.setHits(hitCounter.getHits() + 1);
		request.setAttribute("hitCounter", hitCounter.getHits());
		return super.preHandle(request, response, handler);
	}
	
}
