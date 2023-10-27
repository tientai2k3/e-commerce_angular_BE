package WebProject.WebProject.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotNull(message = "Mã sản phẩm rỗng")
    @NotEmpty(message="Mã sản phẩm rỗng")
    @Size(min=2,max=50,message="Mã sản phẩm từ 2-50 ký tự")
    private String product_Code;

    @NotNull(message = "Tên sản phẩm rỗng")
    @NotEmpty(message="Tên sản phẩm rỗng")
    @Size(min=2,max=50,message="Tên sản phẩm từ 3-50 ký tự")
    private String product_Name;

    @NotNull(message = "Mô tả rỗng")
    @NotEmpty(message="Mô tả rỗng")
    @Schema(description = "Mô tả sản phẩm",example="Đây là sản phẩm thứ 1")
    @Size(min=2,max=1000,message="Mô tả sản phẩm từ 5-1000 ký tự")
    private String description;


    @NotNull(message = "Giá tiền rỗng")
    @NotEmpty(message = "Giá tiền rỗng")
    @Schema(description = "Giá sản phẩm",example = "12")
    @Size(min=1,message="Giá tiền sản phẩm lớn hơn 0")
    private int price;

    @NotNull(message = "Số lượng sản phẩm")
    @NotEmpty(message="Số lượng sản phẩm")
    @Size(min=1,message="Số lượng sản phẩm từ 0")
    private int quantity;

    @NotNull(message = "Danh mục rỗng")
    @NotEmpty(message = "Danh mục rỗng")
    private Long categoryId;

    @NotNull(message = "Màu sắc rỗng")
    @NotEmpty(message = "Màu sắc rỗng")
    private Long colorId;

    private String image;

}
