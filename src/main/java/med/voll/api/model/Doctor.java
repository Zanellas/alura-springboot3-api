package med.voll.api.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.dto.DoctorUpdateDTO;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(DoctorDTO doctorDTO) {
        this.name = doctorDTO.name();
        this.email = doctorDTO.email();
        this.cellphone = doctorDTO.cellphone();
        this.crm = doctorDTO.crm();
        this.specialty = doctorDTO.specialty();
        this.address = new Address(doctorDTO.address());
    }

    public void updateInfo(DoctorUpdateDTO doctorDTO) {
        if (doctorDTO.name() != null) {
            this.name = doctorDTO.name();
        }
        if (doctorDTO.email() != null) {
            this.email = doctorDTO.email();
        }
        if (doctorDTO.cellphone() != null) {
            this.cellphone = doctorDTO.cellphone();
        }
        if (doctorDTO.address() != null) {
            this.address.updateAddress(doctorDTO.address());
        }

    }
}
