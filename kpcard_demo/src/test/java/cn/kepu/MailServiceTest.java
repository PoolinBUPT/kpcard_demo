//package cn.kepu;
//
//import cn.kepu.card.utils.Mail.MailService;
//import cn.kepu.card.utils.SchedulerTask;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MailServiceTest {
//
//    @Autowired
//    private MailService MailService;
//
//    private TemplateEngine templateEngine;
//
//    @Test
//    public void testSimpleMail() throws Exception{
//        MailService.sendSimpleMail("s47698572@163.com" ,"739667463@qq.com", "test simple mail", "hello this is simple mail");
//    }
//
//    @Test
//    public void testHtmlMail() throws Exception {
//        String content="<html>\n" +
//                "<body>\n" +
//                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
//                "</body>\n" +
//                "</html>";
//        MailService.sendHtmlMail("s47698572@163.com","739667463@qq.com","test html mail",content);
//    }
//
//    @Test
//    public void sendAttachmentsMail() {
//        String filePath="f:\\kepucard.xmind";
//        MailService.sendAttachmentsMail("s47698572@163.com","739667463@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
//    }
//
//    @Test
//    public void sendInlineResourceMail() {
//        String rscId = "neo006";
//        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
//        String imgPath = "C:\\Users\\kepu\\Pictures\\1.jpg";
//
//        MailService.sendInlineResourceMail("s47698572@163.com","739667463@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
//    }
//
//    @Test
//    public void sendTemplateMail(){
//        Context context = new Context();
////        context.setVariable("test","1");
//        String mailContent = templateEngine.process("mailTemplate", context);
//
//        MailService.sendHtmlMail("s47698572@163.com","739667463@qq.com", "这是模板邮件", mailContent);
//    }
//
//    @Test
//    public void scheduleTaskTest() {
//        SchedulerTask schedulerTask = new SchedulerTask();
//        schedulerTask.process();
//    }
//}
