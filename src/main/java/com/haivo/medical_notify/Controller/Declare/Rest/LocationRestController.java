package com.haivo.medical_notify.Controller.Declare.Rest;

import com.haivo.medical_notify.model.District;
import com.haivo.medical_notify.model.Province;
import com.haivo.medical_notify.model.Ward;
import com.haivo.medical_notify.service.DistrictService;
import com.haivo.medical_notify.service.ProvinceService;
import com.haivo.medical_notify.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/location")
public class LocationRestController {
    @Autowired
    private ProvinceService provinceService;
    @RequestMapping(value = "/province/{nationalId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Province> getListProvince(@PathVariable Short nationalId){
        return provinceService.findAllByNational(nationalId);
    }

    @Autowired
    private DistrictService districtService;
    @RequestMapping(value = "/district/{provinceId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<District> getListDistrict(@PathVariable Integer provinceId){
        return districtService.findByProvince(provinceId);
    }

    @Autowired
    private WardService wardService;
    @RequestMapping(value = "/ward/{districtId}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Ward> getListWard(@PathVariable Long districtId){
        return wardService.findByDistrict(districtId);
    }
}
