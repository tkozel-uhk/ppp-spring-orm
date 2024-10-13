package cz.uhk.ppro.studiis.model;
import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * JPA Entita Student - odvozená od Osoby
 * @see Osoba
 */
@Entity
public class Student extends Osoba {
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Predmet> predmety = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_studijni_program",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "studijni_program_id")
    )
    private Set<StudijniProgram> studijniProgramy = new HashSet<>();

    public Student() {
    }

    public Student(String jmeno, String prijmeni) {
        setJmeno(jmeno);
        setPrijmeni(prijmeni);
    }

    public Set<Predmet> getPredmety() {
        return predmety;
    }

    public void setPredmety(Set<Predmet> predmety) {
        this.predmety = predmety;
    }

    public Set<StudijniProgram> getStudijniProgramy() {
        return studijniProgramy;
    }

    public void setStudijniProgramy(Set<StudijniProgram> studijniProgramy) {
        this.studijniProgramy = studijniProgramy;
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, jmeno='%s', prijmeni='%s', predmety=%s, studijniProgramy=%s}",
                getId(), getJmeno(), getPrijmeni(),
                predmety.stream().reduce("", (acc, predmet) -> acc + predmet.getNazev() + ", ", String::concat),
                studijniProgramy.stream().reduce("", (acc, program) -> acc + program.getNazev() + ", ", String::concat)
        );
    }
}
