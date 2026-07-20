package Session15.exercise01;

import java.sql.Date;

/**
 * Data model representing a row in the Product table.
 */
public class Product {
    private int id;
    private String name;
    private float price;
    private String title;
    private Date created;
    private String catalog;
    private boolean status; // true = active (1), false = inactive (0)

    public Product(int id, String name, float price, String title, Date created, String catalog, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.title = title;
        this.created = created;
        this.catalog = catalog;
        this.status = status;
    }

    public Product(String name, float price, String title, Date created, String catalog, boolean status) {
        this(0, name, price, title, created, catalog, status);
    }

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Date getCreated() { return created; }
    public void setCreated(Date created) { this.created = created; }
    public String getCatalog() { return catalog; }
    public void setCatalog(String catalog) { this.catalog = catalog; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("[ID=%d] %s | Price: %.2f | Title: %s | Created: %s | Catalog: %s | Status: %s",
                id, name, price, title, created.toString(), catalog, status ? "Active" : "Inactive");
    }
}
