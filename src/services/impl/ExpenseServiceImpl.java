package services.impl;

import models.Expenditure;
import models.User;
import repositories.ExpenseRepository;
import repositories.impl.InMemoryExpenseRepository;
import repositories.impl.InMemoryUserRepository;
import services.DebtService;
import services.ExpenseService;
import services.UserService;
import services.impl.UserServiceImpl;
import utils.ExpenseDataValidator;
import utils.impl.ExpenseIdGenerator;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ExpenseServiceImpl implements ExpenseService {

    UserService userService = new UserServiceImpl();
    DebtService debtService = new DebtServiceImpl();
    ExpenseDataValidator expenseDataValidator = new ExpenseDataValidator();
    ExpenseRepository expenseRepository;

    {
        expenseRepository = new InMemoryExpenseRepository();
    }

    @Override
    public Integer addExpense(String desc, String cost, String[] expenseUserIds, String payerId) {
        if(expenseDataValidator.validateDesc(desc) && expenseDataValidator.validateCost(cost) &&
            expenseDataValidator.validateExpenseUserIds(expenseUserIds) && expenseDataValidator.validatePayerId(payerId)){
            Integer generatedId = getUsersFromDatabase(desc, Double.parseDouble(cost), expenseUserIds, payerId);
            if (generatedId != null) return generatedId;

        }
        return -1;
    }

    private Integer getUsersFromDatabase(String desc, double cost, String[] expenseUserIds, String payerId) {
        ArrayList<User> expenseUsers = new ArrayList<User>();
        Boolean isUserPresentInDatabase = true;
        for(String user: expenseUserIds){
            Optional<User> expenseUser = userService.getUserById(Integer.parseInt(user));
            if(expenseUser.isPresent()){
                User sharedUser = expenseUser.get();
                expenseUsers.add(sharedUser);
            }else{
                isUserPresentInDatabase = false;
                break;
            }
        }
        Optional<User> expenseUser = userService.getUserById(Integer.parseInt(payerId));
        User payerUser = null;
        if(expenseUser.isPresent()){
            payerUser = expenseUser.get();
            expenseUsers.add(payerUser);
        }else{
            isUserPresentInDatabase = false;
        }
        if(isUserPresentInDatabase){
            Integer generatedId = ExpenseIdGenerator.getUniqueId();
            Expenditure expenditure = new Expenditure(generatedId, desc, cost,expenseUsers,payerUser);
            expenseRepository.addExpenseInDatabase(expenditure);
            debtService.addExpenseDebt(cost,expenseUsers,payerUser);
            return generatedId;
        }
        return null;
    }

    public Map<Integer,Expenditure> displayAllExpenditure(){
        return expenseRepository.getAllExpenditures();
    }

    @Override
    public Optional<Expenditure> getExpenseById(Integer id) {
        return expenseRepository.getExpenditureById(id);
    }

    @Override
    public Expenditure updateExpense(String id, String desc, String cost, String[] expenseUserIds, String payerId) {
        if(expenseDataValidator.validateId(id) && expenseDataValidator.validateDesc(desc) && expenseDataValidator.validateCost(cost) &&
                expenseDataValidator.validateExpenseUserIds(expenseUserIds) && expenseDataValidator.validatePayerId(payerId)){

        }
        return null;
    }

}
