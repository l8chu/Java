/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.util.ArrayList;


/**
 *
 * @author l8chu
 */
public class Userprofile {
    protected String name;
    protected String password;
    protected String role;
    protected SavAccount saving;
    protected CheAccount checking;
    protected Account link;

    public Userprofile(String name, String password, String role, SavAccount saving, CheAccount checking) {
        this.name = name;
        this.password = password;
        this.role = "Customer";
        this.saving = saving;
        this.checking = checking;
    }
    public Userprofile(){
        
    }
      public String getRole() {
        return role;
    }

    public String getUsername() {
        return name;
    }

    public String getPassword() {
        return password;
    }
        
    public Double getCheBlance(){
        return checking.getBlance();
    }
    public Double getSavBlance(){
        return saving.getBlance();
    }

}
