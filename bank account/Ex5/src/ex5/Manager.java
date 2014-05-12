/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author l8chu
 */
public class Manager {
    protected String name;
    protected String password;
    protected String role;
    protected Userprofile check;

    protected static Manager admin;
    public Manager(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;

    }
    public static Manager setManager(){
        if (admin == null) {
            admin = new Manager("admin","admin","Manager");
        }
        return admin;
    } 
    protected ArrayList<Userprofile> list;
    
    public boolean Check(String name, Double checking){
            list = Ex5.getList();
        for(Userprofile i : list){
            if(name.equals(i.getUsername())){
                return false;
            }
            else if(i.getCheBlance() < 20){
                return false;
            }
        }
        return true;
    }
    public Userprofile addUser(String name, String password, String role, Double checking, Double saving){
        role = "Customer";
        list = Ex5.getList();
        CheAccount che = new CheAccount(checking,null);
        SavAccount sav = new SavAccount (saving,che);
        che.Link(sav);
        boolean b = Check(name, checking);
              if(b == true)
            return new Customer(name,password,role,sav,che);   
              else
             System.out.println("wrong customer profile");
             return new Userprofile();
    }


     public void delUser(String name) throws IOException{

         list = Ex5.getList();
          for(Userprofile n : list){
              if(name.equals(n.getUsername())){
                   list.remove(n);
                }
        }
              }
          }

