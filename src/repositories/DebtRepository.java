package repositories;

import models.Debt;
import models.User;
import models.UserPair;

import java.util.ArrayList;
import java.util.HashMap;

public interface DebtRepository {
    Boolean addDebtDetail(Debt debt);
    HashMap<UserPair,Debt> getAllDebt();
    Boolean getUserPair(User debtor,User owner);
    void updateDebtDetail(Debt debt);
    ArrayList<Debt> getDebtByDebtor(User debtor);
    ArrayList<Debt> getDebtByOwner(User owner);
}