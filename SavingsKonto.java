package com.company;

/**
 * Created by kim on 29-01-2015.
 */
public class SavingsKonto extends Konto {

    /**
     * Oprettelse af ny konto
     *
     * @param kontoNummer konto nummer til den nye konto
     */
    public SavingsKonto(int kontoNummer) {
        super(kontoNummer);
        setkontoType("Savings");
        setintrestRate(0.04);
    }
}
