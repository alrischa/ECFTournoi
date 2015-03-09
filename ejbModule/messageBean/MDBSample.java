package messageBean;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import metier.Tournoi;
import dao.DaoFacadeTournoi;

/** 
 * JMS Consommateur de message (destinataire)
 * Aucune modification n'a été apportée sur le fichier initial
 */

@MessageDriven(name = "MessageMDBSample", activationConfig = {
 @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
 @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test"),
 @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })

public class MDBSample implements MessageListener {

	@EJB
	DaoFacadeTournoi dao;
	
   public void onMessage(Message message) {

     TextMessage tm = (TextMessage) message;
       try {
    	   
         System.out.println(tm.getText() + "*******************************************************");
         
         for (int i = 0; i < 10; i++) {
      	   System.out.println(i + " - " + this + "Warning : Une inscription a été tentée alors que le systeme ne les gère pas : AutoDestruction!.");
      	   for (Tournoi t : dao.consulter()){
      		   dao.supprimerTournoi(t);
      		   
      	   };
         }
       } catch (JMSException e) {
  
        e.printStackTrace();
       }
 

   }

}
