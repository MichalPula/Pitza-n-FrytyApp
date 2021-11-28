package PitzaNFryty.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select new PitzaNFryty.address.AddressReadDTO(a.id, a.city, a.zipCode, a.street, a.buildingNumber, a.flatNumber)" +
            " from Address a where a.user.id = :customerId")
    List<AddressReadDTO> getUsersAddresses(Long customerId);
}
