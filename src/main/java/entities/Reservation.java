
package entities;


import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long res_id;
    private String res_nom;
    private String res_prenom;
    private String res_email;
    private String res_telephone;
    private String res_date;
    private int res_nombrepersonne;
    private String res_message;

    public Reservation() {
    }

    public Reservation(Long res_id, String res_nom, String res_prenom, String res_email, String res_telephone,
                       String res_date, int res_nombrepersonne, String res_message) {
        this.res_id = res_id;
        this.res_nom = res_nom;
        this.res_prenom = res_prenom;
        this.res_email = res_email;
        this.res_telephone = res_telephone;
        this.res_date = res_date;
        this.res_nombrepersonne = res_nombrepersonne;
        this.res_message = res_message;
    }

    public Reservation(String res_nom, String res_prenom, String res_email, String res_telephone,
                       String res_date, int res_nombrepersonne, String res_message) {
        this.res_nom = res_nom;
        this.res_prenom = res_prenom;
        this.res_email = res_email;
        this.res_telephone = res_telephone;
        this.res_date = res_date;
        this.res_nombrepersonne = res_nombrepersonne;
        this.res_message = res_message;
    }

    public Long getRes_id() {
        return res_id;
    }

    public void setRes_id(Long res_id) {
        this.res_id = res_id;
    }

    public String getRes_nom() {
        return res_nom;
    }

    public void setRes_nom(String res_nom) {
        this.res_nom = res_nom;
    }

    public String getRes_prenom() {
        return res_prenom;
    }

    public void setRes_prenom(String res_prenom) {
        this.res_prenom = res_prenom;
    }

    public String getRes_email() {
        return res_email;
    }

    public void setRes_email(String res_email) {
        this.res_email = res_email;
    }

    public String getRes_telephone() {
        return res_telephone;
    }

    public void setRes_telephone(String res_telephone) {
        this.res_telephone = res_telephone;
    }

    public String getRes_date() {
        return res_date;
    }

    public void setRes_date(String res_date) {
        this.res_date = res_date;
    }

    public int getRes_nombrepersonne() {
        return res_nombrepersonne;
    }

    public void setRes_nombrepersonne(int res_nombrepersonne) {
        this.res_nombrepersonne = res_nombrepersonne;
    }

    public String getRes_message() {
        return res_message;
    }

    public void setRes_message(String res_message) {
        this.res_message = res_message;
    }
}

