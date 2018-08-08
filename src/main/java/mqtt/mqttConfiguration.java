package mqtt;


import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "spring.mqtt")
@lombok.Setter
@lombok.Getter

public class mqttConfiguration {



    public String host;

    public String clientid;

    public String topic;

    public String username;

    public String password;

    public int timeout;

    public int keepalive;

    @Bean
     String insert(){
        MqttPushClient.clientid=clientid;
        MqttPushClient.host=host;
        MqttPushClient.password=password;
        MqttPushClient.timeout=timeout;
        MqttPushClient.topic=topic;
        MqttPushClient.username=username;
        MqttPushClient.keepalive=keepalive;
        System.out.println("insert success");
        return username;
    }

}