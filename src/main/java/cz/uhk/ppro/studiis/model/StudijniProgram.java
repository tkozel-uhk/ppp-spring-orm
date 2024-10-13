package cz.uhk.ppro.studiis.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * JPA Entita StudijniProgram
 */
@Entity
public class StudijniProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazev;
    private String typ; // bc nebo ing
    private int delka; // délka v letech

    @ManyToMany(mappedBy = "studijniProgramy")
    private Set<Student> studenti = new HashSet<>();

    //konstruktor
    public StudijniProgram() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getDelka() {
        return delka;
    }

    public void setDelka(int delka) {
        this.delka = delka;
    }

    public Set<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(Set<Student> studenti) {
        this.studenti = studenti;
    }
}
