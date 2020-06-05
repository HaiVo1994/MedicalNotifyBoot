package com.haivo.medical_notify.Controller.Statistical.Rest;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.haivo.medical_notify.model.support.Statistical_Entry;
import com.haivo.medical_notify.model.support.Statistical_Person;
import com.haivo.medical_notify.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/statistical_entry")
public class StatisticalEntryRestController {
    @Autowired
    private EntryService entryService;
    @RequestMapping(value = "/amount_people", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Statistical_Entry> statisticalEntry(@RequestBody JsonObject dateFind){
        List<Statistical_Entry> result = entryService.statisticalEntry(dateFind);
        return result;
    }
    @RequestMapping(value = "/listPeople/{page}/{size}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Page<Statistical_Person> listEntry(@RequestBody JsonObject dateFind,
                                                              @PathVariable int page,
                                                              @PathVariable int size){
        return entryService.getByImmigrationDate(dateFind, page, size);
    }
}
