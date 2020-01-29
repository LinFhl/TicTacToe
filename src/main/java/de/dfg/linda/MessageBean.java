package de.dfg.linda;

import com.vaadin.cdi.annotation.VaadinSessionScoped;
import com.vaadin.flow.component.button.Button;

/**
 * Data provider bean scoped for each user session.
 */
@VaadinSessionScoped
public class MessageBean {

	 Button button1;
    /**
     * Gets message data.
     *
     * @return a message
     */
    public String getMessage() {
       
		return new StringBuilder(button1.getText() + "" + "hat gewonnen").toString();
    }

    
}
