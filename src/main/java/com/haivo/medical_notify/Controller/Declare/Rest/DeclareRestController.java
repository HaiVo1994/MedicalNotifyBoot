package com.haivo.medical_notify.Controller.Declare.Rest;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.haivo.medical_notify.model.*;
import com.haivo.medical_notify.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/declare")
public class DeclareRestController {
    @Autowired
    private PersonService personService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private HistoryOfExposureService historyOfExposureService;
    @Autowired
    private TransportService transportService;
    @Autowired
    private EntryService entryService;

    @RequestMapping(value = "/sendDeclare", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonObject createPerson(@RequestBody JsonObject declare){
        JsonObject result = new JsonObject();
        LinkedHashMap<String,String> personData = (LinkedHashMap<String,String>) declare.get("person");
        LinkedHashMap<String,String> transportData = (LinkedHashMap<String,String>) declare.get("transport");
        LinkedHashMap<String,String> contactData = (LinkedHashMap<String,String>) declare.get("contact");
        LinkedHashMap<String,String> entryData = (LinkedHashMap<String,String>) declare.get("entry");
        List<LinkedHashMap<String,String>> statusJsonList = (ArrayList<LinkedHashMap<String,String>>) declare.get("status");
        List<LinkedHashMap<String,String>> historyJsonList = (ArrayList<LinkedHashMap<String,String>>) declare.get("historyOfExposures");
        Person person = personService.declare(personData);
        result.put("result", "fail");
        if (person==null){
            result.put("messenger","Tạo Hồ Sơ Người Dùng Thất Bại");
            return result;
        }
        Contact contact = contactService.change(contactData, person);
        Transport transport = transportService.create(transportData);
        if (transport == null) {
            result.put("messenger", "Tạo Phương Tiện Nhập Cảnh Thất Bại");
            return result;
        }
        Entry entry = entryService.create(entryData,person,transport);
        if (entry==null){
           result.put("messenger", "Tạo Tờ Khai Nhập Cảnh Thất Bại");
            return result;
        }
        List<Status> statusList = statusService.declare(statusJsonList, entry);
        if (statusList==null){
            result.put("messenger", "Tạo Tờ Khai Báo Sức Khỏe Thất Bại");
            return result;
        }
        List<HistoryOfExposure> historyOfExposureList = historyOfExposureService.declare(historyJsonList, entry);
        if (historyOfExposureList==null){
            result.put("messenger", "Tạo Tờ Khai Báo Tiếp Xúc Thất Bại");
            return result;
        }
        result.put("result", "success");
        result.put("messenger", "Khai Báo Thành Công");
        return result;
    }
}
