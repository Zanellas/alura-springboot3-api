package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.Address;

public record AddressDTO(
        @NotBlank String street,
        @NotBlank String neighborhood,
        @NotBlank @Pattern(regexp = "\\d{8}") String zipcode,
        @NotBlank String city,
        @NotBlank String state,
        String complement,
        String number) {

    public AddressDTO(Address address) {
        this(
                address.getStreet(),
                address.getNeighborhood(),
                address.getZipcode(),
                address.getCity(),
                address.getState(),
                address.getComplement(),
                address.getNumber());
    }
}
