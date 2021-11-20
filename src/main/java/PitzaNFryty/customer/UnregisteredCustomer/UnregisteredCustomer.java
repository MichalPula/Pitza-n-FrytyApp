package PitzaNFryty.customer.UnregisteredCustomer;

import PitzaNFryty.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers_unregistered")
public class UnregisteredCustomer extends Customer {

    public UnregisteredCustomer(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
    }
}
