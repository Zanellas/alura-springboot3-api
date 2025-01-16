package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.AddressDTO;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.model.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid DoctorDTO doctorDTO) {
        System.out.println(doctorDTO);
        doctorRepository.save(new Doctor(doctorDTO));
    }

    @GetMapping
    public List<DoctorDTO> findAll() {
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> new DoctorDTO(
                        doctor.getName(),
                        doctor.getEmail(),
                        doctor.getCellphone(),
                        doctor.getCrm(),
                        doctor.getSpecialty(),
                        new AddressDTO(
                                doctor.getAddress().getStreet(),
                                doctor.getAddress().getNeighborhood(),
                                doctor.getAddress().getZipcode(),
                                doctor.getAddress().getCity(),
                                doctor.getAddress().getState(),
                                doctor.getAddress().getComplement(),
                                doctor.getAddress().getNumber())
                ))
                .collect(Collectors.toList());
    }
}
