package demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GPSLocation_R {
    int code;
    String msg;
    Map<String,Object> map=new HashMap<>();
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
        this.map.put("code",code);
    }

    public void setMsg(String msg) {
        this.msg = msg;
        this.map.put("msg",msg);

    }

    public Map<String, Object> getMap() {
        return map;
    }
}
