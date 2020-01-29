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
    
    String ergebnis = "Unentschieden";
    		
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
		
		if (!obenLinks.getText().isEmpty() && obenLinks.getText().equals(obenMitte.getText()) && obenLinks.getText().equals(obenRechts.getText())){
			System.out.print(obenLinks.getText() +" " + "hat gewonnen");
		}
    	
		if (!mitteLinks.getText().isEmpty() && mitteLinks.getText().equals(mitteMitte.getText()) && mitteLinks.getText().equals(mitteRechts.getText())){
			System.out.print(mitteLinks.getText() +" " + "hat gewonnen");
		}
    	
		if (!untenLinks.getText().isEmpty() && untenLinks.getText().equals(untenMitte.getText()) && untenLinks.getText().equals(untenRechts.getText())){
			System.out.print(untenLinks.getText() +" " + "hat gewonnen");
		}
		
		if (!obenLinks.getText().isEmpty() && obenLinks.getText().equals(mitteLinks.getText()) && obenLinks.getText().equals(untenLinks.getText())){
			System.out.print(obenLinks.getText() +" " + "hat gewonnen");
		}
    	
		if (!obenMitte.getText().isEmpty() && obenMitte.getText().equals(mitteMitte.getText()) && obenMitte.getText().equals(untenMitte.getText())){
			System.out.print(obenMitte.getText() +" " + "hat gewonnen");
		}
    	
		if (!obenLinks.getText().isEmpty() && obenLinks.getText().equals(mitteRechts.getText()) && obenLinks.getText().equals(untenRechts.getText())){
			System.out.print(untenLinks.getText() +" " + "hat gewonnen");
		}
		
		if (!obenLinks.getText().isEmpty()/*.equals("")*/ && obenLinks.getText().equals(mitteMitte.getText()) && obenLinks.getText().equals(untenRechts.getText())){
			System.out.print(obenLinks.getText() +" " + "hat gewonnen");
		}
		
		if (!obenRechts.getText().isEmpty() && obenRechts.getText().equals(mitteMitte.getText()) && obenRechts.getText().equals(untenLinks.getText())){
			System.out.print(obenRechts.getText() +" " + "hat gewonnen");
		}
    	
		
		
	}
	
	public static Button compareButtons(Button obenLinks,Button obenMitte, Button obenRechts, Button mitteLinks, Button mitteMitte, Button mitteRechts, Button untenLinks, Button untenMitte, Button untenRechts) {
		
		
		return compareButtons(null, null, null, null, null, null, null, null, null);
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
