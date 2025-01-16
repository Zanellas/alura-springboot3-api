package med.voll.api.dto;

public record AddressDTO(
        String street,
        String neighborhood,
        String zipcode,
        String city,
        String state,
        String complement,
        String number
) {
}
