package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.Doctor;
import med.voll.api.model.Specialty;

public record DoctorDTO(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String cellphone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull Specialty specialty,
        @NotNull @Valid AddressDTO address) {

    public DoctorDTO(Doctor doctor) {
        this(
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCellphone(),
                doctor.getCrm(),
                doctor.getSpecialty(),
                new AddressDTO(doctor.getAddress()));
    }
}
