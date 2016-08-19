/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.awt.HeadlessException;
import java.util.Properties;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.swing.JOptionPane;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author cmeehan
 */
public class SendEmail {
    private final String FROM_EMAIL = "cmeehan";
    private final String PASSWORD = "Wadiver15!";
    private String to, cc, bcc, subject, messageText;
    private Stage stage;
    
    protected void SendEmail(String to, String cc, String bcc, String subject, String messageText, Stage stage){
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.messageText = messageText;
        this.stage = stage;
        sendEmail();
    }
    
    private InternetAddress[] to() throws AddressException {
        String[] recipients = to.split(";");
        InternetAddress[] toArr = new InternetAddress[recipients.length];
        int counter = 0;
        for(String recipient : recipients){
            toArr[counter] = new InternetAddress(recipient.trim());
            counter++;
        }
        return toArr;
    }
    private InternetAddress[] cc() throws AddressException{
        String[] recipients = cc.split(";");
        InternetAddress[] ccArr =  new InternetAddress[recipients.length];
        int counter = 0;
        for(String recipient : recipients){
            ccArr[counter] = new InternetAddress(recipient.trim());
            counter++;
        }
        return ccArr;
    }
    
    private InternetAddress[] bcc() throws AddressException{
        String[] recipients = bcc.split(";");
        InternetAddress[] bccArr =  new InternetAddress[recipients.length];
        int counter = 0;
        for(String recipient : recipients){
            bccArr[counter] = new InternetAddress(recipient.trim());
            counter++;
        }
        return bccArr;
    }
    
    private void sendEmail(){
         String from = "Office.Manager@PropertyManager.com";
        String host = "gator4070.hostgator.com";
        
        // Set the properties for SSL SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Create Authenticator object to pass in Sess.getInstance argument
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        };

        // The SMTP session
        Session session = Session.getInstance(props, auth);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            // Check if the text fields have input and use the right internetaddress
            if(!to.equals("")){
                message.setRecipients(Message.RecipientType.TO, to());
            }
            if(!cc.equals("")){
                message.setRecipients(Message.RecipientType.CC, cc());                
            }
            if(!bcc.equals("")){
                message.setRecipients(Message.RecipientType.BCC, bcc());
            }
            message.setSubject(subject);
            message.setContent(messageText, "text/html");
            Transport.send(message);
            JOptionPane.showMessageDialog(null,"Message Sent Successfully!","Message Sent", JOptionPane.INFORMATION_MESSAGE);
            stage.close();
            
        } catch (MessagingException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error! Please check your network connection and ensure all email addresses are valid.\nNote: Multipled addresses must be separated with a semi-colon(;)", "Error! Message Not Sent", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
}
