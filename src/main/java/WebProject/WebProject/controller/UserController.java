package WebProject.WebProject.controller;


import WebProject.WebProject.entity.User;
import WebProject.WebProject.exportExcel.ExportExcelNguoiDung;
import WebProject.WebProject.model.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import WebProject.WebProject.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExportExcelNguoiDung exportExcelNguoiDung;

    @GetMapping("/get-all")
    public ResponseEntity<?> user(){
        return ResponseEntity.ok(userService.findUserRole_User());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody UserRequest request)  {
        return ResponseEntity.ok(userService.saveUser(request));
    }

    @GetMapping("/get-one/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody UserRequest request)  {
        return ResponseEntity.ok(userService.updateUser(id,request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> GetDeleteCart(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/export-excel")
    public ResponseEntity<InputStreamResource> exportToExcel() throws IOException {
        // Thay thế dòng dưới bằng cách lấy dữ liệu từ service hoặc repository của bạn
        List<User> users = userService.findUserRole_User();

        ByteArrayInputStream excelData = exportExcelNguoiDung.generateExcelKhachHang(users);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(excelData));
    }
}
