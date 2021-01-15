package repositories;

import models.Debt;
import models.User;
import models.UserPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface DebtRepository {
    Boolean addDebtDetail(Debt debt);
    Map<UserPair,Debt> getAllDebt();
    Boolean getUserPair(User debtor,User owner);
    void updateDebtDetail(User debtor,User payer,double perHeadCost);
    ArrayList<Debt> getDebtByDebtor(User debtor);
    ArrayList<Debt> getDebtByOwner(User owner);
}
