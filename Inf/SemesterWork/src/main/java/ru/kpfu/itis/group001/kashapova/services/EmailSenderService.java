package ru.kpfu.itis.group001.kashapova.services;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @author Kashapova Dilyara
 * 11-001
 * Sem 1
 */

public class EmailSenderService {

    public static EmailSenderService here = new EmailSenderService();;

    String from = "itis_di@mail.ru";
    Properties prop = System.getProperties();

    private EmailSenderService() {
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mail.ru");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mail.ru");
    }

    public void sendEmail(String theme, String text, String sendMailTo) {
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("itis_di@mail.ru", "84eRu9UAqvgxYviyNpja");
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(sendMailTo));
            message.setSubject(theme);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(text, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println("(ESS#sendEmail) " + e.getMessage() + " " + e.getCause());
        }
    }
}
