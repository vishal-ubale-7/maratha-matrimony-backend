package com.matrimony.Service;

import com.matrimony.Entities.Address;
import com.matrimony.Repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService
{
    @Autowired
    private AddressRepository addressRepository;

    // Create or update address
    public Address saveAddress(Address address)
    {
        return addressRepository.save(address);
    }

    // Get all addresses
    public List<Address> getAllAddresses()
    {
        return addressRepository.findAll();
    }

    // Get address by ID
    public Optional<Address> getAddressById(Long id)
    {
        return addressRepository.findById(id);
    }

    // Delete address by ID
    public String deleteAddress(Long id)
    {
        if (addressRepository.existsById(id))
        {
            addressRepository.deleteById(id);
            return "Address deleted successfully";
        } else
        {
            return "Address not found";
        }
    }


    // Update address by ID
    public Address updateAddress(Long id, Address updatedAddress)
    {
        return addressRepository.findById(id)
                .map(existingAddress ->
                        {
                    existingAddress.setVillage(updatedAddress.getVillage());
                    existingAddress.setCity(updatedAddress.getCity());
                    existingAddress.setDistrict(updatedAddress.getDistrict());
                    existingAddress.setState(updatedAddress.getState());
                    existingAddress.setCountry(updatedAddress.getCountry());
                    existingAddress.setPinCode(updatedAddress.getPinCode());
                    existingAddress.setUser(updatedAddress.getUser());
                    return addressRepository.save(existingAddress);
                }
                ).orElse(null);
    }

}
