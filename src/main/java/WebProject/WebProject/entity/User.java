package WebProject.WebProject.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
	@Id()
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(name = "password",columnDefinition = "nvarchar(1111)")
	private String password;
	
	@Column(name = "user_Name", columnDefinition = "nvarchar(1111)")
	private String userName;

	@Column(name = "full_name", columnDefinition = "nvarchar(1111)")
	private String fullName;

	@Column(name = "address", columnDefinition = "nvarchar(1111)")
	private String address;

	@Column(name = "avatar", columnDefinition = "nvarchar(1111)")
	private String avatar;
	
	@Column(name = "email", columnDefinition = "nvarchar(1111)")
	private String email;
	
	@Column(name = "phone_Number", columnDefinition = "nvarchar(1111)")
	private String phone_Number;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

}
