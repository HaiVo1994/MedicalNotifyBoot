package com.haivo.medical_notify.Controller.Declare.Rest;

import com.haivo.medical_notify.model.Symptom;
import com.haivo.medical_notify.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/symptom")
public class SymptomRestController {
    @Autowired
    private SymptomService symptomService;
    @RequestMapping(value = "/check", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Symptom> test(){
        return symptomService.findAllEnable();
    }
}
