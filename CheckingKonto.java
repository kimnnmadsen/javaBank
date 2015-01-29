package com.company;

/**
 * Created by kim on 29-01-2015.
 */
public class CheckingKonto extends Konto {

    /**
     * Oprettelse af ny konto
     *
     * @param kontoNummer konto nummer til den nye konto
     */
    public CheckingKonto(int kontoNummer) {
        super(kontoNummer);
        setkontoType("Checking");
        setintrestRate(0.01);
    }

}
