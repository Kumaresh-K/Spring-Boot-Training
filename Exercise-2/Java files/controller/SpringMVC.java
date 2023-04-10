package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.User;
import com.example.service.UserServices;
import com.example.service.WebServices;

/**
 * Controller class of the application
 * @author kumareshkaruppusamy
 * 
 */
@RestController
@RequestMapping("/hello")
public class SpringMVC {
	
	@Autowired
	private WebServices webServices;
	@Autowired
	private UserServices userServices;
	
	/**
	 * When mapping happened, the line will be printed in terminal
	 */
	@GetMapping
	public void sayHello() {
		System.out.println("welcome to spring MVC...");
	}
	
	/**
	 * When mapping happened, the line will be printed in terminal
	 * @return "Welcome" to the web page.
	 */
	@GetMapping("hello2")
	public String sayHello2() {
		System.out.println("sayhello 2 method is called");
		return "Welcome";
	}
	
	/**
	 * When mapping happened, the line will be printed in terminal
	 * @return ResponseEntity<String> to the web page.
	 */
	@GetMapping("hello3")
	public ResponseEntity<String> sayHello3() {
		System.out.println("sayhello 3 method is called");
		return ResponseEntity.ok("OK message from the Response Entity");
	}
	
	/**
	 * sets message and view name of the model view
	 * @return ModelAndView object of specified page
	 */
	@GetMapping("hello4")
	public ModelAndView sayHello4() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mykey","Message from Hello 4");
		modelAndView.setViewName("welcome");
		return modelAndView;
	}
	
	/**
	 * sets message and view name of the model view
	 * @param modelAndView creates the ModelAndView object
	 * @return ModelAndView object of specified page
	 */
	@GetMapping("hello5")
	public ModelAndView sayHello5(ModelAndView modelAndView) {
		modelAndView.addObject("mykey","Message from Hello 5");
		modelAndView.setViewName("welcome");
		return modelAndView;
	}
	
	/**
	 * sets message and view name of the model view
	 * sets session attribute and HttpServletRequest request attribute
	 * @param modelAndView creates the ModelAndView object
	 * @return ModelAndView object of specified page
	 */
	@GetMapping("hello6")
	public ModelAndView sayHello6(ModelAndView modelAndView) {
		modelAndView.addObject("mykey","Message from Hello 6");
		modelAndView.setViewName("form_data");
		webServices.hello6Message();
		return modelAndView;
	}
	
	/**
	 * checks the session attributes of the last method is still present or not
	 * sets HttpServletRequest request attribute
	 * @param modelAndView creates the ModelAndView object
	 * @return ModelAndView object of specified page
	 */
	@GetMapping("repeat")
	public ModelAndView repeat(ModelAndView modelAndView) {
		modelAndView.addObject("mykey","Message from repeat");
		modelAndView.setViewName("form_data");
		webServices.repeatMessage();
		return modelAndView;
	}
	
	/**
	 * PathVariable fetched and set to the ModelAndView Object
	 * sets HttpServletRequest request attribute
	 * @param name is data passed through the URL
	 * @param modelAndView creates the ModelAndView object
	 * @return ModelAndView object of specified page
	 */
	@GetMapping("hello7/{name}")
	public ModelAndView sayHello7(@PathVariable String name, ModelAndView modelAndView) {
		modelAndView.addObject("mykey",name);
		modelAndView.setViewName("form_data");
		webServices.hello7Message();
		return modelAndView;
	}
	
	/**
	 * RequestParameter fetched and set to the ModelAndView Object
	 * sets HttpServletRequest request attribute
	 * @param name data passed through the URL
	 * @param modelAndView creates the ModelAndView object
	 * @return ModelAndView object of specified page
	 */
	@GetMapping("hello8")
	public ModelAndView sayHello8(@RequestParam("name") String name, ModelAndView modelAndView) {
		modelAndView.addObject("mykey",name);
		modelAndView.setViewName("form_data");
		webServices.hello8Message();
		return modelAndView;
	}
	
	/**
	 * Prints the PathVariable and MatrixVariable in the specified ModelAndView
	 * @param name is data passed through the URL 
	 * @param languages (MatrixVariable) is holder for the multiple string values
	 * @param modelAndView creates the ModelAndView object
	 * @return ModelAndView object of specified page
	 */
	@GetMapping("/matrix/{name}")
	public ModelAndView matrix(@PathVariable String name, @MatrixVariable("languages") String[] languages, ModelAndView modelAndView) {
		String knownPrograms = "";
		for(String language : languages) {
			knownPrograms += language + " ";
		}
		
		modelAndView.addObject("mykey", name);
		modelAndView.addObject("programming knowledge", knownPrograms);
		modelAndView.setViewName("matrix_variable");
		return modelAndView;
	}
	
	/**
	 * Creates the user sends to the web page as a JSON format
	 * @return ResponseEntity<Object> user
	 */
	@GetMapping("hello10")
	public ResponseEntity<User> sayHello10() {
		User user = userServices.createUser(100, "ram");
		return ResponseEntity.ok(user);
	}
	
	/**
	 * Modifies the incoming user object, Modifies it and returns the ResponseEntity object
	 * @param user is attribute of the User class object
	 * @return ResponseEntity<Object> user
	 */
	@PostMapping("hello11")
	public ResponseEntity<User> sayHello11(@RequestBody User user) {
		user = userServices.createUser(1001, "Tony");
		return ResponseEntity.ok(user);
	}
	
	/**
	 * Modifies the incoming user object sets the data.
	 * @param user is attribute of the User class object
	 * @return User object as a Object
	 */
	@PostMapping("hello12")
	public User sayHello12(@RequestBody User user) {
		user = userServices.createUser(100, "ram");
		return user;
	}

}