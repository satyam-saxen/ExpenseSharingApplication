package services;

import models.Expenditure;

import java.util.Map;
import java.util.Optional;

public interface ExpenseService {
    Integer addExpense(String desc,String cost,String [] expenseUserIds, String payerId);
    Map<Integer, Expenditure> displayAllExpenditure();
    Optional<Expenditure> getExpenseById(Integer id);
    Expenditure updateExpense(String id,String desc,String cost,String [] expenseUserIds, String payerId);
}
