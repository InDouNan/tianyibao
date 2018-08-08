package mqtt;


import demo.model.GPSLocation_R;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import demo.SpringUtil;



@SpringBootApplication
public class TestRedis {

    public static void main(String[] args) throws Exception {


        ApplicationContext context = SpringApplication.run(TestRedis.class, args);


        MqttPushClient.getInstance().subscribe("good");

       String kdTopic = "good";
        GPSLocation_R T=new GPSLocation_R();
       T.setMsg("das");
        T.setCode(444);
        PushPayload pushMessage =new PushPayload(T.getMap());
        System.out.println("\""+pushMessage+"\"");
        MqttPushClient.getInstance().publish( kdTopic, pushMessage);
        MqttPushClient.getInstance().subscribe("good");

    }

}

