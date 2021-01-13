import java.util.HashMap;
import java.util.Map;

public class ExpenseDatabase {
    private static Map<Integer,Expenditure> expenditures = new HashMap<Integer, Expenditure>();

    public static Integer addExpenditureInDatabase(Expenditure expenditure){
        expenditures.put(expenditure.getId(),expenditure);
        return expenditure.getId();
    }
    public static Map<Integer, Expenditure> getExpenditures(){
        return expenditures;
    }

    public static Expenditure findExpenditureById(int data){
        Integer id = data;
        return expenditures.get(id);
    }
    
}
