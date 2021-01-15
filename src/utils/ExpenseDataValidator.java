package utils;

public class ExpenseDataValidator {
    public Boolean validateId(String id){
        Boolean isValid = true;
        for(int digit=0;digit<id.length();digit++){
            if(id.charAt(digit)<'0' && id.charAt(digit)>'9'){
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public Boolean validateDesc(String desc){
        return desc.length()>0;
    }

    public Boolean validateCost(String cost){
        Boolean isValid = true;
        for(int digit=0;digit<cost.length();digit++){
            if(cost.charAt(digit)<'0' && cost.charAt(digit)>'9'){
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public Boolean validateExpenseUserIds(String [] expenseUserIds){
        Boolean validateIds = true;
        for(int index=0;index<expenseUserIds.length;index++){
            validateIds = ifDigit(expenseUserIds, validateIds, index);
            if(!validateIds) break;
        }
        return validateIds;
    }

    public Boolean validatePayerId(String payerId){
        String [] payer = new String[]{payerId};
        Boolean isValid = true;
        return ifDigit(payer,isValid,0);
    }

    private Boolean ifDigit(String[] expenseUserIds, Boolean validateIds, int index) {
        for(int position = 0; position< expenseUserIds[index].length(); position++){
            if(expenseUserIds[index].charAt(position) <'0' && expenseUserIds[index].charAt(position)>'9'){
                validateIds = false;
                break;
            }
        }
        return validateIds;
    }


}
