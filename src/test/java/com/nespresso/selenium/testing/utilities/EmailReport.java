package com.nespresso.selenium.testing.utilities;

import javax.mail.BodyPart;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailReport {
    public static void main(String[] args) throws MessagingException {

        //String to[] = {"test02@gmail.com","test03@gmail.com"};
        String to[] = {"jaatafa@example.com"};

        send("jaatafa@gmail.com", to, "JUnit Report", "Check the PDF attachment.");

    }
    public static void send(String from, String tos[], String subject,
                            String text) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(   "jaatafa@gmail.com","BayeNiass1@");
                    }
                }
        );

//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(
//                                "jaatafa@gmail.com",
//                                "BayeNiass1@");// change accordingly
//                    }
//                });

        // compose message
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jaatafa@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mamadou.dia@nespresso.com"));
            message.setSubject("MAIL SUBJECT !");
            message.setText("MAIL BODY !");
            Transport.send(message);

//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));// change accordingly
//            for (String to : tos) {
//                message.addRecipient(Message.RecipientType.TO,
//                        new InternetAddress(to));
//            }
            /*
             * for (String cc : ccs)
             * message.addRecipient(Message.RecipientType.CC,new
             * InternetAddress(cc));
             */
            message.setSubject(subject);
            // Option 1: To send normal text message
            // message.setText(text);
            // Option 2: Send the actual HTML message, as big as you like
            // message.setContent("<h1>This is actual message</h1></br></hr>" +
            // text, "text/html");

            // Set the attachment path
            String filename = "test-output/nespresso-test-report-2023.01.18.17.09.51.html";

            BodyPart objMessageBodyPart = new MimeBodyPart();
            // Option 3: Send text along with attachment
            objMessageBodyPart.setContent(
                    "<h1>Mail from Selenium Project!</h1></br>" + text, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(objMessageBodyPart);

            objMessageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            objMessageBodyPart.setDataHandler(new DataHandler(source));
            objMessageBodyPart.setFileName(filename);
            multipart.addBodyPart(objMessageBodyPart);
            message.setContent(multipart);

            // send message
            Transport.send(message);

            System.out.println("message sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }// End of SEND method









    /*public static void main(String[] args) {

        // Recipient's email ID needs to be mentioned.
        String to = "jaatafa@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "mamadou.dia@nespresso.com";
        String password = "Azerty2022*";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.office365.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("username", from);
        properties.put("password", password);
        properties.put("mail.transport.protocol", "smtp");


        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, "Azerty2022*");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }*/


}
