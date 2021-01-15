package services;

import models.Debt;
import models.User;
import models.UserPair;

import java.util.ArrayList;
import java.util.Map;

public interface DebtService {
    Boolean addExpenseDebt(double cost,ArrayList<User> expenseUsers,User payer);
    Map<UserPair, Debt> getAllDebt();
}
