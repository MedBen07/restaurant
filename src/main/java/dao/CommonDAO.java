package dao;

import entities.Plat;

import entities.Reservation;
import entities.Vin;
import jakarta.persistence.*;

import java.util.List;

public class CommonDAO {

private EntityManager entityManager;

     public CommonDAO(EntityManager entityManager){
         this.entityManager = entityManager;
     }


    /** 
    * RECUPERATION DES DONNEES DE LA TABLE PLAT EN UTILISANT DES REQUETES NOMMÉES
    * ON A UTILISÉ UNE REQUETE NOMMÉ POUR CHAQUE CATEGORIE DE PLAT
    * LES RESULTATS DE CHAQUE METHODE SERONT SAUVEGARDÉ DANS UNE LISTE ENSUITE RETOURNÉES AU SERVLET CHARGEMENT
    */

    List<Plat> listeEntrees;
    List<Plat> listeViandes;
    List<Plat> listePoissons;
    List<Plat> listeFromages;
    List<Plat> listeDesserts;
    public List<Plat> recupererListPlatEntree(){
            TypedQuery<Plat> mesPlats1 = entityManager.createNamedQuery("requeteEntrees", Plat.class);
            listeEntrees = mesPlats1.getResultList();
    return  listeEntrees;
    }
    public List<Plat> recupererListPlatPoissons(){
        TypedQuery<Plat> mesPlats2 = entityManager.createNamedQuery("requetePoissons", Plat.class);
        listePoissons = mesPlats2.getResultList();
        return  listePoissons;
    }
    public List<Plat> recupererListPlatViandes(){
        TypedQuery<Plat> mesPlats3 = entityManager.createNamedQuery("requeteViandes", Plat.class);
        listeViandes = mesPlats3.getResultList();
        return  listeViandes;
    }
    public List<Plat> recupererListPlatFromages(){
        TypedQuery<Plat> mesPlats4 = entityManager.createNamedQuery("requeteFromages", Plat.class);
        listeFromages = mesPlats4.getResultList();
        return  listeFromages;
    }
    public List<Plat> recupererListPlatDesserts(){
        TypedQuery<Plat> mesPlats5 = entityManager.createNamedQuery("requeteDesserts", Plat.class);
        listeDesserts = mesPlats5.getResultList();
        return  listeDesserts;
    }

    /**
    * RECUPERATION DES DONNEES DE LA TABLE VIN EN UTILISANT DES REQUETES NOMMÉES
    * ON A UTILISÉ UNE REQUETE NOMMÉ POUR CHAQUE CATEGORIE DU VIN
    * LES RESULTATS DE CHAQUE METHODE SERONT SAUVEGARDÉ DANS UNE LISTE ENSUITE RETOURNÉES AU SERVLET CHARGEMENT
    */

    List<Vin> listeVinsBlanc;
    List<Vin> listeVinsRouge;
    List<Vin> listeVinsMousseux;
    public List<Vin> recupererListVinBlanc(){
        TypedQuery<Vin> lesVins = entityManager.createNamedQuery("requeteVinBlanc", Vin.class);
        listeVinsBlanc = lesVins.getResultList();
        return  listeVinsBlanc;
    }

    public List<Vin> recupererListVinRouge(){
        TypedQuery<Vin> lesVins = entityManager.createNamedQuery("requeteVinRouge", Vin.class);
        listeVinsRouge = lesVins.getResultList();
        return  listeVinsRouge;
    }

    public List<Vin> recupererListVinMousseux(){
        TypedQuery<Vin> lesVins = entityManager.createNamedQuery("requeteVinMousseux", Vin.class);
        listeVinsMousseux = lesVins.getResultList();
        return  listeVinsMousseux;
    }

    /**
    * CETTE METHODE PERMET DE RECUPERER UNE LISTE DES VINS DE LA TABLE VIN , PAR CRITERE DU PAYS DE PRODUCTION
    */
    List<Vin> listeVin;
    public List<Vin> recupererListVinParPays(String nomPays){

        TypedQuery<Vin> vinPays = entityManager.createNamedQuery("requeteRechVin", Vin.class);
        vinPays.setParameter(1, nomPays);
        listeVin = vinPays.getResultList();
        return  listeVin;

    }

    /**
    * CETTE METHODE PERMET L'INSERTION DES INFORMATIONS DE RESERVATION DANS UNE TABLE
    */

    public  void insert(Reservation reservation) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(reservation);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }

    }

}
