package ir.maktab.demo.repository;

import ir.maktab.demo.domain.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alireza.d.a
 */
@Repository
public interface DrugRepository extends JpaRepository<Drug,Long> {
}
