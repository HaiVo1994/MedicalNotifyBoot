package com.haivo.medical_notify.Controller.Statistical.Rest;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.haivo.medical_notify.model.support.Statistical;
import com.haivo.medical_notify.model.support.Statistical_Person;
import com.haivo.medical_notify.service.HistoryOfExposureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/statistical_exposure")
public class StatisticalExposureRestController {
    @Autowired
    private HistoryOfExposureService historyOfExposureService;

    @RequestMapping(value = "/amount_people", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<JsonObject> getStatisticalSymptom(@RequestBody JsonObject timeFind){
        return historyOfExposureService.statisticalByCountPerson(timeFind);
    }

    @RequestMapping(value = "/amount_people/{page}/{size}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonObject getListPeopleByAmountExposure(@RequestBody JsonObject data,
                                                                    @PathVariable int page,
                                                                    @PathVariable int size){
        return historyOfExposureService.getListByAmountExposure(data,size,page);
    }

    @RequestMapping(value = "/exposureType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Statistical> getStatisticalBySymptomType(@RequestBody JsonObject timeFind){
        return historyOfExposureService.statisticalByTypeExposure(timeFind);
    }
    @RequestMapping(value = "/exposureType/{page}/{size}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Page<Statistical_Person> getListPeopleByExposureType(@RequestBody JsonObject data,
                                                                                @PathVariable int page,
                                                                                @PathVariable int size){
        return historyOfExposureService.getListByExposureType(data,size,page);
    }
}
