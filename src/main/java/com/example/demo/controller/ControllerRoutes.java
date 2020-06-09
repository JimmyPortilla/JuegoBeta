package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerRoutes {
	
	@RequestMapping("/")
	public String index(Model model) {
		String vista="index";
	
		return vista;
	}

}
