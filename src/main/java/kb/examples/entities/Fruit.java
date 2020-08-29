package kb.examples.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "fruit_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    public String description;
}
