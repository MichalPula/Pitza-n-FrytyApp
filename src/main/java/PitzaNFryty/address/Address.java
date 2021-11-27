package PitzaNFryty.address;

import PitzaNFryty.customer.User;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @SequenceGenerator(name = "address_id_generator", sequenceName = "address_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_generator")
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ToString.Exclude
    private User user;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "zip_code")
    private String zipCode;

    @NotNull
    @Column(name = "street")
    private String street;

    @NotNull
    @Column(name = "building_number")
    private String buildingNumber;

    @NotNull
    @Column(name = "flat_number")
    private String flatNumber;

    public Address(User user, String city, String zipCode, String street, String buildingNumber, String flatNumber) {
        this.user = user;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flatNumber = flatNumber;
    }
}
