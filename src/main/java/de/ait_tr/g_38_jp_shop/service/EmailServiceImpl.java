package de.ait_tr.g_38_jp_shop.service;

import de.ait_tr.g_38_jp_shop.domain.entity.User;
import de.ait_tr.g_38_jp_shop.service.interfaces.ConfirmatationService;
import de.ait_tr.g_38_jp_shop.service.interfaces.EmailService;
import freemarker.template.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender sender;
    private Configuration mailConfig;
    private ConfirmatationService confirmatationService;

    public EmailServiceImpl(JavaMailSender sender, Configuration mailConfig, ConfirmatationService confirmatationService) {
        this.sender = sender;
        this.mailConfig = mailConfig;
        this.confirmatationService = confirmatationService;

        //mailConfig.setDefaultEncoding("UTF-8");
    }

    @Override
    public void sendConfirmationEmail(User user) {

    }
}
