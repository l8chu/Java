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
public class Account {
    protected double blance;
    protected Account link;
    protected SavAccount saving;
    protected CheAccount checking;
    
  public Account(double blance, Account link) {
        this.blance = blance;
        this.link = link;
    }
  public double getBlance(){
      return blance;
  }
  public void Link(Account link){
      this.link = link;
  }
  public void transfer(double amount) throws IOException{
      if(amount >= 0 &&  amount <= blance - 20){
          blance = blance - amount;
          link.blance = link.blance + amount;
          Ex5.OutFile();
      }
      else{
          System.out.println("wrong transfer money amount");
      }
  }

    @Override
    public String toString() {
        return "Account{" + "blance=" + blance + ", link=" + link + ", saving=" + saving + ", checking=" + checking + '}';
    }
 
}