package com.thang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thang.DAO.CategoryDAO;
import com.thang.DAO.ProductDAO;
import com.thang.entity.Category;
import com.thang.entity.Product;

@Controller
public class Index {
  @Autowired
  CategoryDAO dao;
  @Autowired
  ProductDAO dao_product;
	@RequestMapping("index")

	public String index(Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		
		List<Product> product = dao_product.findAll();
		model.addAttribute("product",product);
		return "/template/index";
	}
	
	@RequestMapping("/product/{id}")
	public String list(Model model, @PathVariable("id")  String id) {				
		List<Product> items = dao_product.findByCategoryId(id);
		model.addAttribute("lists", items);
		return "/template/product";	
	}
	
	@RequestMapping("/product")
	public String show( Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		return "/template/product";
	}
	@RequestMapping("/about")
	public String show1(Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		return "/template/about";
	}
	@RequestMapping("/blog")
	public String show2(Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		return "/template/blog";
	}
	
	@RequestMapping("/blog-detail")
	public String show3() {
		return "/template/blog-detail";
	}
	@RequestMapping("/contact")
	
	public String show4( Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		return "/template/contact";
	}
	@RequestMapping("/header")
	public String show5() {
		return "/template/header";
	}
	@RequestMapping("/product-detail")
	public String show6() {
		return "/template/product-detail";
	}
	@RequestMapping("/shoping-cart")
	public String show7( Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		return "/template/shoping-cart";
	}
	
	@RequestMapping("/my-account")
	public String show_acount() {
		return "/template/shoping-cart";
	}
	
	@RequestMapping("/account/login")
	public String show8() {
		return "/template/account/login";
	}
	@RequestMapping("/account/signup")
	public String show9() {
		return "/template/account/signup";
	}
	
	@RequestMapping("/account/setting")
	public String show10() {
		return "/template/account/setting_account";
	}
	
	@RequestMapping("/account/myaccount")
	public String show11() {
		return "/template/account/my_account";
	}
	
}
