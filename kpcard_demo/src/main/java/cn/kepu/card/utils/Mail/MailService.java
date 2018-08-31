package cn.kepu.card.utils.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

public interface MailService {

    public void sendSimpleMail(String from, String to, String subject, String content);

    public void sendHtmlMail(String from, String to, String subject, String content);

    public void sendAttachmentsMail(String from, String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String from, String to, String subject, String content, String sourcePath, String sourceId);

}
