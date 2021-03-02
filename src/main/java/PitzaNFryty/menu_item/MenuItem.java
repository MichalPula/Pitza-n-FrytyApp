package PitzaNFryty.menu_item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "is_available")
    private boolean isAvailable = true;

    @Column(name = "image_url", unique = true)
    private String imageURL ;

    public MenuItem(String name, boolean isAvailable, String imageURL) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.imageURL = imageURL;
    }

    public MenuItem(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    public MenuItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
