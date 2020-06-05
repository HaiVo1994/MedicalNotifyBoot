//package com.haivo.medical_notify;
//
//import com.haivo.medical_notify.service.*;
//import com.haivo.medical_notify.service.impl.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@Configuration
//@ComponentScan("com.haivo.medical_notify")
//@EnableJpaRepositories("com.haivo.medical_notify.repository")
//public class AppConfig {
//
//    @Bean
//    public ContactService contactService(){
//        return new ContactServiceImpl();
//    }
//    @Bean
//    public DistrictService districtService(){
//        return new DistrictServiceImpl();
//    }
//    @Bean
//    public EntryService entryService(){
//        return new EntryServiceImpl();
//    }
//    @Bean
//    public ExposureService exposureService(){
//        return new ExposureServiceImpl();
//    }
//    @Bean
//    public GateService gateService(){
//        return new GateServiceImpl();
//    }
//    @Bean
//    public HistoryOfExposureService historyOfExposureService(){
//        return new HistoryOfExposureServiceImpl();
//    }
//    @Bean
//    public NationalService nationalService(){
//        return new NationalServiceImpl();
//    }
//    @Bean
//    public PersonService personService(){
//        return new PersonServiceImpl();
//    }
//    @Bean
//    public ProvinceService provinceService(){
//        return new ProvinceServiceImpl();
//    }
//    @Bean
//    public StatusService statusService(){
//        return new StatusServiceImpl();
//    }
//    @Bean
//    public SymptomService symptomService(){
//        return new SymptomServiceImpl();
//    }
//    @Bean
//    public TransportService transportService(){
//        return new TransportServiceImpl();
//    }
//    @Bean
//    public TransportTypeService transportTypeService(){
//        return new TransportTypeServiceIml();
//    }
//    @Bean
//    public WardService wardService(){
//        return new WardServiceImpl();
//    }
//}
