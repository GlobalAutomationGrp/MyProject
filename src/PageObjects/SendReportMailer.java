package PageObjects;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendReportMailer
{
	public static void main(String args[]) 
    {
         
        //Properties props = System.getProperties();
        
        Properties props = new Properties();

         /*  props.put("mail.smtp.host", "mail.lexmark.com");
           props.put("mail.smtp.auth", "false");
           props.put("mail.smtp.debug", "true");*/

           /** SET MAIL PROPERTIES INTO SESSION */
          // Session session = Session.getDefaultInstance(props);
           // System.out.println("Start Mail sending");
           //Message message = new MimeMessage(session);

           /** SET SENDER NAME */
          // message.setFrom(new InternetAddress(mailFrom
         
        String host = "squeeze.dhcp.indiadev.lexmark.com";
         
        props.put("mail.smtp.starttls.enable", "true");
         
        props.put("mail.smtp.host", host);
         
        props.put("mail.smtp.user", "rob@lsptest.com");
         
        props.put("mail.smtp.password", "nettest");
         
        props.put("mail.smtp.port", "587");
        
        props.put("mail.smtp.ssl.trust", host);
         
        props.put("mail.smtp.auth", "true");
         
        Session session = Session.getDefaultInstance(props);
         
        MimeMessage message = new MimeMessage(session);
         
        try {
         
            //Set from address
         
        message.setFrom(new InternetAddress("rob@lsptest.com"));
         
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("dthakker@lexmark.com"));
         
        String subject="Test report ZIP file";
         
        message.setSubject(subject);
         
        message.setText("");
         
        BodyPart objMessageBodyPart = new MimeBodyPart();
         
        objMessageBodyPart.setText("Please Find The Attached Report File!");
         
        Multipart multipart = new MimeMultipart();
         
        multipart.addBodyPart(objMessageBodyPart);
         
        objMessageBodyPart = new MimeBodyPart();
         
        //Set path to the pdf report file
         
        String filename = System.getProperty("user.dir")+"/XSLT_Reports/output.zip";
         
        //Create data source to attach the file in mail
         
        DataSource source = new FileDataSource(filename);
         
        objMessageBodyPart.setDataHandler(new DataHandler(source));
         
        objMessageBodyPart.setFileName(filename);
         
        multipart.addBodyPart(objMessageBodyPart);
         
        message.setContent(multipart);
         
        Transport transport = session.getTransport("smtp");
         
        transport.connect(host, "rob@lsptest.com", "nettest");
         
        transport.sendMessage(message, message.getAllRecipients());
         
        transport.close();
         
        }
         
        catch (AddressException ae) {
         
        ae.printStackTrace();
         
        }
         
        catch (MessagingException me) {
         
        me.printStackTrace();
         
        }
         
        }
         
        }


