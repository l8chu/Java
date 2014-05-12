/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

/**
 *
 * @author l8chu
 */
public class SavAccount extends Account{
    protected double saving;
    protected Account link;

    public SavAccount(double blance, Account link) {
        super(blance, link);
    }



    public double getSavBlance(){
        return saving;
    }
    public void desposittoSaving(double amount){
        if(amount > 0){
            saving = saving + amount;
        }
        else{
            System.out.println("wrong money amount");
        }
    }
    public void withdrawfromSaving(double amount){
        if(amount <= saving){
            saving = saving - amount;
        }
        else {
            System.out.println("wrong money amount");
        }
    }

}
