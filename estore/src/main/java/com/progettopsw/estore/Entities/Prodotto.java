package com.progettopsw.estore.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
//import lombok.ToString;

import javax.persistence.*;
//import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name="prodotti")
public class Prodotto 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Basic
    @Column(name="codice", nullable = false)
    private String codice;

    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JsonIgnore
    @JoinColumn(name="id_categoria", nullable = false)
    Categoria categoria;

    @Basic
    @Column(name="nome", nullable = false)
    private String nome;

    @Basic
    @Column(name="immagine", nullable = true)
    private String UrlImmagine;

    @Basic
    @Column(name="prezzo", nullable = false)
    private double prezzo;

    @Basic
    @Column(name="descrizione", nullable = true)
    private String descrizione;

    @Basic
    @Column(name="quantità", nullable = false)
    private int quantita;

    @Basic
    private String idC;

    @Version
    @Column(name="version", nullable = false)
    private long version;
}