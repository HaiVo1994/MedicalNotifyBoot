package com.haivo.medical_notify.Controller.Declare.Rest;

import com.haivo.medical_notify.model.Person;
import com.haivo.medical_notify.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/person")
public class PersonRestController {
    @Autowired
    private PersonService personService;
    @RequestMapping(value = "/check/{passport}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Person checkPassport(@PathVariable String passport){
        Person person = personService.findByPassport(passport);
        if (person!=null){
            return person;
        }
        return null;
    }
}
