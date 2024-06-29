package org.lorenzo.eserciziopet.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Animale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razza;
    private String nome;
    private String sesso;

    @Temporal(TemporalType.DATE)
    private Date dataNascita;

    @ManyToOne
    @JoinColumn(name = "proprietario_id", nullable = false)
    private Proprietario proprietario;

    // Getters and Setters

    /**
     * Retrieve the ID of the animale.
     *
     * @return the ID of the animale.
     */

    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the animale.
     *
     * @param id the ID of the animale.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieve the razza of the animale.
     *
     * @return the razza of the animale.
     */

    public String getRazza() {
        return razza;
    }

    /**
     * Set the razza of the animale.
     *
     * @param razza the razza of the animale.
     */

    public void setRazza(String razza) {
        this.razza = razza;
    }

    /**
     * Retrieve the nome of the animale.
     *
     * @return the nome of the animale.
     */

    public String getNome() {
        return nome;
    }

    /**
     * Set the nome of the animale.
     *
     * @param nome the nome of the animale.
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retrieve the sesso of the animale.
     *
     * @return the sesso of the animale.
     */

    public String getSesso() {
        return sesso;
    }

    /**
     * Set the sesso of the animale.
     *
     * @param sesso the sesso of the animale.
     */

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    /**
     * Retrieve the data di nascita of the animale.
     *
     * @return the data di nascita of the animale.
     */

    public Date getDataNascita() {
        return dataNascita;
    }

    /**
     * Set the data di nascita of the animale.
     *
     * @param dataNascita the data di nascita of the animale.
     */

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * Retrieve the proprietario of the animale.
     *
     * @return the proprietario of the animale.
     */

    public Proprietario getProprietario() {
        return proprietario;
    }

    /**
     * Set the proprietario of the animale.
     *
     * @param proprietario the proprietario of the animale.
     */

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
