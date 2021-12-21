package PitzaNFryty.menu_item.sauce;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sauces")
public class Sauce {

    @Id
    @SequenceGenerator(name = "sauce_id_generator", sequenceName = "sauce_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sauce_id_generator")
    @Column(name = "id", unique = true, updatable = false)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    public Sauce(String name) {
        this.name = name;
    }

}
