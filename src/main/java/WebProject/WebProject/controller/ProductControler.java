package WebProject.WebProject.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import WebProject.WebProject.entity.Product;
import WebProject.WebProject.repository.ProductRepository;
import WebProject.WebProject.service.CartService;
import WebProject.WebProject.service.CategoryService;
import WebProject.WebProject.service.ProductService;
import WebProject.WebProject.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProductControler {

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CartService cartService;

	@Autowired
	HttpSession session;


	@GetMapping("/home")
	public ResponseEntity<?> listProduct() {
		return ResponseEntity.ok(productService.findAll());
	}
    @GetMapping("/product")
    public ResponseEntity<?> home() {
        return ResponseEntity.ok(productService.findAll());
    }
	@GetMapping("/product/{id}")
	public ResponseEntity<?> detail(@PathVariable Long id) {
		return ResponseEntity.ok(productService.findById(id));
	}

}
