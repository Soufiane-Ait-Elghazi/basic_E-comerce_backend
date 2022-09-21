package org.sid.lightecom.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String photoName;
    @OneToMany(mappedBy = "category")
    private Collection<Product> products;
}
