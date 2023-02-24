
package main;

public class User {
    
    private final Ticket ticket;
    private final int codeUser; static int codeOffice = 0;
    
    public User(Ticket ticket) {
        
        this.ticket = ticket;
        this.codeUser = codeOffice; codeOffice++;
    }
    
    // GETTER
    public Ticket getTicket() {return ticket;}

    public int getCodeUser() {return codeUser;}  
}
