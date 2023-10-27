package WebProject.WebProject.controller;


import WebProject.WebProject.model.request.ColorRequest;
import WebProject.WebProject.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/admin/color")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ColorController {

	@Autowired
	ColorService colorService;


	@GetMapping("/get-all")
	public ResponseEntity<?> category(){
		return ResponseEntity.ok(colorService.findAll());
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ColorRequest request)  {
		return ResponseEntity.ok(colorService.saveColor(request));
	}

	@GetMapping("/get-one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id){
		return ResponseEntity.ok(colorService.findById(id));
	}

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody ColorRequest color)  {
        return ResponseEntity.ok(colorService.updateColor(id,color));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> GetDeleteCart(@PathVariable Long id) {
        colorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
