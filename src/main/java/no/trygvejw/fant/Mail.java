package no.trygvejw.fant;


import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Stateless
public class Mail {
    private static final String senderMail = "noreply@fant.no";//System.getenv("MAIL_USERNAME");
    //private static final String senderPass = System.getenv("MAIL_PASSWORD");

    @Asynchronous
    public  void sendEmail(String to, String subject, String contents){
        String host="mail";//"smtp.gmail.com";
        final String user=senderMail;
        //final String password=senderPass;


        Properties properties = new Properties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "25");
        //properties.put("mail.smtp.ssl.enable", "true");
        //properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties/*,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                }
                */);



        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
            message.setText(contents);

            Transport.send(message);

            //System.out.println("message sent successfully...");

        } catch (MessagingException e) {e.printStackTrace();}
    }



}
