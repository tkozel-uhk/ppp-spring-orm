package cz.uhk.ppro.studiis.repos;

import cz.uhk.ppro.studiis.model.StudijniProgram;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositář pro entitu StudijniProgram
 */
public interface StudijniProgramRepository extends JpaRepository<StudijniProgram, Long> {
    StudijniProgram findByNazev(String nazev);
}
