/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.trygvejw.fant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.ntnu.tollefsen.auth.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.awt.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author trygve
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private BigDecimal price;

    @OneToMany
    private List<Photo> itemImages;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User itemOwner;

    @ManyToOne
    private User itemBuyer;


}
