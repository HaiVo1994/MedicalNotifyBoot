package com.haivo.medical_notify.Controller.Statistical.Rest;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.haivo.medical_notify.model.support.Statistical;
import com.haivo.medical_notify.model.support.Statistical_Person;
import com.haivo.medical_notify.service.EntryService;
import com.haivo.medical_notify.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/statistical_symptom")
public class StatisticalSymptomRestController {
    @Autowired
    private EntryService entryService;
    @Autowired
    private StatusService statusService;
    @RequestMapping(value = "/amount_people", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<JsonObject> getStatisticalByAmountSymptom(@RequestBody JsonObject timeFind){
        return statusService.statisticalByCountSymptom(timeFind);
    }
    @RequestMapping(value = "/amount_people/{page}/{size}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonObject getListPeopleByAmountSymptom(@RequestBody JsonObject data,
                                                                   @PathVariable int page,
                                                                   @PathVariable int size){
        return statusService.getListByAmountSymptom(data,size,page);
    }

    @RequestMapping(value = "/symptomType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Statistical> getStatisticalBySymptomType(@RequestBody JsonObject timeFind){
        return statusService.statisticalByTypeSymptom(timeFind);
    }
    @RequestMapping(value = "/symptomType/{page}/{size}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Page<Statistical_Person> getListPeopleBySymptomType(@RequestBody JsonObject data,
                                                                               @PathVariable int page,
                                                                               @PathVariable int size){
        return statusService.getListBySymptomType(data,size,page);
    }
}
