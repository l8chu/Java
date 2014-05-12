/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

/**
 *
 * @author l8chu
 */
public class CheAccount extends Account{
    protected double checking;
    protected Account link;

    public CheAccount(double checking, Account link) {
        super(checking, link);
        this.checking = checking;
        this.link = link;
    }


    public double getCheBlance(){
        return checking;
    }
    public void desposittoChecking(double amount){
        if(amount > 0){
            checking = checking + amount;
        }
        else{
            System.out.println("wrong money amount");
        }
    }
    public void withdrawfromChecking(double amount){
        if(amount <= checking - 20){
            checking = checking - amount;
        }
        else {
            System.out.println("wrong money amount");
        }
    }

}
