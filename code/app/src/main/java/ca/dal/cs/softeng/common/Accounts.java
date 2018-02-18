package ca.dal.cs.softeng.common;

import java.util.HashMap;

public class Accounts {
    private static HashMap<String,String> accounts = null;
    
    public static void init() {
        if(accounts == null) {
            accounts = new HashMap<>();
            accounts.put("fred123","password");
        }
    }
    
    public static boolean checkPassword(String user, String password) {
        return accounts.containsKey(user) && accounts.get(user).equals(password);
    }
    
    public static boolean addUser(String user, String password) {
        if(accounts.containsKey(user)) {
            return false;
        }
        accounts.put(user,password);
        return true;
    }
}
