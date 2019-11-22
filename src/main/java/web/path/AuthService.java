package web.path;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    Map<String, String> data = new HashMap<String, String>();

    public AuthService() {
        data.put("user", "123");
        data.put("admin", "456");
    }

    public boolean check(String login, String paswrd){
        return data.containsKey(login) && data.get(login).equals(paswrd);
    }
}