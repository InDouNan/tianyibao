package mqtt;

import demo.model.GPSLocation_R;

public class Thread extends java.lang.Thread{

    public Thread(MqttPushClient mqtt){
        try {

            while (true) {
                mqtt.subscribe("good");
                sleep(200);
//                String kdTopic = "good";
//                GPSLocation_R T = new GPSLocation_R();
//                T.setMsg("das");
//                T.setCode(444);
//                PushPayload pushMessage = new PushPayload(T.getMap());
//                System.out.println(MqttPushClient.clientid);
//                mqtt.publish(kdTopic, pushMessage);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
        this.sleep(10000);

    }catch (Exception e){
        e.printStackTrace();
    }

    }
}
