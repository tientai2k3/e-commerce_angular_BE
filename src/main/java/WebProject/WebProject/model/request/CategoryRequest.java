package WebProject.WebProject.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    @NotNull(message = "Tên danh mục rỗng")
    @NotEmpty(message = "Tên danh mục rỗng")
    @Size(min=2,max=50,message="Độ dài danh mục từ 2-50 ký tự")
    private String category_Name;
}
