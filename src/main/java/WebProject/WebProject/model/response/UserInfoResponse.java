package WebProject.WebProject.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserInfoResponse {
    private long id;

    private String username;

    private String email;

    private List<String> roles;

    private String token;

    public UserInfoResponse(long id, String username, String email, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public UserInfoResponse(long id, String username, String email, List<String> roles, String token) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.token = token;
    }

    public UserInfoResponse() {
    }
}
