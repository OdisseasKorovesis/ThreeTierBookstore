package com.project.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;

    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    @JsonIgnore
    private Collection<Basket> basketsCollection;

    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    private Role roleId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    @JsonIgnore
    private Collection<DeliveryAddressUser> deliveryAddressUserCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    @JsonIgnore
    private Collection<Order> ordersCollection;

    @OneToMany(mappedBy = "userId")
    @JsonIgnore
    private Collection<Wishlist> wishlistsCollection;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String username, String password, String firstName, String lastName, String email) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Basket> getBasketsCollection() {
        return basketsCollection;
    }

    public void setBasketsCollection(Collection<Basket> basketsCollection) {
        this.basketsCollection = basketsCollection;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public Collection<DeliveryAddressUser> getDeliveryAddressUserCollection() {
        return deliveryAddressUserCollection;
    }

    public void setDeliveryAddressUserCollection(Collection<DeliveryAddressUser> deliveryAddressUserCollection) {
        this.deliveryAddressUserCollection = deliveryAddressUserCollection;
    }

    @XmlTransient
    public Collection<Order> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Order> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Wishlist> getWishlistsCollection() {
        return wishlistsCollection;
    }

    public void setWishlistsCollection(Collection<Wishlist> wishlistsCollection) {
        this.wishlistsCollection = wishlistsCollection;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.bookstore.models.Users[ id=" + id + " ]";
    }

}
