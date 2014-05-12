/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.io.IOException;

/**
 *
 * @author l8chu
 */
public class Customer extends Userprofile{
    protected String name;
    protected String password;
    protected String role;
    protected SavAccount saving;
    protected CheAccount checking;

    public Customer(String name, String password, String role, SavAccount saving, CheAccount checking) {
        super(name, password, role, saving, checking);
        this.name = name;
        this.password = password;
        this.role = "Customer";
        this.saving = saving;
        this.checking = checking;
    }
    public Customer(){
    }
    public double viewSavBlance(){
        return saving.getBlance();
    }
    public double viewCheBlance(){
        return checking.getBlance();
    }
    public void transfer(double amount, String toWhere) throws IOException{
        switch (toWhere) {
            case "checking":
                checking.transfer(amount);
                break;
            case "saving":
                saving.transfer(amount);
                break;
        }
        
    } 
   
    
}
