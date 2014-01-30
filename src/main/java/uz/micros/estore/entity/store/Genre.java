package uz.micros.estore.entity.store;

import uz.micros.estore.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Genres")
public class Genre extends BaseEntity {

    @Column("title")
    private String title;
}
