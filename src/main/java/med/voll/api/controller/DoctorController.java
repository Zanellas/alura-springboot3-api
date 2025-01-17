package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.dto.DoctorShortDTO;
import med.voll.api.dto.DoctorUpdateDTO;
import med.voll.api.model.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<DoctorDTO> listAll() {
        return doctorRepository.findAll()
                .stream()
                .map(DoctorDTO::new)
                .toList();
    }

    @GetMapping("/short")
    public Page<DoctorShortDTO> listAllShort(@PageableDefault(size = 5) Pageable pageable) {
        return doctorRepository.findAll(pageable)
                .map(DoctorShortDTO::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdateDTO doctorDTO) {
        var doctor = doctorRepository.getReferenceById(doctorDTO.id());
        doctor.updateInfo(doctorDTO);
    }

}
