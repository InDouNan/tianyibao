package demo.Batching;

import demo.domain.insertRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Vector;

public class insert {
    @Autowired
    static  insertRepository repository;
private double latitude;
private double longitude;
private Date locate_Time;
private Date receive_Time;
private String IMEI;
public static Vector<insert> INSERT;
private static long time=System.currentTimeMillis();
public static long number=0;
public static String sum;
insert(double latitude,double longitude,Date locate_Time,Date receive_Time){
    this.latitude=longitude;
    this.longitude=longitude;
    this.locate_Time=locate_Time;
    this.receive_Time=receive_Time;
    store(this);
}
synchronized static void store(insert insert){
    INSERT.add(insert);
    number++;
    if(number==100000||System.currentTimeMillis()-time>=1000){
        sum();
    }
}
synchronized static void sum() {
    int x;
    sum = "INSERT INTO location (latitude,longitude,locate_Time,receive_Time,IMEI)" +
            " VALUES ";
    for (x = 0; x < INSERT.size() - 1; x++) {
        sum +=INSERT.get(x)+",";
    }
    sum+=INSERT.get(x+1)+";";

}
synchronized static void send(){
repository.insert_GPS(sum);
}

    @Override
    public String toString() {
        return "("+latitude+","+longitude+","+locate_Time+","+receive_Time+",\""+IMEI+"\")";
    }

}
