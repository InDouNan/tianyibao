package mqtt;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j

public class MqttPushClient {

    public static String host;

    public static String clientid;

    public static String topic;

    public static String username;

    public static String password;

    public static int timeout;

    public static int keepalive;


    private MqttClient client;

    private static volatile MqttPushClient mqttPushClient = null;

    public static MqttPushClient getInstance(){

        if(null == mqttPushClient){
            synchronized (MqttPushClient.class){
                if(null == mqttPushClient){
                    mqttPushClient = new MqttPushClient();
                }
            }

        }
        return mqttPushClient;

    }

    private MqttPushClient() {
        connect();
    }

    private void connect(){
        try {
            System.out.println(host);
            client = new MqttClient(host, clientid, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            options.setConnectionTimeout(timeout);
            options.setKeepAliveInterval(keepalive);

            try {
                client.setCallback(new PushCallback());
                client.connect(options);
                client.subscribe("good",0);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发布，默认qos为0，非持久化
     * @param topic
     * @param pushMessage
     */
    public void publish(String topic,PushPayload pushMessage){
        publish(0, false, topic, pushMessage);
    }

    /**
     * 发布
     * @param qos
     * @param retained
     * @param topic
     * @param pushMessage
     */
    public void publish(int qos,boolean retained,String topic,PushPayload pushMessage){
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(pushMessage.toString().getBytes());
        MqttTopic mTopic = client.getTopic(topic);
        if(null == mTopic){
            System.out.println("topic not exist");
        }
        MqttDeliveryToken token;
        try {
            token = mTopic.publish(message);
            token.waitForCompletion();
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅某个主题，qos默认为0
     * @param topic
     */
    public void subscribe(String topic){
        subscribe(topic,0);
    }

    /**
     * 订阅某个主题
     * @param topic
     * @param qos
     */
    public void subscribe(String topic,int qos){
        try {

            client.subscribe(topic, qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        String kdTopic = "good";
//        PushPayload pushMessage = PushPayload.getPushPayloadBuider().setMobile("15345715326")
//                .setContent("designModel")
//                .bulid();
//        MqttPushClient.getInstance().publish(0, false, kdTopic, pushMessage);
    }
    @Test
    public void test() {

//        PushPayload pushPayload = PushPayload.getPushPayloadBuider().setContent("test")
//                .setMobile("119")
//                .setType("2018")
//                .bulid();
//        mqttClientComponent.push("yes",pushPayload);

    }
}