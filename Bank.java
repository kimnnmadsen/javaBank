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
     * @param kontoKunde    Kunden som kontoen skal tilknyttes
     * @param kontoType     Kontotypen som skal oprettes
     */
    public Konto nyKonto(Kunde kontoKunde, int kontoType){
        Konto nyKonto = nyKontoFactory(kontoType);
        if (nyKonto == null) {
            System.out.println("Kontoen kunne ikke oprettes!");
        } else {
            bankKonti.add(nyKonto);
            kontoKunde.addKonto(nyKonto);
        }
        return nyKonto;
    }

    public Konto nyKontoFactory(int kontoType){
        int kontoID;
        switch(kontoType) {
            case 1:
                kontoID = nextkontoID++;
                return new CheckingKonto(kontoID);
            case 2:
                kontoID = nextkontoID++;
                return new BudgetKonto(kontoID);
            case 3:
                kontoID = nextkontoID++;
                return new SavingsKonto(kontoID);
            default:
                System.out.println("Konto typen: "+kontoType+" findes ikke.");
                return null;
        }
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
            System.out.println("Kontonummer: "+k.getkontoNummer()+" Type: "+ k.getkontoType()+" Saldo: "+k.getSaldo());
        }
    }

    /**
     * Skriver en specifik kunde ud til konsollen og viser kundes konti samt saldo
     * @param kundeNummer   Kundenummer
     */
    public void printKunde(int kundeNummer){
        for(Kunde k: bankKunder){
            if (k.getkundeNummer() == kundeNummer) {
                System.out.println("Kundenummer: " + k.getkundeNummer() + " Navn: " + k.getforNavn() + " " + k.getefterNavn());
                for (Konto kk : k.kundeKonti){
                    System.out.println("Kontonummer: "+kk.getkontoNummer()+" Type: "+ kk.getkontoType()+" Saldo: "+kk.getSaldo());

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
                    if (t.getkontoNummer() == ToID){
                        f.transfer(amount, t);
                    }
                    // Lav Output hvis ToID ikke fundet
                }
                // Lav Output hvis FromID ikke fundet
            }
        }
    }

    /**
     * Indsætter et beløb til et kontonummer
     * @param amount    beløbet der skal indsættes
     * @param ID        Kontonummer
     */
    public void depositID(double amount, int ID){
        for (Konto d: bankKonti) {
            if (d.getkontoNummer() == ID) {
                d.deposit(amount);
            }
            // Lav Output hvis ID ikke fundet
        }
    }

    /**
     * Hæver et beløb fra et kontonummer
     * @param amount    Beløb der skal hæves
     * @param ID        Kontonummer
     */
    public void withdrawID(double amount, int ID){
        for (Konto w: bankKonti) {
            if (w.getkontoNummer() == ID) {
                w.withdraw(amount);
            }
            //Lav Output hvis ID ikke fundet
        }
    }
    public void giveintrestAll(){
        for (Konto k: bankKonti) {
            System.out.println(k);
            k.giveIntrest();
        }
    }

}
