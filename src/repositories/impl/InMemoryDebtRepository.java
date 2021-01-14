package repositories.impl;

import models.Debt;
import models.User;
import repositories.DebtRepository;

import java.util.ArrayList;

public class InMemoryDebtRepository implements DebtRepository {
    private ArrayList<Debt> AVAILABLE_DEBTS = new ArrayList<Debt>();

    @Override
    public Boolean addDebtDetail(Debt debt) {
        return AVAILABLE_DEBTS.add(debt);
    }

    @Override
    public ArrayList<Debt> getAllDebt() {
        return new ArrayList<>(AVAILABLE_DEBTS);
    }

    @Override
    public ArrayList<Debt> getDebtByDebtor(User debtor) {
        ArrayList<Debt> d = new ArrayList<>();
        for(Debt debt:AVAILABLE_DEBTS){

        }
        return d;
    }

    @Override
    public ArrayList<Debt> getDebtByOwner(User owner) {
        return null;
    }
}
