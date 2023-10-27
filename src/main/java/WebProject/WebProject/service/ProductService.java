package WebProject.WebProject.service;

import java.util.List;

import WebProject.WebProject.model.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import WebProject.WebProject.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

	Product saveProduct(ProductRequest request);

	Product findById(Long id);

	Product updateProduct(Long id,ProductRequest request);

	void deleteById(Long id);

	List<Product> findAll();

	Product add(Product p);


}
