package com.example.yp_museum.Controller;

import com.example.yp_museum.Entity.RequestQuery;
import com.example.yp_museum.Entity.ResponseMessage;
import com.example.yp_museum.Entity.Museum;
import com.example.yp_museum.service.impl.MuseumSvcImpl;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/resort", method = RequestMethod.POST)
public class MuseumController {
    @Autowired
    MuseumSvcImpl svc;

   /* public abstract List<Museum> getMuseumListByState(String state);
    public abstract List<Museum> getMuseumListByAddress(String address);
    public abstract List<Museum> getMuseumListByCity(String city);
    public abstract List<Museum> getMuseumListByName(String museumName);*/

    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody
    public ResponseMessage<List<Museum>> test(@RequestParam("country") String country){
        svc.getMuseumListByName("PIONEER HISTORICAL SOCIETY INC");
        svc.getMuseumListByCity("FARMINGTON");
        svc.getMuseumListByAddress("PO BOX 132");
        ResponseMessage message = new ResponseMessage();
        message.setResponseBody(svc.getMuseumListByState("IA"));
        message.setHttpCode("200");
        return message;
    }

    @ResponseBody
    public List<Museum> processQuery(@RequestBody RequestQuery inputQuery){
        String query = inputQuery.getQuery();
        List<Museum> museums = new ArrayList<Museum>();
        String[] subqueries = query.split("&");
        for(String subquery: subqueries){
            String[] queryParts = subquery.split("=");
            switch(queryParts[0]){
                case "museumState":
                    if( !queryParts[1].equals("") ) {
                        museums = svc.getMuseumListByState(queryParts[1]);
                    }
                    break;
                case "museumAddress":
                    if( !queryParts[1].equals("") ) {
                        museums = svc.getMuseumListByAddress(queryParts[1]);
                    }
                    break;
                case "museumName":
                    if (!queryParts[1].equals("")){
                        museums = svc.getMuseumListByName(queryParts[1]);
                    }
                    break;
                case "museumCity":
                    if (!queryParts[1].equals("")){
                        museums = svc.getMuseumListByCity(queryParts[1]);
                    }
                    break;
            }
        }

        ResponseMessage<List<Museum>> message = new ResponseMessage<List<Museum>>();
        message.setResponseBody(museums);
        return museums;
    }
}
