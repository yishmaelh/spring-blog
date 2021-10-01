//package services;
//
//import com.codeup.springblog.models.Post;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service("emailService")
//public class EmailService {
//
//    @Autowired
//    public JavaMailSender emailSender;
//
//    @Value("${spring.mail.from}")
//    private String from;
//
//    public void prepareAndSend(Post post, String subject, String body){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(post.getOwner().getEmail());
//        message.setSubject(subject);
//        message.setText(body);
//
//        try {
//            this.emailSender.send(message);
//            System.out.println("Email successfully sent");
//        } catch (MailException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//    }
//
//}
