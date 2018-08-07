package demo.web;

import demo.domain.GPSLocation;
import demo.model.GPSLocation_R;

import demo.service.GPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class GPSController {
    @Autowired
    GPSService gps;

    @RequestMapping(method = RequestMethod.POST, value = "/GPSLocated")
    public GPSLocation_R GPSLocated (@RequestBody @Valid GPSLocation GPS){
      return gps.GPSLocation_s(GPS);
    }

}
