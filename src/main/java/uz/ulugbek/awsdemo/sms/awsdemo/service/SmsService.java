package uz.ulugbek.awsdemo.sms.awsdemo.service;

public interface SmsService {

    void sendSingleSms(String phoneNumber, String message);

}
