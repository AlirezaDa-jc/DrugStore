package ir.maktab.demo.services;

import ir.maktab.demo.domain.Drug;
import ir.maktab.demo.exception.InvalidRequestException;
import ir.maktab.demo.repository.DrugRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Alireza.d.a
 */
@Service
public class DrugService {
    private final DrugRepository drugRepository;

    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    public void saveOrUpdate(Drug drug) throws InvalidRequestException {
        if( drugRepository.save(drug).getId() == null){
            throw new InvalidRequestException("Can't Save Drug", (long) 404);
        }
    }

    public List<Drug> findAll() {
        return drugRepository.findAll();
    }

    public Drug findDrugById(Long id) {
        Optional<Drug> byId = drugRepository.findById(id);
        return byId.orElse(null);
    }

    public void deleteById(Long id){
        drugRepository.deleteById(id);
    }
    public void delete(Drug drug){
        drugRepository.delete(drug);
    }
}
