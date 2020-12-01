package ir.maktab.demo.services;

import ir.maktab.demo.domain.Prescription;
import ir.maktab.demo.exception.InvalidRequestException;
import ir.maktab.demo.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alireza.d.a
 */
@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }
    public void saveOrUpdate(Prescription prescription) throws InvalidRequestException {
        if(prescriptionRepository.save(prescription).getId() == null){
            throw new InvalidRequestException("Can't Save Prescription", (long) 404);
        }
    }

    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    public Prescription findPrescriptionById(Long id) {
        Optional<Prescription> byId = prescriptionRepository.findById(id);
        return byId.orElse(null);
    }

    public void deleteById(Long id){
        prescriptionRepository.deleteById(id);
    }
    public void delete(Prescription prescription){
        prescriptionRepository.delete(prescription);
    }
}
