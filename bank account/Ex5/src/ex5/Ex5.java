/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author l8chu
 */
public class Ex5 {

    /**
     * @param args the command line arguments
     */
    protected static SavAccount saving;
    protected static CheAccount checking;
    protected static ArrayList<Userprofile> list = new ArrayList();
    protected static Userprofile check;
        protected static Manager s;
    public static void addList(Userprofile user) {
        Ex5.list.add(user);
    }

    public static ArrayList<Userprofile> getList() {

        return list;
    }

    public static boolean correctLogin(String username, String password) {
        list = getList();
        for (Userprofile temp : list) {
            if (username.equals(temp.getUsername()) && password.equals(temp.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList InFile() throws FileNotFoundException, IOException {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Userprofile> temp = new ArrayList<>();

        temp = getList();
        String text = null;
        try (BufferedReader in = new BufferedReader(new FileReader("list.txt"))) {

            while ((text = in.readLine()) != null) {
                list1.add(text);
            }
            in.close(); 
        } 
        for (int i = 0;i<list1.size();i =i+5){
            temp.add(Manager.setManager().addUser(list1.get(i),list1.get(i+1),list1.get(i+2),Double.parseDouble(list1.get(i+3)),Double.parseDouble(list1.get(i+4))));
        }
        return temp;

    }

    public static void OutFile() throws IOException {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Userprofile> temp;
        temp = getList();
        for (int i = 0; i < temp.size(); i++) {
            list1.add(temp.get(i).getUsername());
            list1.add(temp.get(i).getPassword());
            list1.add(temp.get(i).getRole());
            list1.add(temp.get(i).getCheBlance().toString());
            list1.add(temp.get(i).getSavBlance().toString());
        }
        Writer out = null;
        File file = new File("list.txt");
        try {
            out = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
        }

        for (String imp : list1) {
            try {
                out.write(imp);
                out.flush();
                out.write(System.getProperty("line.separator"));
            } catch (Exception e) {
            }
        }
                       //out.close();
    }

    public static void display1() {
        System.out.println("Enter your login name");
    }

    public static void display2() {
        System.out.println("Enter your login password");
    }

    public static void display3() {
        System.out.println("Exit");
    }

    public static void LoginManager(String name, String password) throws IOException {
        String choice = "";
        String saving;
        String checking;
        Userprofile user = null;
        Scanner input = new Scanner(System.in);
        display1();
        name = input.next();
        display2();
        password = input.next();
        list = getList();
        if (name.equals("admin") && password.equals("admin")) {
            while (!choice.equals("3")) {
                System.out.println("1. Add new Customer");
                System.out.println("2. Delete Customer");
                System.out.println("3. Logout");
                choice = input.next();

                if (choice.equals("1")) {
                    System.out.println("Customer name ");
                    name = input.next();
                    System.out.println("Account password ");
                    password = input.next();
                    System.out.println("Checking account blance");
                    checking = input.next();
                    System.out.println("Saving account blance");
                    saving = input.next();
                    user = Manager.setManager().addUser(name, password, "Customer", Double.parseDouble(checking), Double.parseDouble(saving));

                    list.add(user);  

                } else if (choice.equals("2")) {
                    System.out.println("Enter customer name you want delete");
                    name = input.next();              
                        Manager.setManager().delUser(name);               
                }
            }
        } else {
            System.out.println("wrong name or password");
        }
    }

    public static void LoginCustomer(String name, String password) throws IOException {
        String choice = "";

        Userprofile user = null;
        Scanner input = new Scanner(System.in);
        display1();
        name = input.next();
        display2();
        password = input.next();
        if (correctLogin(name, password)) {
            ArrayList<Userprofile> temp = getList();
            String amount;

            for (Userprofile i : temp) {
                if (i.getUsername().equals(name)) {
                    user = i;
                }
            }
            while (!choice.equals("3")) {
                System.out.println("1. View balance");
                System.out.println("2. Transfer");
                System.out.println("3. Logout");
                choice = input.next();
                if (choice.equals("1")) {
                    System.out.println("Checking blance" + user.getCheBlance());
                    //user.getCheBlance();
                    System.out.println("Saving blance" + user.getSavBlance());
                    //user.getSavBlance();
                } else if (choice.equals("2")) {
                    System.out.println("Enter the amount you wanna transfer");
                    amount = input.next();
                    System.out.println("Enter 'saving' for transfering to Saving or Enter 'checking' for transfering to Checking");
                    choice = input.next();
                    if (choice.equals("saving")) {
                        user.checking.transfer(Double.parseDouble(amount));
                    } else if (choice.equals("checking")) {
                        user.saving.transfer(Double.parseDouble(amount));
                    }
                }

            }

        } else {
            System.out.println("wrong user name or password");
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        InFile();
        String name = "";
        String password = "";
        String choice = "";
       
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your idenity");
        while (!choice.equals("3")) {
            System.out.println("1. Manager");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
           
            choice = input.next();
            if (choice.equals("1")) {
                LoginManager(name, password);
            } else if (choice.equals("2")) {
                LoginCustomer(name, password);
            }
        }       
        OutFile();
    }
}