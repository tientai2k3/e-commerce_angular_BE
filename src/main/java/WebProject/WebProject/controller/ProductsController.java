package WebProject.WebProject.controller;

import WebProject.WebProject.entity.Product;
import WebProject.WebProject.entity.User;
import WebProject.WebProject.exportExcel.ExportExcelNguoiDung;
import WebProject.WebProject.model.request.ProductRequest;
import WebProject.WebProject.service.CloudinaryService;
import WebProject.WebProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private ExportExcelNguoiDung exportExcelNguoiDung;

    @Autowired
    private HttpSession session;

    @GetMapping("/get-all")
    public ResponseEntity<?> category(){
        return ResponseEntity.ok(productService.findAll());
    }
    public String anh;


    @PostMapping(value = "/addImage",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> addImage(@RequestPart("multipartFile") MultipartFile multipartFile)   throws IOException {
        if (!multipartFile.isEmpty()) {
            String url = cloudinaryService.uploadFile(multipartFile);
            anh =url;
            return ResponseEntity.ok(url);
        }else {
            return ResponseEntity.ok("Lỗi");
        }

    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody ProductRequest request)   throws IOException {
//        if (session.getAttribute("image") != null){
////            String image = (String) session.getAttribute("image");
////            request.setImage(image);
//        }
        request.setImage(anh);
        return ResponseEntity.ok(productService.saveProduct(request));
    }
    @GetMapping("/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody ProductRequest request)  {
        return ResponseEntity.ok(productService.updateProduct(id,request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> GetDeleteCart(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/export-excel")
    public ResponseEntity<InputStreamResource> exportToExcel() throws IOException {
        // Thay thế dòng dưới bằng cách lấy dữ liệu từ service hoặc repository của bạn
        List<Product> productList = productService.findAll();

        ByteArrayInputStream excelData = exportExcelNguoiDung.generateExcelProduct(productList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=products.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(excelData));
    }
}
