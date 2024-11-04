public class Login {
    private static final String VALID_USER = "user"; 
    private static final String VALID_PASS = "password"; 

    public boolean authenticate(String username, String password) {
        return VALID_USER.equals(username) && VALID_PASS.equals(password);
    }
}