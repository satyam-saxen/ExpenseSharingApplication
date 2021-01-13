public class ExpenseIdGenerator implements Generator{
    private static int UNIQUE_ID = 0;

    public static int getUniqueId() {
        return ++UNIQUE_ID;
    }
}
