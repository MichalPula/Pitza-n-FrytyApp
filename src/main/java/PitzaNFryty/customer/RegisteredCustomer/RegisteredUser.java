package PitzaNFryty.customer.RegisteredCustomer;

import PitzaNFryty.customer.User;
import PitzaNFryty.jwt_authentication.role.Role;
import PitzaNFryty.jwt_authentication.role.RoleConverter;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users_registered")
public class RegisteredUser extends User {

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Convert(converter = RoleConverter.class)
    private Role role;

    @Column(name = "is_account_active")
    private boolean isAccountActive = true;

    public RegisteredUser(String firstName, String lastName, String username, String password, Role role, String phoneNumber) {
        super(firstName, lastName, username, phoneNumber);
        this.password = password;
        this.role = role;
    }
}
