package com.project.bookstore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "books")
@XmlRootElement
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;

    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)

    @Column(name = "nr_of_pages")
    private int nrOfPages;
    @Basic(optional = false)

    @Column(name = "publication_year")
    private int publicationYear;

    @Basic(optional = false)
    @Column(name = "price")
    private int price;

    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @Column(name = "original_title")
    private String originalTitle;
    @Lob
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(mappedBy = "booksCollection")
    @JsonManagedReference(value = "author-book")
    private Collection<Author> authorsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    @JsonBackReference(value = "basketItem-books")
    private Collection<BasketItem> basketItemsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    @JsonBackReference(value = "wishList-books")
    private Collection<WishlistItem> wishlistItemsCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "books")
    @JsonManagedReference(value = "invetory-books")
    private Inventory inventory;

    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonManagedReference(value = "genre-books")
    private Genre genreId;

    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonManagedReference(value = "language-books")
    private Language languageId;

    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonManagedReference(value = "publisher-books")
    private Publisher publisherId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    @JsonBackReference(value = "orderItem-books")
    private Collection<OrderItem> orderItemsCollection;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(String isbn, String title, int nrOfPages, int publicationYear, int price, String description, String originalTitle) {

        this.isbn = isbn;
        this.title = title;
        this.nrOfPages = nrOfPages;
        this.publicationYear = publicationYear;
        this.price = price;
        this.description = description;
        this.originalTitle = originalTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNrOfPages() {
        return nrOfPages;
    }

    public void setNrOfPages(int nrOfPages) {
        this.nrOfPages = nrOfPages;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @XmlTransient
    public Collection<Author> getAuthorsCollection() {
        return authorsCollection;
    }

    public void setAuthorsCollection(Collection<Author> authorsCollection) {
        this.authorsCollection = authorsCollection;
    }

    @XmlTransient
    public Collection<BasketItem> getBasketItemsCollection() {
        return basketItemsCollection;
    }

    public void setBasketItemsCollection(Collection<BasketItem> basketItemsCollection) {
        this.basketItemsCollection = basketItemsCollection;
    }

    @XmlTransient
    public Collection<WishlistItem> getWishlistItemsCollection() {
        return wishlistItemsCollection;
    }

    public void setWishlistItemsCollection(Collection<WishlistItem> wishlistItemsCollection) {
        this.wishlistItemsCollection = wishlistItemsCollection;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    @XmlTransient
    public Collection<OrderItem> getOrderItemsCollection() {
        return orderItemsCollection;
    }

    public void setOrderItemsCollection(Collection<OrderItem> orderItemsCollection) {
        this.orderItemsCollection = orderItemsCollection;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.bookstore.models.Books[ id=" + id + " ]";
    }

}
