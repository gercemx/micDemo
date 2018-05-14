package com.att.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class FirstController {

	@RequestMapping(value="/test")
	@ResponseBody
	public String test(){
		return "app test ok ";
	}
	
	@RequestMapping(value="/test2")
	public String welcome(){
		
		System.out.println(" abcd .. dentro");
		
		return "welcose";
	}
	
}