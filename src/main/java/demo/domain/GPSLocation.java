package demo.domain;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GPSLocation {
    @NotNull(message = "设备号不能为空")
    private String imei;
    private String receiveTime;
    @NotNull(message = "定位时间不能为空")
    private String locateTime;
    @NotNull(message = "定位类型不能为空")
    private String locateType;
    @NotNull(message = "经度不能为空")
    private String longitude;
    @NotNull(message = "纬度不能为空")
    private String latitude;
    @NotNull(message = "速度不能为空")
    private String speed;
    @NotNull(message = "方向不能为空")
    private String direction;
    @NotNull(message = "电量不能为空")
    private String electricity;
    private Map<String,Object> GPSLocation_L=new HashMap<>();
    public String getDirection() {

        return direction;
    }

    public String getImei() {
        return imei;
    }

    public String getElectricity() {
        return electricity;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLocateTime() {
        return locateTime;
    }

    public String getLocateType() {
        return locateType;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public String getSpeed() {
        return speed;
    }

    public void setDirection(String direction) {

        GPSLocation_L.put("direction",direction);
        this.direction = direction;
    }

    public void setElectricity(String electricity) {
        GPSLocation_L.put("electricity",electricity);
        this.electricity = electricity;
    }

    public void setImei(String imei) {
        GPSLocation_L.put("imei",imei);
        this.imei = imei;
    }

    public void setLatitude(String latitude) {
        GPSLocation_L.put("latitude",latitude);
        this.latitude = latitude;
    }

    public void setLocateTime(String locateTime) {
        GPSLocation_L.put("locateTime",locateTime);
        this.locateTime = locateTime;
    }

    public void setLocateType(String locateType) {
        GPSLocation_L.put("locateType",locateType);
        this.locateType = locateType;
    }

    public void setLongitude(String longitude) {
        GPSLocation_L.put("longitude",longitude);
        this.longitude = longitude;
    }

    public void setReceiveTime(String receiveTime) {
        GPSLocation_L.put("receiveTime",receiveTime);
        this.receiveTime = receiveTime;
    }

    public void setSpeed(String speed) {
        GPSLocation_L.put("speed",speed);
        this.speed = speed;
    }

    public Map<String, Object> getGPSLocation_L() {
        return GPSLocation_L;
    }
}
