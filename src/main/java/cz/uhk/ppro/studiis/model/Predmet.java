package cz.uhk.ppro.studiis.model;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

/**
 * JPA Entita předmět
 */
@Entity
public class Predmet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zkratka;
    private String nazev;
    private int pocetHodinPrednasky;
    private int pocetHodinCviceni;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "garant_id")
    private Ucitel garant;

    public Predmet() {
    }

    // Gettery a settery

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZkratka() {
        return zkratka;
    }

    public void setZkratka(String zkratka) {
        this.zkratka = zkratka;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getPocetHodinPrednasky() {
        return pocetHodinPrednasky;
    }

    public void setPocetHodinPrednasky(int pocetHodinPrednasky) {
        this.pocetHodinPrednasky = pocetHodinPrednasky;
    }

    public int getPocetHodinCviceni() {
        return pocetHodinCviceni;
    }

    public void setPocetHodinCviceni(int pocetHodinCviceni) {
        this.pocetHodinCviceni = pocetHodinCviceni;
    }

    public Ucitel getGarant() {
        return garant;
    }

    public void setGarant(Ucitel garant) {
        this.garant = garant;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "id=" + id +
                ", zkratka='" + zkratka + '\'' +
                ", nazev='" + nazev + '\'' +
                ", pocetHodinPrednasky=" + pocetHodinPrednasky +
                ", pocetHodinCviceni=" + pocetHodinCviceni +
                ", garant=" + garant +
                '}';
    }
}
