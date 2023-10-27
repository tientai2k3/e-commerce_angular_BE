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
public class OrderRequest {
    @NotNull(message = "Họ tên rỗng")
    @NotEmpty(message = "Họ Tên rỗng")
    @Size(min=2,max=50,message="Độ dài họ tên từ 2-50 ký tự")
    private String fullname;

    @NotNull(message = "Địa chỉ rộng")
    @NotEmpty(message = "Địa chỉ rỗng")
    @Size(min=2,max=50,message="Địa chỉ  từ 2-50 ký tự")
    private String address;

    @NotNull(message = "Số điện thoại rỗng")
    @NotEmpty(message = "Số điện thoại rỗng")
//    @Size(min=10,max=10,message="Độ dài họ tên từ 2-50 ký tự")
    private String phone;

    @NotNull(message = "Email rỗng")
    @NotEmpty(message = "Email rỗng")
//    @Size(min=2,max=50,message="Độ dài Email rỗng từ 2-50 ký tự")
    private String email;


//    @Size(min=2,max=50,message="Độ dài Email rỗng từ 2-50 ký tự")
    private String note;

    private int total;

    private Long idUser;


}
