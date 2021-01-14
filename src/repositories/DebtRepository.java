package repositories;

import models.Debt;
import models.User;

import java.util.ArrayList;

public interface DebtRepository {
    Boolean addDebtDetail(Debt debt);
    ArrayList<Debt> getAllDebt();
    ArrayList<Debt> getDebtByDebtor(User debtor);
    ArrayList<Debt> getDebtByOwner(User owner);
}
