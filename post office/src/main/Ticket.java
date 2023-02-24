
package main;

import java.util.Random;

public class Ticket {
    
    private final String action; // payment or shipment
    private String code; static int codeOffice = new Random().nextInt(50);
    
    public Ticket(String action) {
        
        this.action = action;
        codeOffice++; setNumberTicket();
    }
    
    // NUMBER OF THE TICKET
    private void setNumberTicket() {
        
        String code;
        
        if("PAYMENT".equals(action)) {code = "P";}
        else code = "S";
        
        if(codeOffice > 9) {code += "0" +codeOffice;}
        else {code += "00" +codeOffice;}
        
        this.code = code;
    }
    
    // GETTER
    public String getAction() {return action;}

    public String getCode() {return code;}
}
