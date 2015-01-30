package com.company;
import java.util.Scanner;

/**
 * Created by kim on 30-01-2015.
 */
public class Menu {



    /**
     * "Tømmer" konsollen ved at printe tomme linjer, der giver en illusion
     * af at der ikke er noget i konsollen. Ved større konsol vinduer skal
     * "i < 25" forøges til et passende antal linjer
     * konsol historikken vil dog stadig være tilstede, da dette ikke er en
     * ægte konsol clear
     */
    public static void clearcon(){
        for( int i = 0; i < 25; i++ ) {
            System.out.println("");
        }
    }

    public static void bankMenu(Bank banken){
        int menuValg;
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("| BANK MENU                                   |");
        System.out.println("===============================================");
        System.out.println("| Valgmuligheder:                             |");
        System.out.println("|   1. Opret ny Kunde                         |");
        System.out.println("|   2. Liste over Kunder                      |");
        System.out.println("|   3. Liste over Konti                       |");
        System.out.println("|   4. Vis en Kundes Konti                    |");
        System.out.println("|   5. Overfør penge fra en konto til en anden|");
        System.out.println("|   6. Indsæt penge på konto                  |");
        System.out.println("|   7. Hæv penge fra konto                    |");
        System.out.println("|   8. Giv renter til alle konti i banken     |");
        System.out.println("|   9. Giv renter til alle konti for en kunde |");
        System.out.println("|  10. Giv renter til en konto                |");
        System.out.println("|  11. Afslut                                 |");
        System.out.println("===============================================");
        try {
            menuValg = sc.nextInt();
        switch (menuValg) {
            case 1:
                // Menu til oprettelse af Konti
                break;
            case 2:
                clearcon();
                banken.printAntalkunder();
                banken.printbankKunder();
                System.out.println("");
                break;
            case 3:
                clearcon();
                banken.printAntalkonti();
                banken.printbankKonti();
                System.out.println("");
                break;
            case 4:
                try {
                    clearcon();
                    banken.printbankKunder();
                    System.out.println("==============");
                    System.out.println("Indtast kundenummer");
                    int kundeID = sc.nextInt();
                    clearcon();
                    banken.printKunde(kundeID);
                    } catch (java.util.InputMismatchException e) {
                        clearcon();
                        System.out.println("Dette er ikke en valgmulighed");
                        bankMenu(banken);

                    }
                break;
            case 11:
                System.out.println("Bank Programmet afsluttes");
                break;
            default:
                System.out.println("Dette er ikke en valgmulighed");
                break;

        }
        if (menuValg != 11) {
            bankMenu(banken);
        }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Dette er ikke en valgmulighed");
            bankMenu(banken);
        }

    }



}


