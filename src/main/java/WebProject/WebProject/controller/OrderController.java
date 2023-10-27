package WebProject.WebProject.controller;



import WebProject.WebProject.entity.Cart;
import WebProject.WebProject.entity.Order;
import WebProject.WebProject.entity.Order_Item;
import WebProject.WebProject.entity.User;
import WebProject.WebProject.model.request.OrderRequest;
import WebProject.WebProject.service.CartService;
import WebProject.WebProject.service.OrderService;
import WebProject.WebProject.service.Order_ItemService;
import WebProject.WebProject.service.ProductService;
import WebProject.WebProject.service.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/api/user")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderController {

	@Autowired
    CartService cartService;

	@Autowired
    ProductService productService;

	@Autowired
    Order_ItemService order_ItemService;

	@Autowired
    OrderService orderService;

	@Autowired
    HttpSession session;

	@Autowired
	private UserService userService;

	@PostMapping("checkout")
	public ResponseEntity<?> CheckOut(@RequestBody OrderRequest request) throws Exception {
		Order order= orderService.add(request);
		List<Cart> cartList = cartService.findAllByUser(userService.findById(request.getIdUser()));
		for (Cart x:cartList) {
			Order_Item order_item = new Order_Item();
			order_item.setOrder(order);
			order_item.setCount(x.getCount());
			order_item.setProduct(x.getProduct());
			order_ItemService.add(order_item);

			cartService.deleteById(x.getId());
		}
		return ResponseEntity.ok(order);
	}

	@GetMapping("/my-order/{id}")
	public ResponseEntity<?> Order(@PathVariable Long id)  {

		return ResponseEntity.ok(orderService.findAllByUser(userService.findById(id)));
	}

	@GetMapping("/my-order/order-detail/{id}")
	public ResponseEntity<?> OrderDetail(@PathVariable Long id)  {

		return ResponseEntity.ok(order_ItemService.findAllByOrder(orderService.findById(id)));
	}

	@GetMapping("/my-order/get-one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id)  {

		return ResponseEntity.ok(orderService.findById(id));
	}
}
