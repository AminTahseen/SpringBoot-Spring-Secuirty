package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String GetPage()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String GetLoginPage()
	{
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String GetLogout()
	{
		return "logout.jsp";
	}
}

