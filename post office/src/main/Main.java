
package main;

public class Main {
    
    public static void main(String[] args) {
        
        PostOffice office = new PostOffice();
        
        office.addUserToCounter(new User(new Ticket("PAYMENT")));
        
        office.startThread();
    }  
}
