package com.company;

import java.util.ArrayList;

public class Bank {
    private String bankNavn; // Bankens Navn
    private int nextkundeID = 1; // Kunde ID, første ID er 1
    private int nextkontoID = 1; // Konto ID, første ID er 1
    private ArrayList<Kunde> bankKunder; // Liste over alle Kunder i banken
    private ArrayList<Konto> bankKonti; // Liste over alle Konti i banken

    /**
     * Opretter en bank med et navn, samt opretter en tom kunde og konto liste
     * @param name  Navnet på banken
     */
    public Bank(String name){
        bankNavn = name;
        bankKunder = new ArrayList<Kunde>();
        bankKonti = new ArrayList<Konto>();
    }

    /**
     * Opret ny kunde og til føj til listen over kunder
     * @param forNavn   Kundens Fornavn
     * @param efterNavn Kundens Efternavn
     */
    public Kunde nyKunde(String forNavn, String efterNavn){
        int kundeID;
        kundeID = nextkundeID++;
        Kunde nyKunde = new Kunde(kundeID, forNavn, efterNavn);
        this.bankKunder.add(nyKunde);
        return nyKunde;
    }

    /**
     * Opretter en ny konto, tilføj til listen over konti og tilknyt den til en kunde
     * @param Kunde Kunden som kontoen skal tilknyttes
     */
    public Konto nyKonto(Kunde Kunde){
        int kontoID;
        kontoID = nextkontoID++;
        Konto nyKonto = new Konto(kontoID);
        bankKonti.add(nyKonto);
        Kunde.addKonto(nyKonto);
        return nyKonto;
    }

    /**
     * Få bankens Navn
     * @return  Bankens Navn
     */
    public String getBankNavn(){
            return this.bankNavn;
    }

    /**
     * Skriver Antal kunder i Banken
     */
    public void printAntalkunder(){
        System.out.println("Antal kunder i "+this.bankNavn+": "+this.bankKunder.size());
    }

    /**
     * Skriver kunder i banken med Kundenummer samt for- og efternavn
     */
    public void printbankKunder(){
        for(Kunde k: bankKunder){
            System.out.println("Kundenummer: "+k.getkundeNummer()+" Navn: "+k.getforNavn()+" "+k.getefterNavn());
        }
    }

    /**
     * Skriver antal bankkonti i banken
     */
    public void printAntalkonti(){
        System.out.println("Antal konti i "+this.bankNavn+": "+this.bankKonti.size());
    }

    /**
     * Skriver konti i banken samt deres saldo
     */
    public void printbankKonti(){
        for(Konto k: bankKonti){
            System.out.println("Kontonummer: "+k.getkontoNummer()+" Saldo: "+k.getSaldo());
        }
    }

    /**
     * Skriver en specifik kunde ud til konsollen og viser kundes konti samt saldo
     * @param kundeNummer
     */
    public void printKunde(int kundeNummer){
        for(Kunde k: bankKunder){
            if (k.getkundeNummer() == kundeNummer) {
                System.out.println("Kundenummer: " + k.getkundeNummer() + " Navn: " + k.getforNavn() + " " + k.getefterNavn());
                for (Konto kk : k.kundeKonti){
                    System.out.println("Kontonummer: "+kk.getkontoNummer()+" Saldo: "+kk.getSaldo());

                }


            }
        // Lav Output hvis ikke fundet
        }
    }

    /**
     * Lav en Overførsel fra en konto til en anden ved hjælp af KontoNummer
     * @param amount    beløb der skal overføres
     * @param FromID    Kontonummer der skal overføres fra
     * @param ToID      Kontonummer der skal overføres til
     */
    public void transferFromIDtoID(double amount, int FromID, int ToID){
        for (Konto f: bankKonti){
            if (f.getkontoNummer() == FromID) {
                for (Konto t: bankKonti){
                    if (f.getkontoNummer() == ToID){
                        f.transfer(amount, t);
                    }
                    // Lav Output hvis ToID ikke fundet
                }
                // Lav Output hvis FromID ikke fundet
            }
        }
    }
}
