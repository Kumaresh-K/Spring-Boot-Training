package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class WelcomeSW {
	
	@RequestMapping(method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("Welcome to spring MVC...");
	}
	
	@RequestMapping(value="hello2", method = RequestMethod.GET)
	public String sayHello2() {
		System.out.println("sayhello 2 method is called");
		return "welcome";
	}
	
	@RequestMapping(value="hello3", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello3() {
		System.out.println("sayhello 3 method is called");
		return ResponseEntity.ok("OK message from the Response Entity");
	}
	
	@RequestMapping(value="hello4", method = RequestMethod.GET)
	public ModelAndView sayHello4() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("mykey","Message from Hello 4");
		mandv.setViewName("wel");
		return mandv;
	}
	
	@RequestMapping(value="hello5", method = RequestMethod.GET)
	public ModelAndView sayHello5(ModelAndView mandv) {
		mandv.addObject("mykey","Message from Hello 5");
		mandv.setViewName("wel");
		return mandv;
	}
	
	@RequestMapping(value="hello6", method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("mykey","Message from Hello 6");
		mandv.setViewName("wel");
		HttpSession session = request.getSession();
		request.setAttribute("hello", "hello world");
		session.setAttribute("myattr", "save this information");
		return mandv;
	}
	
	@RequestMapping(value="repeat", method = RequestMethod.GET)
	public ModelAndView repeat(ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("mykey","Message from repeat");
		mandv.setViewName("wel");
		request.setAttribute("hello", "Repeat here");
		return mandv;
	}
	
	@RequestMapping(value="hello7/{name}", method = RequestMethod.GET)
	public ModelAndView hello7(@PathVariable String name, ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("mykey",name);
		mandv.setViewName("wel");
		request.setAttribute("hello", "Name has been catched here");
		return mandv;
	}
	
	@RequestMapping(value="hello8", method = RequestMethod.GET)
	public ModelAndView hello8(@RequestParam("uname") String name, ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("mykey",name);
		mandv.setViewName("wel");
		request.setAttribute("hello", "Request parameter name has been catched here");
		return mandv;
	}
	
	//http://localhost:8080/hello/matrix;uname=mycom
	@RequestMapping(value="matrix", method = RequestMethod.GET) //Matrix parameter same as Request param but syntax varies
	public ModelAndView matrix(@MatrixVariable(name="uname", defaultValue = "Kumaresh") String name, ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("mykey",name);
		mandv.setViewName("wel");
		request.setAttribute("hello", "Request parameter name has been catched here");
		return mandv;
	}
	
	@RequestMapping(value="hello10", method= RequestMethod.GET)
	public ResponseEntity<User> sayHello10() {
		User user = new User();
		user.setUid(100);
		user.setUname("ram");
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value="hello11", method= RequestMethod.POST)
	public ResponseEntity<User> sayHello11(@RequestBody User user) {
		user.setUid(100 + user.getUid());
		user.setUname("ram" + user.getUname());
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value="hello12", method= RequestMethod.POST)
	public User sayHello12(@RequestBody User user) {
		user.setUid(100);
		user.setUname("ram");
		return user;
	}
}


class User {
	private int uid;
	private String uname;
	User() {}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}