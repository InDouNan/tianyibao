package mqtt;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import java.util.Map;

public class PushPayload {
    public Map<String,Object> push;
    PushPayload(Map<String,Object> push){
        this.push=push;
    }

    @Override
    public String toString() {

        return JSON.toJSONString(this.push);
    }
}
