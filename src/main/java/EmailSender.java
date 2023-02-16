import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender {
    public static void main(String args[]){

        String to = "d.a.boguslavsjkyy@student.khai.edu";
        String from = "y.s.syrovatka@student.khai.edu";
        String host = "smtp.gmail.com";

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", true);

        Session session = Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, "oeksshfavsppuims");
                    }
                });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Be careful");
            // actual mail body
            message.setText("It" + "is" + "spam" + "!");

            // Send message
            Transport.send(message);
            System.out.println("Email Sent successfully....");
        } catch (MessagingException mex){ mex.printStackTrace(); }

    }
}
