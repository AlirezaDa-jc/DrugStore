package ir.maktab.demo.repository;

import ir.maktab.demo.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Alireza.d.a
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
