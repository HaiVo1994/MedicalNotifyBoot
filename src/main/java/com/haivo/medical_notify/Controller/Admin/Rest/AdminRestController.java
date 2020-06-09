package com.haivo.medical_notify.Controller.Admin.Rest;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.haivo.medical_notify.model.*;
import com.haivo.medical_notify.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/admin")
public class AdminRestController {
    @Autowired
    private GateService gateService;

    @RequestMapping(value = "/gate_create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Gate createGate(@RequestBody Gate gate) {
        return gateService.save(gate);
    }

    @Autowired
    private NationalService nationalService;

    @RequestMapping(value = "/national_create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")

    public National createNational(@RequestBody National national) {
        return nationalService.save(national);
    }

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "/province_create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Province> createProvince(@RequestBody JsonObject province) {
        Short idNational = Short.parseShort(String.valueOf(province.get("national"))) ;
        National national = nationalService.findById(idNational);
        String provinces = String.valueOf(province.get("provinces"));
        String[] listProvinceName = provinces.split(",");
        List<Province> provinceList = new ArrayList<>();
        for (String provinceName : listProvinceName) {
            provinceList.add(provinceService.create(provinceName, national));
        }
        return provinceList;
    }

    @Autowired
    private DistrictService districtService;

    @RequestMapping(value = "/district_create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<District> createDistrict(@RequestBody JsonObject district) {
        Integer idProvince = Integer.parseInt(String.valueOf(district.get("province"))) ;
        Province province = provinceService.findById(idProvince);
        String districts = String.valueOf(district.get("provinces"));
        String[] listProvinceName = districts.split(",");
        List<District> districtList = new ArrayList<>();
        for (String districtName : listProvinceName) {
            districtList.add(districtService.create(districtName, province));
        }
        return districtList;
    }

    @Autowired
    private WardService wardService;
    @RequestMapping(value = "/ward_create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Ward> createWard(@RequestBody JsonObject ward) {
        Long idDistrict = Long.parseLong(String.valueOf(ward.get("district"))) ;
        District district = districtService.findById(idDistrict);
        String wards = String.valueOf(ward.get("wards"));
        String[] listWardName = wards.split(",");
        List<Ward> wardList = new ArrayList<>();
        for (String districtName : listWardName) {
            wardList.add(wardService.create(districtName, district));
        }
        return wardList;
    }

    @Autowired
    private SymptomService symptomService;
    @RequestMapping(value = "/symptom_create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Symptom> createSymptom(@RequestBody JsonObject symptomsName){
        String[] symptomNameList = String.valueOf(symptomsName.get("symptomsName")).split(",");
        List<Symptom> symptoms = new ArrayList<>();
        for (String symptomName: symptomNameList){
            symptoms.add(symptomService.create(symptomName));
        }
        return symptoms;
    }

    @Autowired
    private ExposureService exposureService;
    @RequestMapping(value = "/exposure_create", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Exposure> createExposure(@RequestBody JsonObject exposuresName){
        String[] exposureNameList = String.valueOf(exposuresName.get("exposuresName")).split(",");
        List<Exposure> exposures = new ArrayList<>();
        for (String exposureName: exposureNameList){
            exposures.add(exposureService.create(exposureName));
        }
        return exposures;
    }
}
