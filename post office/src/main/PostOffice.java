
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PostOffice extends JPanel implements Runnable {
    
    // GRAPHIC
    private Thread thread;
    private final JLabel label[];
    
    // CODE
    private final Counter payment;
    private final Counter shipment;
    
    public PostOffice() {
        
        // SETTINGS
        setBackground(Color.BLACK);
        setBounds(100,300,400,200);
        setDoubleBuffered(true);
        
        // GRAPHIC
        label = new JLabel[20];
        setLayout(null);
        
        // CODE
        this.payment = new Counter();
        this.shipment = new Counter();
    }
    
    public void startThread() {this.thread = new Thread(this); thread.start();}
    
    public void addUserToCounter(User user) {
        
        switch(user.getTicket().getAction()) {
            
            case "PAYMENT" -> payment.getTail().add(user);
            
            case "SHIPMENT" -> shipment.getTail().add(user);
        }
    }
    
    public void removeUserFromCounter() {
        
        int num = new Random().nextInt(2)+1;
        
        if(!payment.getTail().isEmpty() || !shipment.getTail().isEmpty()) {
            
            // PAYMENT
            if(num == 1 && !payment.getTail().isEmpty()) {payment.getTail().remove();}
            
            // SHIMPENT
            if(num == 2 && !shipment.getTail().isEmpty()) {shipment.getTail().remove();}
        }
    }
    
    public void removeTicketFromTail(String string) {
        
        switch(string.charAt(0)) {
            case 'P' -> {
                for(int i = 0; i < payment.getTail().size(); i++) {
                    if(payment.getTail().get(i).getTicket().getCode().equals(string)) {
                        payment.getTail().remove(i);
                    }
                }
            }
            case 'S' -> {
                for(int i = 0; i < shipment.getTail().size(); i++) {
                    if(shipment.getTail().get(i).getTicket().getCode().equals(string)) {
                        shipment.getTail().remove(i);
                    }
                }
            }
            default -> { 
                JOptionPane.showMessageDialog(null, "Inserire un codice valido");
            }
        }
        
    }
    
    public void showPaymentTicket() {
        
        System.out.println("-----------");
        
        int x = 10; int y = 10;
        
        for(int i = 0; i < 10; i++) {
            label[i] = new JLabel();
            label[i].setOpaque(true);
            label[i].setBackground(Color.WHITE);
            label[i].setBounds(x,y,185,25);
            y+=28;
            this.add(label[i]);
        } 
    }
        
    public void showShipmentTicket() {
        
        System.out.println("-----------");
        
        int x = 205; int y = 10;
        
        for(int i = 10; i < 20; i++) {
            label[i] = new JLabel();
            label[i].setOpaque(true);
            label[i].setBackground(Color.WHITE);
            label[i].setBounds(x,y,185,25);
            y+=28;
            this.add(label[i]);
        } 
    }
    
    public void showPostOffice() {
        
        for(int i = 0; i < payment.getTail().size(); i++) {
            
            label[i].setText(" " +payment.getTail().get(i).getCodeUser()+ " | " +payment.getTail().get(i).getTicket().getAction()+ " | " +payment.getTail().get(i).getTicket().getCode());
        }
        
        for(int i = 0; i < shipment.getTail().size(); i++) {
            int k = i + 10;
            label[k].setText(" " +shipment.getTail().get(i).getCodeUser()+ " | " +shipment.getTail().get(i).getTicket().getAction()+ " | " +shipment.getTail().get(i).getTicket().getCode());
        }
        
        System.out.println("-----------1");
        payment.showCounter();
        System.out.println("-----------2");
        shipment.showCounter();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000; // how much time pass before drawing in one second (0.016)
	long currentTime; long lastTime = System.nanoTime();
	double delta = 0; // variable that determinate when it can update and draw
        
        int x =  0;
		
	while(thread != null) {
			
            currentTime = System.nanoTime();
			
            delta += (currentTime - lastTime) / drawInterval; // every cycle of while add to delta 
			
            lastTime = currentTime;
			
            if(delta >= 1) {
                
		update(); // update information relative to position of elements
				
		repaint(); // draw the elements in relative positions
				
		delta = 0; // reset delta for the next cycle
                
                x++;
            }
            
            if(x == 3) {
                
                this.removeUserFromCounter(); this.showPostOffice();
                
                x = 0;
            }

	}
    }
    
    public void update() {
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        showPaymentTicket();
        showShipmentTicket();
        showPostOffice();
        
        g.dispose();
    }
}
