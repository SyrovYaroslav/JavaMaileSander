package MailSenderSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendingMails {

    @Autowired
    JavaMailSender javaMailSender;

    public String sendMailExecute(String to, String from, String head, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(text);
        simpleMailMessage.setSubject(head);
        try {
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            System.out.println("no success");
            e.printStackTrace();

        }
        System.out.println("success");
        return "Email Sent successfully....";
    }
}
