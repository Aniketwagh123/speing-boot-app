package com.example.springProject.controller;


import com.example.springProject.model.sensor_data.SensorData;
import com.example.springProject.model.users.UserDao;
import com.example.springProject.model.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    @GetMapping("/Users/get-all")          //Api endpoint or url for get request inside a bracket
    public List<Users> getAllUsers(){
        return userDao.getAllUsers();
    }

    @PostMapping("/Users/save")          //Api endpoint or url for get request inside a bracket
    public Users save(@RequestBody Users user){
        return userDao.saveUser(user);
    }

    @GetMapping("/Users/username")          //Api endpoint or url for get request inside a bracket
    public Users findByUsername(@RequestParam String username){
        return userDao.findbyusername(username);
    }

    @GetMapping("/Users/deviceId")          //Api endpoint or url for get request inside a bracket
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

    @GetMapping("/see")          //Api endpoint or url for get request inside a bracket
    public String see(){
        return "Hello";
    }
}
