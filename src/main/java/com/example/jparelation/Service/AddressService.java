package com.example.jparelation.Service;

import com.example.jparelation.ApiException.ApiException;
import com.example.jparelation.DTO.AddressDTO;
import com.example.jparelation.Model.Address;
import com.example.jparelation.Model.Teacher;
import com.example.jparelation.Repository.AddressRepository;
import com.example.jparelation.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacherId());
        if (teacher == null) {
            throw new ApiException("Teacher Not Found");
        }
        Address address = new Address(addressDTO.getTeacherId(),addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }
    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacherId());
        if (address == null) {
            throw new ApiException("Teacher Not Found");
        }
            address.setArea(addressDTO.getArea());
            address.setStreet(addressDTO.getStreet());
            address.setBuildingNumber(addressDTO.getBuildingNumber());
            addressRepository.save(address);

        }
        public void deleteAddress(Integer id) {
        if (addressRepository.findAddressById(id) == null) {
            throw new ApiException("Address Not Found");
        }
        addressRepository.deleteById(id);
        }
    }


