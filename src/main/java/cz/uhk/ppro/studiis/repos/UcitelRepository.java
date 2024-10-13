package cz.uhk.ppro.studiis.repos;

import cz.uhk.ppro.studiis.model.Ucitel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositář pro entitu Ucitel
 */
public interface UcitelRepository extends JpaRepository<Ucitel, Long> {
}