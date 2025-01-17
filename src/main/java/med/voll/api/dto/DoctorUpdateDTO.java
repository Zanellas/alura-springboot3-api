package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

public record DoctorUpdateDTO(
        @NotNull Long id,
        String name,
        String cellphone,
        String email,
        AddressDTO address) {
}
