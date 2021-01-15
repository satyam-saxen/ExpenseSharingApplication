package repositories.impl;

import models.Expenditure;
import models.User;
import repositories.ExpenseRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryExpenseRepository implements ExpenseRepository {
    private static Map<Integer, Expenditure> expenditures = new HashMap<Integer, Expenditure>();

    @Override
    public void addExpenseInDatabase(Expenditure expenditure) {
        expenditures.put(expenditure.getId(),expenditure);
    }

    @Override
    public Map<Integer, Expenditure> getAllExpenditures() {
        return expenditures;
    }

    @Override
    public Optional<Expenditure> getExpenditureById(Integer id) {
        return Optional.ofNullable(expenditures.get(id));
    }

    @Override
    public Optional<Expenditure> updateExpenditure(Integer id, String desc, double cost, ArrayList<User> expenseUsers, User payer) {
        Optional<Expenditure> maybeExpenditure = getExpenditureById(id);
        return maybeExpenditure.map(expenditure -> updateExpenditure(id, desc, cost, expenseUsers, payer, expenditure));

    }

    @Override
    public Boolean deleteExpenditureById(Integer id) {
        Optional<Expenditure> maybeExitingExpenditure = getExpenditureById(id);
        if(maybeExitingExpenditure.isPresent()){//use map
            Expenditure existingExpenditure = maybeExitingExpenditure.get();
            Expenditure isSuccessfullyDeleted = expenditures.remove(existingExpenditure.getId());
            if(isSuccessfullyDeleted.getId() == null){
                return true;
            }
        }
        return false;
    }

    private Expenditure updateExpenditure(Integer id, String desc, double cost, ArrayList<User> expenseUsers, User payer, Expenditure existingExpenditure) {
        existingExpenditure.setDesc(desc);
        existingExpenditure.setCost(cost);
        existingExpenditure.setExpenseUsers(expenseUsers);
        existingExpenditure.setPayer(payer);
        expenditures.put(id, existingExpenditure);
        return existingExpenditure;
    }
}
