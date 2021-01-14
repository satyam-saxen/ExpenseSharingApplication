package services;

import models.Expenditure;

import java.util.Map;

public interface ExpenseService {
    Integer addExpense(String desc,String cost,String [] expenseUserIds, String payerId);
    Map<Integer, Expenditure> displayAllExpenditure();
}
