package ir.maktab.demo.repository;

import ir.maktab.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alireza.d.a
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByLastName(String lastName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
}
