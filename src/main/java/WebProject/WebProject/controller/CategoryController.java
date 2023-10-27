package WebProject.WebProject.controller;



import WebProject.WebProject.model.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import WebProject.WebProject.service.CategoryService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/category")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CategoryController {

	@Autowired
	private CategoryService categoryService;


	@GetMapping("/get-all")
	public ResponseEntity<?> category(){
		return ResponseEntity.ok(categoryService.findAll());
	}

	@GetMapping("/get-one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id){
		return ResponseEntity.ok(categoryService.findById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CategoryRequest request)  {
		return ResponseEntity.ok(categoryService.saveCategory(request));
	}


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody CategoryRequest request)  {
        return ResponseEntity.ok(categoryService.updateCategory(id,request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> GetDeleteCart(@PathVariable Long id) {
        categoryService.deleteCategoryId(id);
        return ResponseEntity.ok().build();
    }
}
