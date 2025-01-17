package med.voll.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.Doctor;
import med.voll.api.model.Specialty;

public record DoctorShortDTO(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String cellphone,
        @NotNull Specialty specialty) {
    public DoctorShortDTO(Doctor doctor) {
        this(
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCellphone(),
                doctor.getSpecialty()
        );
    }
}
