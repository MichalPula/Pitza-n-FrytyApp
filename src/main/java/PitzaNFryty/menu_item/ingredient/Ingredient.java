package PitzaNFryty.menu_item.ingredient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @SequenceGenerator(name = "ingredient_id_generator", sequenceName = "ingredient_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_id_generator")
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

}
