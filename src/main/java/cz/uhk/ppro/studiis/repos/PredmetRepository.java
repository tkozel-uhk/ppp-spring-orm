package cz.uhk.ppro.studiis.repos;

import cz.uhk.ppro.studiis.model.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositář pro entitu Predmet
 */
public interface PredmetRepository extends JpaRepository<Predmet, Long> {

}
