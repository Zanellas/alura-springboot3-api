package med.voll.api.dto;

import med.voll.api.model.Specialty;

public record DoctorDTO(
        String name,
        String email,
        String crm,
        Specialty specialty,
        AddressDTO dataAddress

) {
}
