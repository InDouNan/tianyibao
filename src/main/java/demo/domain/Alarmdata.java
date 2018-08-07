package demo.domain;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class Alarmdata {
    @NotNull(message = "设备号不能为空")
    String imei;
    @NotNull(message = "报警类型不能为空")
    String alarmType;
    @NotNull(message = "报警时间不能为空")
    String alarmTime;
    private Map<String,Object> Alarmdata_Map=new HashMap<>();
    public String getImei() {
        return imei;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmTime(String alarmTime) {
        Alarmdata_Map.put("alarmTime",alarmTime);
        this.alarmTime = alarmTime;
    }

    public void setAlarmType(String alarmType) {
        Alarmdata_Map.put("alarmType",alarmType);
        this.alarmType = alarmType;
    }

    public void setImei(String imei) {
        Alarmdata_Map.put("imei",imei);
        this.imei = imei;
    }

    public Map<String, Object> getAlarmdata_Map() {
        return Alarmdata_Map;
    }
}
