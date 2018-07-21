package demo.domain;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface insertRepository {

    @SelectProvider(type =sum.class, method = "suminsert")
    int insert_GPS(String insert);


}
