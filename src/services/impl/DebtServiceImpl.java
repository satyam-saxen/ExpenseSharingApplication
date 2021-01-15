package services.impl;

import models.Debt;
import models.User;
import models.UserPair;
import repositories.DebtRepository;
import repositories.impl.InMemoryDebtRepository;
import services.DebtService;

import java.util.ArrayList;
import java.util.Map;

public class DebtServiceImpl implements DebtService {

    DebtRepository debtRepository = new InMemoryDebtRepository();

    @Override
    public Boolean addExpenseDebt(double cost,ArrayList<User> expenseUsers, User payer) {
        int userCount = expenseUsers.size();
        double perHeadCost = getCostPerHead(cost,userCount);
        System.out.println("Per Head Cost "+perHeadCost);
        for(User currentUser: expenseUsers){
            if(!currentUser.getId().equals(payer.getId())){
                UserPair userPair = new UserPair(currentUser,payer);
                if(!debtRepository.getUserPair(currentUser,payer) && !debtRepository.getUserPair(payer,currentUser)){
                    debtRepository.addDebtDetail(new Debt(userPair,perHeadCost));
                }else if(debtRepository.getUserPair(currentUser,payer)){
                    System.out.println("1");
                    debtRepository.updateDebtDetail(currentUser,payer,perHeadCost);
                }else if(debtRepository.getUserPair(payer,currentUser)){
                    debtRepository.updateDebtDetail(payer,currentUser,-perHeadCost);
                    System.out.println("2");
                }
            }
        }
        return null;
    }

    @Override
    public Map<UserPair, Debt> getAllDebt() {
        return debtRepository.getAllDebt();
    }

    private double getCostPerHead(double cost,int userCount){
        return cost/userCount;
    }
}
