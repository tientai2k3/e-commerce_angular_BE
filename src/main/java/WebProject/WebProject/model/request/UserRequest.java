package WebProject.WebProject.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "Tên tài khoản rỗng")
    @NotEmpty(message="Tên tài khoản  rỗng")
    private String userName;


    @NotNull(message = "Mật khẩu rỗng")
    @NotEmpty(message="Mật khẩu rỗng")
    private String password;


    @NotNull(message = "Họ tên rỗng")
    @NotEmpty(message="Họ tên rỗng")
    private String fullName;

    @NotNull(message = "Địa chỉ rỗng")
    @NotEmpty(message="Địa chỉ rỗng")
    private String address;

    @NotNull(message = "Email rỗng")
    @Email(message = "Email phải hợp lệ")
    @NotEmpty(message="Email rỗng")
    private String email;


    @NotNull(message = "Số điện thoại rỗng")
    @NotEmpty(message = "Số điện thoại rỗng")
    @Size(min=10,max = 11,message="Số điện thoại phải 10 số")
    private String phone_Number;

}
