package demo.service;


import Until.RedisUtil;
import demo.domain.Alarmdata;
import demo.domain.GPSLocation;
import demo.model.GPSLocation_R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AlarmService {
    @Autowired
    RedisUtil redisUtil;
    public GPSLocation_R Alarmdata_s(Alarmdata alarmdata){

        GPSLocation_R R=new GPSLocation_R();
        R.setMsg("success");

        try {

            if(Integer.valueOf(alarmdata.getAlarmType()).intValue()
                    !=0&&Integer.valueOf(alarmdata.getAlarmType()).intValue()
                    !=1&&Integer.valueOf(alarmdata.getAlarmType()).intValue()
                    !=2&&Integer.valueOf(alarmdata.getAlarmType()).intValue()
                    !=3)
            {
                R.setCode(400);
                R.setMsg("报警类型："+alarmdata.getAlarmType()+" 不在" +
                        " 0-断电报警；1-光感报警；2-入围栏报警；3-出围栏报警 内");
                return R;
            }
        }catch (NumberFormatException e){
            R.setMsg("定位"+e.toString());
            return R;
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {

            df.parse(alarmdata.getAlarmTime());
        }catch (Exception e){
            R.setMsg("日期格式"+e.toString());
            return R;
        }

        try {
            redisUtil.hmset("GPS "+alarmdata.getImei()+alarmdata.getAlarmType()+alarmdata.getAlarmTime()
                    , alarmdata.getAlarmdata_Map());

            R.setCode(200);
        }catch (Exception e)
        {
            R.setCode(500);
            R.setMsg(e.toString());
        }


return R;

    }
}
