package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cat_id;
    private String cat_nom;
    private String cat_type;

    public Categorie() {
    }

    public Categorie(String cat_nom, String cat_type) {
        this.cat_nom = cat_nom;
        this.cat_type = cat_type;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_nom() {
        return cat_nom;
    }

    public void setCat_nom(String cat_nom) {
        this.cat_nom = cat_nom;
    }

    public String getCat_type() {
        return cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(cat_id, categorie.cat_id) && Objects.equals(cat_nom, categorie.cat_nom) && Objects.equals(cat_type, categorie.cat_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cat_id, cat_nom, cat_type);
    }
}
