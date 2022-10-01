package uz.ulugbek.awsdemo.sms.awsdemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ulugbek.awsdemo.sms.awsdemo.service.SmsService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class SmsController {

    private final SmsService smsService;

    @GetMapping("/test-sms/{phone}/{msg}")
    public ResponseEntity<Boolean> sendTestSms(@PathVariable String phone, @PathVariable String msg) {
        log.debug("Send sms");
        smsService.sendSingleSms(phone, msg);
        return ResponseEntity.ok().body(true);
    }

}
