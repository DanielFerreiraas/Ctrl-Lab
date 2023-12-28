package br.com.danielferreira.ctrlab.modules.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String username;

    private String password;
    private String type;
    private String name;
    private String source;

    @Column(unique = true)
    private int numberRegister;
    
    private String description;

    public User(String username, String password, String type, String name, String source, int numberRegister,
            String description) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.name = name;
        this.source = source;
        this.numberRegister = numberRegister;
        this.description = description;
    }

}
