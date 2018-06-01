package cn.com.taiji.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import cn.com.taiji.entity.User;



@Controller
public class UserController {
	
	@GetMapping("/user")
	public String thymeleaf(Model model,HttpServletRequest request, Device device) {
		List<User> list = new ArrayList<>();
		boolean zebra = true;//true 表示黑色 false 白色
		Enumeration<String> e = request.getSession().getAttributeNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			if(name.equals(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME)) {
				continue;
			}
			User user = (User) request.getSession().getAttribute(name);
			user.setZebra(zebra);
			if (zebra) {
				zebra=false;
			}else {
				zebra=true;
			}
			list.add(user);
		}
		
		model.addAttribute("list",list);
		return "user";
	}
	
	@GetMapping("/add")
	public String form() {
		return "add";
	}
	//新增
	@PostMapping("/add")
	public String form(Model model ,User user,HttpServletRequest request) {
		request.getSession().setAttribute(user.getId(), user);
		model.addAttribute("user" , user);
		return "redirect:user";
	}
	//修改
	@GetMapping("/update")
	public String update(Model model , String id , HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(id);
		model.addAttribute("user" , user);
		return "update";
	}
	@GetMapping("/detele")
	public String delete(HttpServletRequest request , String id ) {
		request.getSession().removeAttribute(id);
		return "redirect:user";
	}
	//////////////////////////////////////
	@GetMapping("/change")
	public String change(Model model ,String lang,HttpServletRequest request) {
		if (lang.equals("中文")) {
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh","CN"));
		} else if(lang.equals("英文")){
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en","US"));
		}
		return "redirect:user";
	}
	
	
	
	
	
	
	
	
}
