package services.impl;

import models.Debt;
import models.User;
import models.UserPair;
import repositories.DebtRepository;
import repositories.impl.InMemoryDebtRepository;
import services.DebtService;

import java.util.ArrayList;

public class DebtServiceImpl implements DebtService {

    DebtRepository debtRepository = new InMemoryDebtRepository();

    @Override
    public Boolean addExpenseDebt(double cost,ArrayList<User> expenseUsers, User payer) {
        int userCount = expenseUsers.size();
        double perHeadCost = getCostPerHead(cost,userCount);
        for(User currentUser: expenseUsers){
            if(!currentUser.equals(payer)){
                UserPair userPair = new UserPair(currentUser,payer);
                if(!debtRepository.getUserPair(currentUser,payer) && !debtRepository.getUserPair(payer,currentUser)){
                    debtRepository.addDebtDetail(new Debt(userPair,perHeadCost));
                }else if(debtRepository.getUserPair(currentUser,payer)){
                    debtRepository.updateDebtDetail(new Debt(userPair,perHeadCost));
                }
            }
        }
        return null;
    }

    private double getCostPerHead(double cost,int userCount){
        return cost/userCount;
    }
}
