//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class JavaEmail {
//
//	Properties emailProperties;
//	Session mailSession;
//	MimeMessage emailMessage;
//        
//        public void run() throws AddressException,MessagingException{
//        JavaEmail javaEmail = new JavaEmail();
//
//	javaEmail.setMailServerProperties();
//	javaEmail.createEmailMessage();
//	javaEmail.sendEmail();
//        }
//
//	public void setMailServerProperties() {
//
//		String emailPort = "587";//gmail's smtp port
//
//		emailProperties = System.getProperties();
//		emailProperties.put("mail.smtp.port", emailPort);
//		emailProperties.put("mail.smtp.auth", "true");
//		emailProperties.put("mail.smtp.starttls.enable", "true");
//
//	}
//
//	public void createEmailMessage() throws AddressException,MessagingException {
//            int count = 0;
//            
//                try{
//                    String[] toEmails = { StaticFunction.getUserInput("Please enter your email") };
//                    
//                    do{
//                        boolean checkingdone = StaticFunction.checkEmailvalidity(toEmails[0]);
//                
//                        if (!checkingdone){
//                            System.out.println("Wrong email format inserted!");
//                            toEmails[0] = StaticFunction.getUserInput("Please enter your email");
//                        } else {
//                            count = 1;
//                        }
//                        
//                    }while(count == 0);
//                
//                
//                
//		String emailSubject = "Reset Password";
//		String emailBody = "This is an email to reset your password";
//
//		mailSession = Session.getDefaultInstance(emailProperties, null);
//		emailMessage = new MimeMessage(mailSession);
//
//		for (int i = 0; i < toEmails.length; i++) {
//			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
//		}
//
//		emailMessage.setSubject(emailSubject);
//		emailMessage.setContent(emailBody, "text/html");//for a html email
//		//emailMessage.setText(emailBody);// for a text email
//                } catch (NumberFormatException e) {
//                    System.out.println(e);
//                }
//	}
//
//	public void sendEmail() throws AddressException, MessagingException {
//
//		String emailHost = "smtp.gmail.com";
//		String fromUser = "CourierSystemOODJ2020";//just the id alone without @gmail.com
//		String fromUserEmailPassword = "Testing_oodj2020";
//
//		Transport transport = mailSession.getTransport("smtp");
//
//		transport.connect(emailHost, fromUser, fromUserEmailPassword);
//		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
//		transport.close();
//		System.out.println("Email sent successfully.");
//	}
//
//}