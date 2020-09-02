/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.trygvejw.fant.domain;

import no.ntnu.tollefsen.auth.User;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author trygve
 */
@Entity
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

    public Item() {
    }

    public Item(Long id, String title, String description, BigDecimal price, List<Photo> itemImages, User itemOwner, User itemBuyer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.itemImages = itemImages;
        this.itemOwner = itemOwner;
        this.itemBuyer = itemBuyer;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Photo> getItemImages() {
        return itemImages;
    }

    public void setItemImages(List<Photo> itemImages) {
        this.itemImages = itemImages;
    }

    public User getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(User itemOwner) {
        this.itemOwner = itemOwner;
    }

    public User getItemBuyer() {
        return itemBuyer;
    }

    public void setItemBuyer(User itemBuyer) {
        this.itemBuyer = itemBuyer;
    }
}
