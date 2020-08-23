package kb.examples.entities;

import javax.persistence.*;

@Entity
public class Husband {


    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne
    Wife wife;

}
