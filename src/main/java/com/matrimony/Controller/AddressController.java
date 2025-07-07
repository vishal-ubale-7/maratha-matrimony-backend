package com.matrimony.Controller;

import com.matrimony.Entities.Address;
import com.matrimony.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController
{

    @Autowired
    private AddressService addressService;

    // Create
    @PostMapping
    public Address saveAddress(@RequestBody Address address)
    {
        return addressService.saveAddress(address);
    }

    // Get All
    @GetMapping
    public List<Address> getAllAddresses()
    {
        return addressService.getAllAddresses();
    }

    // Get by ID
    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id)
    {
        return addressService.getAddressById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address updatedAddress)
    {
        return addressService.updateAddress(id, updatedAddress);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id)
    {
        return addressService.deleteAddress(id);
    }

}
