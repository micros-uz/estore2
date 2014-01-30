package uz.micros.estore.entity.store;

import uz.micros.estore.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    @Column("name")
    private String name;
}
