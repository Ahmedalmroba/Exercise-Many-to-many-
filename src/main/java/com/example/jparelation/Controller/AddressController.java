package com.example.jparelation.Controller;

import com.example.jparelation.DTO.AddressDTO;
import com.example.jparelation.Model.Address;
import com.example.jparelation.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {


    private final AddressService addressService;
    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(200).body(addressService.getAllAddress());

    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body("address added");
    }
    @PutMapping("/update")

    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body("address updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("address deleted");
}}
