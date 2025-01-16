package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.PatientDTO;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Patient")
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String cellphone;

    @Embedded
    private Address address;

    public Patient(PatientDTO patientDTO) {
        this.name = patientDTO.name();
        this.email = patientDTO.email();
        this.cellphone = patientDTO.cellphone();
        this.cpf = patientDTO.cpf();
        this.address = new Address(patientDTO.address());
    }



}
