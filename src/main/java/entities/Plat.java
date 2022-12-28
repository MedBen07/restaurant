package entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Plat")
@NamedQuery(name="requeteEntrees", query="SELECT P FROM Plat P join Categorie C where P.categorie.cat_id = C.cat_id and C.cat_nom = 'Entrées'")
@NamedQuery(name="requeteViandes", query="SELECT P FROM Plat P join Categorie C where P.categorie.cat_id = C.cat_id and C.cat_nom = 'Viandes'")
@NamedQuery(name="requeteFromages", query="SELECT P FROM Plat P join Categorie C where P.categorie.cat_id = C.cat_id and C.cat_nom = 'Fromages'")
@NamedQuery(name="requeteDesserts", query="SELECT P FROM Plat P join Categorie C where P.categorie.cat_id = C.cat_id and C.cat_nom = 'Desserts'")
@NamedQuery(name="requetePoissons", query="SELECT P FROM Plat P join Categorie C where P.categorie.cat_id = C.cat_id and C.cat_nom = 'Poissons'")
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pla_id;
    private String pla_nom;
    private String pla_detail;
    private int pla_portion;
    private double pla_prix;
    @ManyToOne(cascade= {CascadeType.ALL }, fetch=FetchType.LAZY) // (cascade= {CascadeType.ALL }, fetch=FetchType.LAZY)//ManyToOne: Pour mettre la relation de plusieurs Plat vers  une Categorie
    @JoinColumn(name = "pla_cat_id_ce")
    private Categorie categorie;

    public Plat() {
    }

    public Plat(Long pla_id, String pla_nom, String pla_detail, int pla_portion, double pla_prix, Categorie categorie) {
        this.pla_id = pla_id;
        this.pla_nom = pla_nom;
        this.pla_detail = pla_detail;
        this.pla_portion = pla_portion;
        this.pla_prix = pla_prix;
        this.categorie = categorie;
    }

    public Plat(String pla_nom, String pla_detail, int pla_portion, double pla_prix, Categorie categorie) {
        this.pla_nom = pla_nom;
        this.pla_detail = pla_detail;
        this.pla_portion = pla_portion;
        this.pla_prix = pla_prix;
        this.categorie = categorie;
    }

    public Long getPla_id() {
        return pla_id;
    }

    public void setPla_id(Long pla_id) {
        this.pla_id = pla_id;
    }

    public String getPla_nom() {
        return pla_nom;
    }

    public void setPla_nom(String pla_nom) {
        this.pla_nom = pla_nom;
    }

    public String getPla_detail() {
        return pla_detail;
    }

    public void setPla_detail(String pla_detail) {
        this.pla_detail = pla_detail;
    }

    public int getPla_portion() {
        return pla_portion;
    }

    public void setPla_portion(int pla_portion) {
        this.pla_portion = pla_portion;
    }

    public double getPla_prix() {
        return pla_prix;
    }

    public void setPla_prix(double pla_prix) {
        this.pla_prix = pla_prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return pla_portion == plat.pla_portion && Double.compare(plat.pla_prix, pla_prix) == 0 && Objects.equals(pla_id, plat.pla_id) && Objects.equals(pla_nom, plat.pla_nom) && Objects.equals(pla_detail, plat.pla_detail) && Objects.equals(categorie, plat.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pla_id, pla_nom, pla_detail, pla_portion, pla_prix, categorie);
    }
}
