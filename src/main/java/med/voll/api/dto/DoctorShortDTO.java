package med.voll.api.dto;

import med.voll.api.model.Doctor;
import med.voll.api.model.Specialty;

public record DoctorShortDTO(
        Long id,
        String name,
        String email,
        String cellphone,
        Specialty specialty) {
    public DoctorShortDTO(Doctor doctor) {
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCellphone(),
                doctor.getSpecialty()
        );
    }
}
