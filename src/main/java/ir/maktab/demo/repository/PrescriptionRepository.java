package ir.maktab.demo.repository;

import ir.maktab.demo.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alireza.d.a
 */
@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
}
