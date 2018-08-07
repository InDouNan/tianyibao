package demo.service;


import Until.RedisUtil;
import demo.domain.GPSLocation;
import demo.model.GPSLocation_R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class GPSService {
    @Autowired
    RedisUtil redisUtil;
    public GPSLocation_R GPSLocation_s(GPSLocation gpsLocation){

        GPSLocation_R R=new GPSLocation_R();
        R.setMsg("success");
        try {
            if(Integer.valueOf(gpsLocation.getDirection()).intValue()
                    <0||(Integer.valueOf(gpsLocation.getDirection())).intValue()>600)
            {R.setCode(400);
            R.setMsg("方向："+gpsLocation.getDirection()+" 不在 0-360内");
                return R;
            }
        }catch (java.lang.NumberFormatException e){
            R.setCode(400);
            R.setMsg("方向"+e.toString());
            return R;
        }
        try {
            Double.valueOf(gpsLocation.getSpeed());

        }catch (java.lang.NumberFormatException e){
            R.setCode(400);
            R.setMsg("速度"+e.toString());
            return R;
        }
        try {

            if(Integer.valueOf(gpsLocation.getElectricity()).intValue()
                    <0||(Integer.valueOf(gpsLocation.getElectricity())).intValue()>100)
            {R.setCode(400);
                R.setMsg("电量："+gpsLocation.getElectricity()+" 不在 0-100内");
                return R;
            }
        }catch (java.lang.NumberFormatException e){
            R.setMsg("电量"+e.toString());
            return R;
        }
        try {

            if(Integer.valueOf(gpsLocation.getLocateType()).intValue()
                    !=0&&Integer.valueOf(gpsLocation.getLocateType()).intValue()
                    !=1&&Integer.valueOf(gpsLocation.getLocateType()).intValue()
                    !=2)
            {
                R.setCode(400);
                R.setMsg("定位类型："+gpsLocation.getLocateType()+" 不在 0基站定位；1GPS定位；2未定位 内");
                return R;
            }
        }catch (java.lang.NumberFormatException e){
            R.setMsg("定位"+e.toString());
            return R;
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gpsLocation.setReceiveTime(df.format(new Date()));
        try {

            df.parse(gpsLocation.getLocateTime());
        }catch (Exception e){
            R.setMsg("日期格式"+e.toString());
            return R;
        }
        try {
            Double.valueOf(gpsLocation.getLongitude());

        }catch (java.lang.NumberFormatException e){
            R.setCode(400);
            R.setMsg("经度"+e.toString());
            return R;
        }
        try {
            Double.valueOf(gpsLocation.getLatitude());

        }catch (java.lang.NumberFormatException e){
            R.setCode(400);
            R.setMsg("纬度"+e.toString());
            return R;
        }
        try {
            redisUtil.hmset("GPS "+gpsLocation.getImei()+gpsLocation.getLocateTime()+gpsLocation.getLocateType()
                    , gpsLocation.getGPSLocation_L());

            R.setCode(200);
        }catch (Exception e)
        {
            R.setCode(500);
            R.setMsg(e.toString());
        }


return R;

    }
}
