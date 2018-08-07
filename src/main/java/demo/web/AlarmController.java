package demo.web;

import demo.domain.Alarmdata;
import demo.domain.GPSLocation;
import demo.model.GPSLocation_R;
import demo.service.AlarmService;
import demo.service.GPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class AlarmController {
    @Autowired
    AlarmService alarmService;

    @RequestMapping(method = RequestMethod.POST, value = "/Alarmdata")
    public GPSLocation_R GPSLocated (@RequestBody @Valid Alarmdata alarmdata){
        return alarmService.Alarmdata_s(alarmdata);
    }
}
