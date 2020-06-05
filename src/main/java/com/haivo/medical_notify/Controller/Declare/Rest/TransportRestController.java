package com.haivo.medical_notify.Controller.Declare.Rest;

import com.haivo.medical_notify.model.Transport;
import com.haivo.medical_notify.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/transport")
public class TransportRestController {
    @Autowired
    private TransportService transportService;
    @RequestMapping(value = "/getByType/{transportType}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Transport> getByType(@PathVariable Short transportType){
        return transportService.findByType(transportType);
    }
}
