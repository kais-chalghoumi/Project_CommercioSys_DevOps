package tn.esprit.devops_project.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStock;
    String title;
    @OneToMany(mappedBy = "stock")
    Set<Product> products;

    public Stock(String title, Set<Product> products) {
        this.title = title;
        this.products = products;
    }

}
