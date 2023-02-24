
package main;

import java.util.LinkedList;

public class Counter {
    
    private LinkedList<User> tail;
    
    public Counter() {
        
        tail = new LinkedList<>();
    }
    
    // GETTER
    public LinkedList<User> getTail() {return tail;}
    
    public void showCounter() {
        
        for(int i = 0; i < tail.size(); i++) {
            
            System.out.println("" +tail.get(i).getCodeUser()+ "|" +tail.get(i).getTicket().getAction()+ "|" +tail.get(i).getTicket().getCode());
            
        }
    }
}
