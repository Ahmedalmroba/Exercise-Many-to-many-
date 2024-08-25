package com.example.jparelation.Repository;

import com.example.jparelation.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressById(Integer id);
}
