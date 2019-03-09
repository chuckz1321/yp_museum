package com.example.yp_museum.Mapper;

import java.util.*;
import com.example.yp_museum.Entity.Museum;

public interface MuseumMapper {
    public abstract List<Museum> getMuseumListByState(String state);
    public abstract List<Museum> getMuseumListByAddress(String address);
    public abstract List<Museum> getMuseumListByCity(String city);
    public abstract List<Museum> getMuseumListByName(String museumName);
}
