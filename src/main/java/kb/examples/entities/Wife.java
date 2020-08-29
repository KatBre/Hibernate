package kb.examples.entities;

import javax.persistence.*;

@Entity
public class Wife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne(mappedBy = "wife")                   // informacja, że relacja jest zarządzana przez pole wife w encji Husband, która jest właścicielem relacjiHusband husband;
            Husband husband;

    public Wife() {
    }

    public Wife(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {             // przypisujemy obecne Wife do Husband, który jest właścicielem relacji
        this.husband = husband;
        this.husband = husband;
        this.husband.setWife(this);
    }
}
