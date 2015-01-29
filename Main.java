package com.company;

public class Main {

    public static void main(String[] args) {
	    Bank MCT = new Bank("Mercantec");


        Kunde opretkunde = MCT.nyKunde("Kim", "Madsen");
        MCT.nyKonto(opretkunde, 7);
        MCT.nyKonto(opretkunde, 1);
        MCT.nyKonto(opretkunde, 3);
        MCT.nyKonto(MCT.nyKunde("Jenna","Murphy"),1);

        MCT.printAntalkunder();
        MCT.printbankKunder();
        MCT.printAntalkonti();
        MCT.depositID(100, 2);
        MCT.transferFromIDtoID(50, 2, 3);
        MCT.withdrawID(25, 3);
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
