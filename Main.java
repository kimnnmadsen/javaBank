package com.company;

public class Main {

    public static void main(String[] args) {
	    Bank MCT = new Bank("Mercantec");


        Kunde opretkunde = MCT.nyKunde("Kim", "Madsen");
        Konto opretkonto = MCT.nyKonto(opretkunde);
        Konto opretkonto2 = MCT.nyKonto(opretkunde);
        MCT.nyKonto(MCT.nyKunde("Jenna","Murphy"));

        MCT.printAntalkunder();
        MCT.printbankKunder();
        MCT.printAntalkonti();
        MCT.printbankKonti();
        MCT.printKunde(1);

        //Konto Kim = new Konto(1);
        //Kim.deposit(-1000);
        //Konto Jenna = new Konto(2);
        //Jenna.deposit(200);

        //Kim.transfer(1100,Jenna);

        //Kim.printSaldo();
        //Jenna.printSaldo();
    }
}