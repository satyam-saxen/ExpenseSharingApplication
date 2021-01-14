package repositories.impl;

import models.Debt;
import models.User;
import models.UserPair;
import repositories.DebtRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryDebtRepository implements DebtRepository {
    private static Map<UserPair,Debt> AVAILABLE_DEBTS = new HashMap<>();

    @Override
    public Boolean addDebtDetail(Debt debt) {
        AVAILABLE_DEBTS.put(debt.getUserPair(),debt);
        return AVAILABLE_DEBTS.containsKey(debt.getUserPair());
    }

    public void updateDebtDetail(Debt debt){
        AVAILABLE_DEBTS.get(debt.getUserPair()).setCost(debt.getCost());
    }

    @Override
    public HashMap<UserPair,Debt> getAllDebt() {
        return new HashMap<UserPair,Debt>(AVAILABLE_DEBTS);
    }

    @Override
    public ArrayList<Debt> getDebtByDebtor(User debtor) {

        return null;
    }

    @Override
    public Boolean getUserPair(User debtor,User owner){
        return AVAILABLE_DEBTS.containsKey(new UserPair(debtor,owner));
    }

    @Override
    public ArrayList<Debt> getDebtByOwner(User owner) {
        return null;
    }
}
