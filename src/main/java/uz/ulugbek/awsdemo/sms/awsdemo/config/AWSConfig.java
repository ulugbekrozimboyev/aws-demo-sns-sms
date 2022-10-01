package uz.ulugbek.awsdemo.sms.awsdemo.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {

    @Value("${aws.access-key}")
    private String accessKey;
    @Value("${aws.secret-key}")
    private String secretKey;
    @Value("${aws.region-name}")
    private String regionName;

    public AWSCredentials credentials() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }

    @Bean
    public AmazonSNS amazonSNS() {
        AmazonSNS snsClient = AmazonSNSClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .withRegion(regionName)
                .build();
        return snsClient;
    }
}
