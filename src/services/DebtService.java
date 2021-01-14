package services;

import models.User;

import java.util.ArrayList;

public interface DebtService {
    Boolean addExpenseDebt(double cost,ArrayList<User> expenseUsers,User payer);
}
