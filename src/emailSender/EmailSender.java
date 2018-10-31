/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailSender;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author USER
 */
public class EmailSender {

    public void enviar(String mensagem, String destinatario) {

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tinyduckcorp@gmail.com", "tinyduck123");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tinyduckcorp@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(destinatario);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Alteração de Senha");//Assunto
            message.setText(mensagem);
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

        } catch (MessagingException e) { //caso a porta 465 não funcione
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");

            Session session2 = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("tinyduckcorp@gmail.com", "tinyduck123");
                }
            });

            /**
             * Ativa Debug para sessão
             */
            session2.setDebug(true);
            try {
                Message message = new MimeMessage(session2);
                message.setFrom(new InternetAddress("tinyduckcorp@gmail.com")); //Remetente

                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse(destinatario);

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Alteração Senha");//Assunto
                message.setText( mensagem);
                /**
                 * Método para enviar a mensagem criada
                 */
                Transport.send(message);

            } catch (MessagingException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
    
}
    


