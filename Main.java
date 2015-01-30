package com.company;

public class Main {

    public static void main(String[] args) {

	    // init en ny Bank kaldet Mercantec med Object ref MCT
        Bank MCT = new Bank("Mercantec");

        // Opret 2 kunder: Kim med en Checking Konto og Savings samt Jenna med en Checking Konto
        Kunde opretKim = MCT.nyKunde("Kim", "Madsen");
        MCT.nyKonto(opretKim, 1);
        MCT.nyKonto(opretKim, 3);
        MCT.nyKonto(MCT.nyKunde("Jenna","Murphy"),1);

        System.out.println("Velkommen til banken "+MCT.getBankNavn());
        Menu.bankMenu(MCT);

/**
        MCT.printAntalkunder();
        MCT.printbankKunder();
        MCT.printAntalkonti();
        MCT.depositID(100, 1);
        MCT.depositID(250,2);
        MCT.transferFromIDtoID(50, 2, 3);
        MCT.withdrawID(25, 3);
        MCT.printbankKonti();
        MCT.printKunde(1);
        MCT.giveintrestkundeID(1);


        MCT.printbankKonti();
*/
    }
}
