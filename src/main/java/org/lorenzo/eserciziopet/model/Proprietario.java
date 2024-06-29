package org.lorenzo.eserciziopet.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Proprietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animale> animali;

    // Getters and Setters

    /**
     * Retrieve the ID of the proprietario.
     *
     * @return the ID of the proprietario.
     */

    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the proprietario.
     *
     * @param id the ID of the proprietario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieve the nome of the proprietario.
     *
     * @return the nome of the proprietario.
     */

    public String getNome() {
        return nome;
    }

    /**
     * Set the nome of the proprietario.
     *
     * @param nome the nome of the proprietario.
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retrieve the cognome of the proprietario.
     *
     * @return the cognome of the proprietario.
     */

    public String getCognome() {
        return cognome;
    }

    /**
     * Set the cognome of the proprietario.
     *
     * @param cognome the cognome of the proprietario.
     */

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Retrieve the list of animali owned by the proprietario.
     *
     * @return the list of animali owned by the proprietario.
     */

    public List<Animale> getAnimali() {
        return animali;
    }

    /**
     * Set the list of animali owned by the proprietario.
     *
     * @param animali the list of animali owned by the proprietario.
     */

    public void setAnimali(List<Animale> animali) {
        this.animali = animali;
    }
}
