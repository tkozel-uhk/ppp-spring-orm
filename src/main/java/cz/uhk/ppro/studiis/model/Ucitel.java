package cz.uhk.ppro.studiis.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * JPA Entita Ucitel - odvozená od Osoby
 * @see Osoba
 */
@Entity
public class Ucitel extends Osoba {
    @OneToMany(mappedBy = "garant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Predmet> garantovanePredmety = new HashSet<>();

    public Set<Predmet> getGarantovanePredmety() {
        return garantovanePredmety;
    }

    public void setGarantovanePredmety(Set<Predmet> garantovanePredmety) {
        this.garantovanePredmety = garantovanePredmety;
    }
}
