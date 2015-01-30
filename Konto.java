package com.company;

public abstract class Konto {
    private int kontoNummer;
    private double balance;
    private String kontoType;
    private double intrestRate;

    /**
     * Oprettelse af ny konto
     * @param kontoNummer konto nummer til den nye konto
     */
    public Konto (int kontoNummer){
        this.kontoNummer = kontoNummer;
    }

    /**
     * Indsæt beløb på konto
     * @param amount    beløb der skal indsættes
     */
    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Du kan ikke indsætte 0 eller negative beløb");
        }
        else {
        balance += amount;
        System.out.println(amount+" er indsat på Kontonummer: "+kontoNummer);
        }
    }

    /**
     * Hæv beløb fra konto
     * @param amount    beløb der skal hæves
     */
    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Du kan ikke hæve 0 eller negative beløb");
        }
        if(amount <= balance){
            balance -= amount;
        }else{
            System.out.println("Konto beholdning for lav.");
            System.out.println("Du har forsøgt at hæve "+amount);
            System.out.println("Du har kun "+balance+" på din Konto");
        }
    }

    /**
     * Overfør beløb fra en konto til en anden
     * @param amount        beløb der skal overføres
     * @param modtagerKonto modtager kontoen
     */
    public void transfer(double amount, Konto modtagerKonto) {
        if(amount <= 0){
            System.out.println("Du kan overføre 0 eller eller et negative beløb");
        }
        if (amount <= balance) {
            modtagerKonto.deposit(amount);
            balance -= amount;
            System.out.println(amount +" Overført fra Kontonummer: "+kontoNummer+" til Kontonummer "+modtagerKonto.kontoNummer);
        } else {
            System.out.println("Konto beholdning for lav.");
            System.out.println("Du har forsøgt at overføre "+amount);
            System.out.println("Du har kun "+balance+" på din Konto");
        }
    }

    public double getSaldo(){
        return balance;
    }
    public int getkontoNummer(){
        return kontoNummer;
    }
    public void printKontoTypes(){
        System.out.println("Følgende kontotype er tilgængelige:");
        System.out.println("Type 1: Checking, 1% Rente");
        System.out.println("Type 2: Budget, 0% Rente");
        System.out.println("Type 3: Savings, 4% Rente");
    }


    protected void setkontoType(String kontoType){
        this.kontoType = kontoType;
    }
    public String getkontoType(){
        return kontoType;
    }
    protected void setintrestRate(double intrestRate){ this.intrestRate = intrestRate; }
    public double getintrestRate(){
        return intrestRate;
    }
    public void giveIntrest(){
        balance += balance*intrestRate;
    }

}