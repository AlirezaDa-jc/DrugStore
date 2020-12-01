package ir.maktab.demo.services;

import ir.maktab.demo.domain.Patient;
import ir.maktab.demo.exception.InvalidRequestException;
import ir.maktab.demo.repository.PatientRepository;
import ir.maktab.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alireza.d.a
 */
@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void saveOrUpdate(Patient patient) throws InvalidRequestException {
        if( patientRepository.save(patient).getId() == null){
            throw new InvalidRequestException("Can't Save Patient", (long) 404);
        }
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findPatientById(Long id) {
        Optional<Patient> byId = patientRepository.findById(id);
        return byId.orElse(null);
    }

    public void deleteById(Long id){
        patientRepository.deleteById(id);
    }
    public void delete(Patient patient){
        patientRepository.delete(patient);
    }
}
