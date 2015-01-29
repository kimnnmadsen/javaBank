package com.company;

/**
 * Created by kim on 29-01-2015.
 */
public class BudgetKonto extends Konto {
    public double intrest = 0.00;

    /**
     * Oprettelse af ny konto
     *
     * @param kontoNummer konto nummer til den nye konto
     */
    public BudgetKonto(int kontoNummer) {
        super(kontoNummer);
        setkontoType("Budget");
    }
}
