package com.example.yp_museum.Dao;

import com.example.yp_museum.Entity.Museum;
import java.util.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumDao {
    public abstract List<Museum> getMuseumListByState(String state);
    public abstract List<Museum> getMuseumListByAddress(String address);
    public abstract List<Museum> getMuseumListByCity(String city);
    public abstract List<Museum> getMuseumListByPartialName(String museumName);
}
