/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookstore.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chatz
 */
@Entity
@Table(name = "wishlist_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WishlistItems.findAll", query = "SELECT w FROM WishlistItems w")
    , @NamedQuery(name = "WishlistItems.findById", query = "SELECT w FROM WishlistItems w WHERE w.id = :id")})
public class WishlistItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Books bookId;
    @JoinColumn(name = "wishlist_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Wishlists wishlistId;

    public WishlistItems() {
    }

    public WishlistItems(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Books getBookId() {
        return bookId;
    }

    public void setBookId(Books bookId) {
        this.bookId = bookId;
    }

    public Wishlists getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Wishlists wishlistId) {
        this.wishlistId = wishlistId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WishlistItems)) {
            return false;
        }
        WishlistItems other = (WishlistItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.bookstore.models.WishlistItems[ id=" + id + " ]";
    }
    
}
