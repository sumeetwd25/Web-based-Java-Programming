package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/viewproduct")
	public ModelAndView displayAllProducts() {
		List<Product> plist = productService.getAllProducts();
		return new ModelAndView("displayproduct", "plist", plist);
	}

	@GetMapping("/addnewproduct")
	public String addProductForm() {
		return "addproduct";
	}
	@PostMapping("/addproduct")
	public ModelAndView addProduct(@RequestParam int pid, @RequestParam String pname, @RequestParam int qty,
			@RequestParam float price) {

		Product p = new Product(pid, pname, qty, price);
		productService.addProduct(p);
		return new ModelAndView("redirect:/product/viewproduct");
	}

	@GetMapping("/edit/{pid}")
	public ModelAndView editProductById(@PathVariable("pid") int pid) {
		Product p = productService.getById(pid);
		return new ModelAndView("editproduct", "prod", p);
	}
	@PostMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam int pid, @RequestParam String pname, @RequestParam int qty,
			@RequestParam float price) {
		Product p = new Product(pid, pname, qty, price);
		productService.updateProduct(p);
		return new ModelAndView("redirect:/product/viewproduct");
	}

	@GetMapping("/delete/{pid}")
	public ModelAndView deleteProductById(@PathVariable int pid) {
		Product p = new Product();
		productService.deleteById(pid);
		return new ModelAndView("redirect:/product/viewproduct");
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		return new ModelAndView("hello","msg","logout success");
	}
}
