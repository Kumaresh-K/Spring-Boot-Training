package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides HttpServletRequest service for the SpringMVC
 * @author kumareshkaruppusamy
 */
@Service
public class WebServices {
	
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * HttpServletRequest service for the map hello6
	 */
	public void hello6Message() {
		HttpSession session = request.getSession();
		request.setAttribute("hello", "hello world");
		session.setAttribute("myattr", "save this information");
	}
	
	/**
	 * HttpServletRequest service for the map hello7
	 */
	public void hello7Message() {
		request.setAttribute("hello", "Name has been caught here");
	}
	
	/**
	 * HttpServletRequest service for the map hello8
	 */
	public void hello8Message() {
		request.setAttribute("hello", "Request parameter name has been caught here");
	}
	
	/**
	 * HttpServletRequest service for the map repeat
	 */
	public void repeatMessage() {
		request.setAttribute("hello", "Repeated Message from another view");
	}
}
