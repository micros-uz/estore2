package uz.micros.estore.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class AppUser {
    public static final int ROLE_ADMIN = 0x01;
    public static final int ROLE_USER = 0x02;

    @Id
    @Column(name = "appUserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="type")
    private Integer type;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
