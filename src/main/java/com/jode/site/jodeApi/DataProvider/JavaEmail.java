package com.jode.site.jodeApi.DataProvider;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Service
public class JavaEmail {

    public void enviarEmail(String valorEmail) {
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(System.getenv("EMAIL_LOGIN"),
                                System.getenv("EMAIL_PASSWORD"));
                    }
                });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(System.getenv("EMAIL_LOGIN")));
            //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse("deafsouza05@gmail.com, joaojoao.jopdsr@gmail.com");

            message.setRecipients(Message.RecipientType.TO, toUser);
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            message.setSubject("[Compras] Informações de compras - " + fmt.format(new Date()));

            Multipart multipart = new MimeMultipart("related");
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setText(valorEmail, "utf-8", "html");
            multipart.addBodyPart(htmlPart);


            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
