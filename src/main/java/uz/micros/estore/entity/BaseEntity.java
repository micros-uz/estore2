package uz.micros.estore.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    //private static final long serialVersionUID = 1640401007252876492L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private int version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
