package com.example.springProject.controller;


import com.example.springProject.model.HomeAtomation.HomeAtomation;
import com.example.springProject.model.HomeAtomation.HomeAtomationDao;
import com.example.springProject.model.sensor_data.SensorData;
import com.example.springProject.model.users.UserDao;
import com.example.springProject.model.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;
    @Autowired
    HomeAtomationDao homeAtomationDao;
    @GetMapping("/users/get-all")          //Api endpoint or url for get request inside a bracket
    public List<Users> getAllUsers(){
        return userDao.getAllUsers();
    }

    @PostMapping("/users/save")          //Api endpoint or url for get request inside a bracket
    public Users save(@RequestBody Users user){
        return userDao.saveUser(user);
    }

    @GetMapping("/users/username")          //Api endpoint or url for get request inside a bracket
    public Users findByUsername(@RequestParam String username){
        return userDao.findbyusername(username);
    }

    @GetMapping("/users/deviceId")          //Api endpoint or url for get request inside a bracket
    public Boolean isUniqueDevice(@RequestParam String deviceId){
        return userDao.findbydeviceId(deviceId) == null;
    }

    @PutMapping ("/postData")
    public Users insertData(@RequestBody SensorData sensorData, @RequestParam int userid){
        return userDao.addsensordata(userid,sensorData);
    }
    @PostMapping ("/postSensorData")
    public Users insertSensorData(@RequestBody SensorData sensorData, @RequestParam int userid){
        return userDao.addsensordata(userid,sensorData);
    }
    @PostMapping ("/postSensorDataTo")
    public Users insertSensorDataTo(@RequestParam int userid, @RequestParam int humidity, @RequestParam int temp){
        SensorData sensorData1 = new SensorData();
        sensorData1.setHumidity(humidity);
        sensorData1.setTemp(temp);
        return userDao.addsensordata(userid,sensorData1);
    }


//    @GetMapping("/see")          //Api endpoint or url for get request inside a bracket
//    public String see(){
//        return "Hello";
//    }
    @GetMapping(value = "/r1")          //Api endpoint or url for get request inside a bracket
    public String relay1(@RequestParam String r1){
        String uri = "https://script.google.com/macros/s/AKfycbzsfK6SS5EdscmDUd7j5i8CVpBe41vReAEZJYU-uurRkDsxyNe4O9qOiQildCzphfLqVQ/exec?r1="+r1;
        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.getForObject(uri,String.class);
        return result.toString();
    }
    @GetMapping(value = "/r2")          //Api endpoint or url for get request inside a bracket
    public String relay2(@RequestParam String r2){
        String uri = "https://script.google.com/macros/s/AKfycbzsfK6SS5EdscmDUd7j5i8CVpBe41vReAEZJYU-uurRkDsxyNe4O9qOiQildCzphfLqVQ/exec?r2="+r2;
        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.getForObject(uri,String.class);
        return result.toString();
    }

    @PutMapping ("/update")
    public HomeAtomation update(@RequestBody HomeAtomation homeAtomation){
        return homeAtomationDao.saveHomeAtomation(homeAtomation);
    }

    @GetMapping("/get-status")          //Api endpoint or url for get request inside a bracket
    public String getHomeAtomation(){
        Optional<HomeAtomation> homeAtomation = homeAtomationDao.getHomeAtomation();
        String s = homeAtomation.get().getR1()+","+homeAtomation.get().getR2();
        return s;
    }

}
