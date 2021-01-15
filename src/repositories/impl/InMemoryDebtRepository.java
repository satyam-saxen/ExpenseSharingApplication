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
        double previousCost = AVAILABLE_DEBTS.get(debt.getUserPair()).getCost();
        double modifiedCost = debt.getCost() + previousCost;
        System.out.println("Change in cost "+previousCost + " " + modifiedCost);
        AVAILABLE_DEBTS.get(debt.getUserPair()).setCost(modifiedCost);
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
        Debt debt = AVAILABLE_DEBTS.get(new UserPair(debtor,owner));
        return debt != null;
    }

    @Override
    public ArrayList<Debt> getDebtByOwner(User owner) {
        return null;
    }
}
