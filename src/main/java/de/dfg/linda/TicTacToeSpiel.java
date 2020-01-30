package de.dfg.linda;


import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import javax.annotation.PostConstruct;

/**
 * The main view contains a simple label element and a template element.
 */

@Route("")
@PWA(name = "Project Base for Vaadin Flow with CDI", shortName = "Project Base")
public class TicTacToeSpiel  extends VerticalLayout{

	 
	private static final long serialVersionUID = 1L;

    private String currentPlayer = "X";
    
    HorizontalLayout reihe1;
	HorizontalLayout reihe2;
	HorizontalLayout reihe3;
	HorizontalLayout reihe4;
	
	Label label1 = new Label("Tic Tac Toe");
	Label label = new Label("Viel Spaß beim spielen");
	Label label2 = new Label("Der aktuelle Spieler ist: ");
	Label label3 = new Label("");
	 
	private Button obenLinks, obenMitte, obenRechts, mitteLinks, mitteMitte, mitteRechts, untenLinks, untenMitte, untenRechts;
	private Button clear;
	
	
	@PostConstruct
    public void init() {
    	
    	reihe1= new HorizontalLayout();
    	reihe2= new HorizontalLayout();
    	reihe3= new HorizontalLayout();
    	reihe4= new HorizontalLayout();
    	
    	this.add(label1);  
    	this.add(label);  					//.setFontSize(50) 
    	this.add(reihe1); 
		this.add(reihe2);
		this.add(reihe3);
		this.add(label2);
		this.add(label3);
		this.add(reihe4);
		
		//label1.getStyle().set(font-weight, bold);
		
	
		
		clear = new Button("Neues Spiel");
        clear.addClickListener(this::clearButtons);
        reihe4.add(clear);
        
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
	
	
	
	private void onClick(ClickEvent<Button> event) {
    	
		
    	event.getSource().setText(currentPlayer);
    	
		
		if (currentPlayer.equals("X")) {
    		
    		currentPlayer = "O";
    	
		}
    	else {
    		currentPlayer = "X";
    		
    	}
		
		label2.setText("Der aktuelle Spieler ist: " + currentPlayer);
		compareButtons(obenLinks,obenMitte,obenRechts);
		compareButtons(mitteLinks,mitteMitte,mitteRechts);
		compareButtons(untenLinks,untenMitte,untenRechts);
		compareButtons(obenLinks,mitteLinks,untenLinks);
		compareButtons(obenMitte,mitteMitte,untenMitte);
		compareButtons(obenRechts,mitteRechts,untenRechts);
		compareButtons(obenLinks,mitteMitte,untenRechts);
		compareButtons(obenRechts,mitteMitte,untenLinks);
		
	}
	
	public void compareButtons(Button button1,Button button2, Button button3) {
		
			if(!button1.getText().isEmpty() && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())) {
			
				label2.setText(button1.getText() +" " + "hat gewonnen");
				
			}
		
	}
	
	public void clearButtons(ClickEvent<Button> event) {
		
	
		obenLinks.setText("");
		obenMitte.setText("");
		obenRechts.setText("");
		mitteLinks.setText("");
		mitteMitte.setText("");
		mitteRechts.setText("");
		untenLinks.setText("");
		untenMitte.setText("");
		untenRechts.setText("");
		
		label2.setText("Der aktuelle Spieler ist: ");
	
		
	}
	
	 

}
