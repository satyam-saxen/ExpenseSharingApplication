public class InputValidator implements Validator{
    public Boolean validate(String action)
    {
        if(action.length()>1 || action.isEmpty())
            return false;
        else if(action.charAt(0)<='0' && action.charAt(0)>'9')
            return false;
        return true;
    }
}
