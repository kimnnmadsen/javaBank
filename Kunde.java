package com.company;

import java.util.ArrayList;

public class Kunde {
    private int kundeNummer;
    private String forNavn;
    private String efterNavn;
    public ArrayList<Konto> kundeKonti;

    /**Opret nyt kunde Objekt med en liste over Konti
     *
     * @param kundeNummer   Kundens kundenummer
     * @param forNavn       Kundens Fornavn
     * @param efterNavn     Kundens Efternavn
     */
    public Kunde (int kundeNummer, String forNavn, String efterNavn){
        this.kundeNummer = kundeNummer;
        this.forNavn = forNavn;
        this.efterNavn = efterNavn;
        kundeKonti = new ArrayList<Konto>();
    }

    /**Tilføj en konto til en kundes liste over Konti
     *
     * @param nyKonto   Konto der skal tilføjes til kunden
     */
    public void addKonto(Konto nyKonto){
        kundeKonti.add(nyKonto);
    }
    public int getkundeNummer(){
        return kundeNummer;
    }
    public String getforNavn(){
        return forNavn;
    }
    public String getefterNavn(){
        return efterNavn;
    }
}
