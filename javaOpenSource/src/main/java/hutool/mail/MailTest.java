package hutool.mail;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

import java.util.ArrayList;

public class MailTest {
    public static void main(String[] args) {
//        MailUtil.send("liuyuanjiang109@126.com","JavaNorth Mail Test","This Mail from java North",false);

//        ArrayList<String> mailList = CollUtil.newArrayList("liuyuanjiang109@outlook.com","liuyuanjiang109@126.com");
//        MailUtil.send(mailList,"JavaNorth Mail Test","JavaNorth Html Mail Test",false, FileUtil.file("testOpenLeagueoflegends1.pdf"));

        MailAccount account = new MailAccount();
        account.setHost("smtp.yeah.net");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("javaNorth@yeah.net");
        account.setUser("javaNorth");
        account.setPass("DJQVCVALOVZMRGPF");

        ArrayList<String> mailList = CollUtil.newArrayList(
                "liuyuanjiang109@outlook.com",
                "liuyuanjiang109@126.com");
        MailUtil.send( account, mailList,"JavaNorth Mail Test",
                "<h1>JavaNorth Html Mail Test</h1>",true,
                FileUtil.file("testOpenLeagueoflegends1.pdf"),
                FileUtil.file("gifCaptcha.gif"));

    }
}
