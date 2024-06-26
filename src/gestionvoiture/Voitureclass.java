package gestionvoiture;

public class Voitureclass {
    private int id;
    private String marque;
    private String modele;
    private String annee;
    private String couleur;
    private String immatriculation;
    private int proprietaire_id;

    // Constructeur avec tous les paramètres
    public Voitureclass(int id, String marque, String modele, String annee, String couleur, String immatriculation, int proprietaire_id) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.couleur = couleur;
        this.immatriculation = immatriculation;
        this.proprietaire_id = proprietaire_id;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getProprietaire_id() {
        return proprietaire_id;
    }

    public void setProprietaire_id(int proprietaire_id) {
        this.proprietaire_id = proprietaire_id;
    }

    @Override
    public String toString() {
        return "Voitureclass{" + "id=" + id + ", marque=" + marque + ", modele=" + modele + ", annee=" + annee + ", couleur=" + couleur + ", immatriculation=" + immatriculation + ", proprietaire_id=" + proprietaire_id + '}';
    }
}
