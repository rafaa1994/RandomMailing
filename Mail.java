package randomek;


/**
 *
 * @author Rafał Stępień
 */

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.ArrayList;

public class Mail {

    private static String USER_NAME = "-----------------";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "**************"; // GMail password
    private static ArrayList<Person> persons = new ArrayList(); // table of recipients
    
   
        
        
    public static void main(String[] args) {
        persons.add(new Person("NAME","LOGIN@gmail.com",0));
        
       
        String from = USER_NAME;
        String pass = PASSWORD;
        String to = new String();
        String subject = "SUBJECT";
        String body = new String();
        ArrayList<Integer> numbers = new ArrayList();
        int i = 0;
		
		// function which help to random send one mail to sameone else from list if is bigger than 1
       while (i < persons.size()){
        
            Random rand = new Random();
            int current_idx = rand.nextInt(persons.size());
            if(current_idx != persons.get(i).getNumber() && !numbers.contains(current_idx)){
            body = "BODY "+ persons.get(i).getName()+" BODY " + persons.get(current_idx).getName();
            to = persons.get(i).getEmail(); // list of recipient email addresses
            numbers.add(current_idx);
            System.out.println(to);
            sendFromGMail(from, pass, to, subject, body);
            i++;
           }
            
        
        }
        
       // sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String to, String subject, String body) {
        
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress toAddress = new InternetAddress();

            // To get the array of addresses
           // for( int i = 0; i < to.length; i++ ) {
                toAddress = new InternetAddress(to);
           // }

           // for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress);
          //  }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}