package PitzaNFryty.customer.RegisteredCustomer;

import PitzaNFryty.customer.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers_registered")
public class RegisteredUser extends User {

    @NotNull
    @Column(name = "password")
    private String password;

    public RegisteredUser(String firstName, String lastName, String email, String password, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
        this.password = password;
    }
}
