package MailSenderSpring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    SendingMails sendingMails;

    @PostMapping("/send")
    public String sendEmail(@RequestParam String to,
                            @RequestParam String from,
                            @RequestParam String head,
                          @RequestParam String text) {
        return sendingMails.sendMailExecute(to, from, head, text);
    }
}
