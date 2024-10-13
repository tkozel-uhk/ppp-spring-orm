package cz.uhk.ppro.studiis.repos;

import cz.uhk.ppro.studiis.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositář pro entitu Student
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
