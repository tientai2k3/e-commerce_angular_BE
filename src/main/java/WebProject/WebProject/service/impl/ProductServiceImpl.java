package WebProject.WebProject.service.impl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import WebProject.WebProject.model.request.ProductRequest;
import WebProject.WebProject.repository.CategoryRepository;
import WebProject.WebProject.repository.ColorRepository;
//import WebProject.WebProject.service.CloudinaryService;
import WebProject.WebProject.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import WebProject.WebProject.entity.Product;
import WebProject.WebProject.repository.ProductRepository;
import WebProject.WebProject.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ColorRepository colorRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	private CloudinaryService cloudinaryService;


	@Override
	public Product saveProduct(ProductRequest request) {
		Product p = new Product();
		p.setColor(colorRepository.findById(request.getColorId()).get());
		p.setCategory(categoryRepository.findById(request.getCategoryId()).get());
		p.setDescription(request.getDescription());
		p.setProduct_Code(request.getProduct_Code());
		p.setCreated_At(new Date(System.currentTimeMillis()));
		p.setProduct_Name(request.getProduct_Name());
		p.setQuantity(request.getQuantity());
		p.setPrice(request.getPrice());
		p.setImage(request.getImage());

//		try {
//			if (!image.isEmpty()) {
//				String url = cloudinaryService.uploadFile(image);
//				p.setImage(url);
//			}else {
//				p.setImage("");
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//		}
		return productRepository.save(p);
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Long id,ProductRequest request) {
		Product p = productRepository.findById(id).get();
		p.setColor(colorRepository.getById(request.getColorId()));
		p.setCategory(categoryRepository.findById(request.getCategoryId()).get());
		p.setDescription(request.getDescription());
		p.setProduct_Code(request.getProduct_Code());
		p.setCreated_At(new Date(System.currentTimeMillis()));
		p.setProduct_Name(request.getProduct_Name());
		p.setQuantity(request.getQuantity());
		p.setPrice(request.getPrice());
//		if (!request.getImage().isEmpty()) {
//			String url = cloudinaryService.uploadFile(request.getImage());
//			p.setImage(url);
//		}
		return productRepository.save(p);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}



	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product add(Product p) {
		return productRepository.save(p);
	}


}
