package WebProject.WebProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import WebProject.WebProject.model.request.CartRequest;
import WebProject.WebProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import WebProject.WebProject.entity.Cart;
import WebProject.WebProject.entity.Product;
import WebProject.WebProject.entity.User;
import WebProject.WebProject.service.CartService;
import WebProject.WebProject.service.ProductService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user/cart")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	HttpSession session;

	@GetMapping("/{id}")
	public ResponseEntity<?> CartView(@PathVariable Long id)  {

		return ResponseEntity.ok(cartService.findAllByUser(userService.findById(id)));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> GetDeleteCart(@PathVariable Long id) {
		cartService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> UpdateCart(@PathVariable Long id,@RequestBody Integer request) {

		return ResponseEntity.ok(cartService.update(id,request));
	}

	@PostMapping("/add/{id}")
	public ResponseEntity<?> AddToCart(@PathVariable Long id, @RequestBody CartRequest request) {
		return ResponseEntity.ok(cartService.add(id,request));
	}

}