package repositories;

import models.Expenditure;
import models.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public interface ExpenseRepository {
    void addExpenseInDatabase(Expenditure expenditure);
    Map<Integer, Expenditure> getAllExpenditures();
    Optional<Expenditure> getExpenditureById(Integer id);
    Optional<Expenditure> updateExpenditure(Integer id, String desc, double cost, ArrayList<User> expenseUsers,User payer);
    Boolean deleteExpenditureById(Integer id);
}
