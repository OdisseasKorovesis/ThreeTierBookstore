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
@Table(name = "basket_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BasketItems.findAll", query = "SELECT b FROM BasketItems b")
    , @NamedQuery(name = "BasketItems.findById", query = "SELECT b FROM BasketItems b WHERE b.id = :id")
    , @NamedQuery(name = "BasketItems.findByQuantity", query = "SELECT b FROM BasketItems b WHERE b.quantity = :quantity")})
public class BasketItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "basket_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Baskets basketId;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Books bookId;

    public BasketItems() {
    }

    public BasketItems(Integer id) {
        this.id = id;
    }

    public BasketItems(Integer id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Baskets getBasketId() {
        return basketId;
    }

    public void setBasketId(Baskets basketId) {
        this.basketId = basketId;
    }

    public Books getBookId() {
        return bookId;
    }

    public void setBookId(Books bookId) {
        this.bookId = bookId;
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
        if (!(object instanceof BasketItems)) {
            return false;
        }
        BasketItems other = (BasketItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.bookstore.models.BasketItems[ id=" + id + " ]";
    }
    
}
