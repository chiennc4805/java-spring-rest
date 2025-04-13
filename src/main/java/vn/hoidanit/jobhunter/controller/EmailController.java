package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import vn.hoidanit.jobhunter.service.EmailService;
import vn.hoidanit.jobhunter.service.SubscriberService;
import vn.hoidanit.jobhunter.util.annotation.ApiMessage;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class EmailController {

    private final EmailService emailService;
    private final SubscriberService subscriberService;

    public EmailController(EmailService emailService, SubscriberService subscriberService) {
        this.emailService = emailService;
        this.subscriberService = subscriberService;
    }

    @GetMapping("/email")
    @ApiMessage("Send simple email")
    @Scheduled(cron = "*/20 * * * * *")
    // @Transactional //xử lý lỗi no session
    public String sendSimpleEmail() {
        this.emailService.sendSimpleEmail();
        // this.emailService.sendEmailSync("chiennguyen5981x7game2@gmail.com", "test
        // send email",
        // "<h1><b> Hello </b></h1>", false, true);
        // this.subscriberService.sendSubscribersEmailJobs();
        return "ok";
    }

}
