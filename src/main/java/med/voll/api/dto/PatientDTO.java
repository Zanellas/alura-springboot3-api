package med.voll.api.dto;

public record PatientDTO(
        String name,
        String email,
        String phoneNUmber,
        String cpf,
        AddressDTO addressDTO
) {
}
