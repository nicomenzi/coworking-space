package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String nachname;

    @Column
    private String email;

    @Column
    private String password;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private Role role;

    @OneToMany(mappedBy = "person")
    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    private Set<BuchungGeraet> buchungenGeraet;

    @OneToMany(mappedBy = "person")
    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    private Set<BuchungRaum> buchungRaume;

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

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<BuchungGeraet> getBuchungenGeraet() {
        return buchungenGeraet;
    }

    public void setBuchungenGeraet(Set<BuchungGeraet> buchungenGeraet) {
        this.buchungenGeraet = buchungenGeraet;
    }

    public Set<BuchungRaum> getBuchungRaume() {
        return buchungRaume;
    }

    public void setBuchungRaume(Set<BuchungRaum> buchungRaume) {
        this.buchungRaume = buchungRaume;
    }
    

    
}
