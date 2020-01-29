package de.dfg.linda;


import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * The main view contains a simple label element and a template element.
 */
@Route("")
@PWA(name = "Project Base for Vaadin Flow with CDI", shortName = "Project Base")
public class TicTacToeSpiel  extends VerticalLayout{

	private static final long serialVersionUID = 1L;

	@Inject 
   private MessageBean messageBean;
    
    private String currentPlayer = "X";
    
   // String ergebnis = "Unentschieden";
    		
    HorizontalLayout reihe1;
	HorizontalLayout reihe2;
	HorizontalLayout reihe3;
	
	
	Button obenLinks, obenMitte, obenRechts, mitteLinks, mitteMitte, mitteRechts, untenLinks, untenMitte, untenRechts;
	
	
	private void onClick(ClickEvent<Button> event) {
    	
    	event.getSource().setText(currentPlayer);
    	
		
		if (currentPlayer.equals("X")) {
    		
    		currentPlayer = "O";
    	
		}
    	else {
    		currentPlayer = "X";
    		
    	}
		
		compareButtons(obenLinks,obenMitte,obenRechts);
		compareButtons(mitteLinks,mitteMitte,mitteRechts);
		compareButtons(untenLinks,untenMitte,untenRechts);
		compareButtons(obenLinks,mitteLinks,untenLinks);
		compareButtons(obenMitte,mitteMitte,untenMitte);
		compareButtons(obenRechts,mitteRechts,untenRechts);
		compareButtons(obenLinks,mitteMitte,untenRechts);
		compareButtons(obenRechts,mitteMitte,untenLinks);
		
	}
	
	public static void compareButtons(Button button1,Button button2, Button button3) {
		
			
			
			if(!button1.getText().isEmpty() && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())) {
			
				System.out.print(button1.getText() +" " + "hat gewonnen");
			
				
		 }
		
			
		}
	 
	@PostConstruct
    public void init() {
    	
    	reihe1= new HorizontalLayout();
    	reihe2= new HorizontalLayout();
    	reihe3= new HorizontalLayout();
    	
    	this.add(reihe1);
		this.add(reihe2);
		this.add(reihe3);
		
		
		obenLinks = new Button("");
        obenLinks.addClickListener(this::onClick);
        reihe1.add(obenLinks);
     
        obenMitte = new Button("");
        obenMitte.addClickListener(this::onClick);
        reihe1.add(obenMitte);
       
        obenRechts = new Button("");
        obenRechts.addClickListener(this::onClick);
        reihe1.add(obenRechts);
     
        mitteLinks = new Button("");
        mitteLinks.addClickListener(this::onClick);
        reihe2.add(mitteLinks);
        
        mitteMitte = new Button("");
        mitteMitte.addClickListener(this::onClick);
        reihe2.add(mitteMitte);
        
        mitteRechts = new Button("");
        mitteRechts.addClickListener(this::onClick);
        reihe2.add(mitteRechts);
        
        untenLinks = new Button("");
        untenLinks.addClickListener(this::onClick);
        reihe3.add(untenLinks);
        
        untenMitte = new Button("");
        untenMitte.addClickListener(this::onClick);
        reihe3.add(untenMitte);
        
        untenRechts = new Button("");
        untenRechts.addClickListener(this::onClick);
        reihe3.add(untenRechts); 
        
    } 

}
