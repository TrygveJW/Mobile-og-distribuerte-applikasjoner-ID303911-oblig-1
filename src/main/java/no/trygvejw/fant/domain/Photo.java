/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.trygvejw.fant.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author trygve
 */
@Entity
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    String id;

    String name;

    long filesize;
    String mimeType;

    @ManyToOne
    Item photoItem;

    public Photo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Item getPhotoItem() {
        return photoItem;
    }

    public void setPhotoItem(Item photoItem) {
        this.photoItem = photoItem;
    }
}
