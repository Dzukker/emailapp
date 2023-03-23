package emailapp;

public class User {

    private String email;
    private String password;
    private String altEmail;
    private int mailboxCapacity;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getAltEmail(){
        return this.altEmail;
    }
    public int getMailboxCapacity(){
        return this.mailboxCapacity;
    }
}

