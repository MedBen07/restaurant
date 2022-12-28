package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Vin")
@NamedQuery(name="requeteRechVin", query="SELECT V FROM Vin V  where  V.vin_provenance = ?1")
@NamedQuery(name="requeteVinBlanc", query="SELECT V FROM Vin V join Categorie C where V.categorie.cat_id = C.cat_id and C.cat_nom = 'Vins blancs'")
@NamedQuery(name="requeteVinRouge", query="SELECT V FROM Vin V join Categorie C where V.categorie.cat_id = C.cat_id and C.cat_nom = 'Vins rouges'")
@NamedQuery(name="requeteVinMousseux", query="SELECT V FROM Vin V join Categorie C where V.categorie.cat_id = C.cat_id and C.cat_nom = 'Vins mousseux'")
public class Vin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vin_id;
    private String vin_nom;
    private String vin_detail;
    private String vin_provenance;
    private Date vin_annee;
    private double vin_prix;

    @ManyToOne //ManyToOne: Pour mettre la relation de plusieurs Plat vers  une Categorie
    @JoinColumn(name = "vin_cat_id_ce")
    private Categorie categorie;

    public Vin() {
    }

    public Vin(Long vin_id, String vin_nom, String vin_detail, String vin_provenance, Date vin_annee, double vin_prix, Categorie categorie) {
        this.vin_id = vin_id;
        this.vin_nom = vin_nom;
        this.vin_detail = vin_detail;
        this.vin_provenance = vin_provenance;
        this.vin_annee = vin_annee;
        this.vin_prix = vin_prix;
        this.categorie = categorie;
    }
    public Vin(String vin_nom, String vin_detail, String vin_provenance, Date vin_annee, double vin_prix, Categorie categorie) {
        this.vin_nom = vin_nom;
        this.vin_detail = vin_detail;
        this.vin_provenance = vin_provenance;
        this.vin_annee = vin_annee;
        this.vin_prix = vin_prix;
        this.categorie = categorie;
    }

    public Long getVin_id() {
        return vin_id;
    }

    public void setVin_id(Long vin_id) {
        this.vin_id = vin_id;
    }

    public String getVin_nom() {
        return vin_nom;
    }

    public void setVin_nom(String vin_nom) {
        this.vin_nom = vin_nom;
    }

    public String getVin_detail() {
        return vin_detail;
    }

    public void setVin_detail(String vin_detail) {
        this.vin_detail = vin_detail;
    }

    public String getVin_provenance() {
        return vin_provenance;
    }

    public void setVin_provenance(String vin_provenance) {
        this.vin_provenance = vin_provenance;
    }

    public Date getVin_annee() {
        return vin_annee;
    }

    public void setVin_annee(Date vin_annee) {
        this.vin_annee = vin_annee;
    }

    public double getVin_prix() {
        return vin_prix;
    }

    public void setVin_prix(double vin_prix) {
        this.vin_prix = vin_prix;
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
        Vin vin = (Vin) o;
        return Double.compare(vin.vin_prix, vin_prix) == 0 && Objects.equals(vin_id, vin.vin_id) && Objects.equals(vin_nom, vin.vin_nom) && Objects.equals(vin_detail, vin.vin_detail) && Objects.equals(vin_provenance, vin.vin_provenance) && Objects.equals(vin_annee, vin.vin_annee) && Objects.equals(categorie, vin.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin_id, vin_nom, vin_detail, vin_provenance, vin_annee, vin_prix, categorie);
    }
}
