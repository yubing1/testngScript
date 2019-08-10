package com.testNGPro.utils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SendMail {

    private static String senderAddress = "396220003@qq.com";
    private static String recipientAddress = "sdgfvxvb@163.com";

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.port", 465);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.debug", "true");
        Session session = Session.getInstance(properties);
        session.setDebug(true);
//        Message message = new MimeMessage(session);
//        message.setFrom(new InternetAddress(senderAddress));
//        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(recipientAddress)});
//        message.setSubject("测试报告");
//        message.setText("这就是个测试报告的发送测试/just a test-report");
        Message message = getTestReport(session);
        Transport transport = session.getTransport();
        transport.connect("*********@qq.com", "********");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public static MimeMessage getTestReport(Session session) throws Exception {

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderAddress));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientAddress));
        message.setSubject("测试完成自动发送邮件（内附报告）");
        message.setText("具体执行情况请看附件！");
        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:/html.zip"));
        ZipUtils zipUtils = new ZipUtils();
        zipUtils.toZip("test-output\\html", fileOutputStream, true);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        DataHandler dataHandler = new DataHandler(new FileDataSource("d:/html.zip"));
        mimeBodyPart.setDataHandler(dataHandler);
        mimeBodyPart.setFileName(MimeUtility.encodeText(dataHandler.getName()));
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(mimeBodyPart);
        message.setContent(mimeMultipart);
        return message;
    }




}
