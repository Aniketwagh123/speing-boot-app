package com.example.springProject.model.HomeAtomation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeAtomationDao {
    @Autowired
    private HomeAtomationRepository homeAtomationRepository;  // this obj is not null, new instance is created through dependency injection automatically

    public HomeAtomation saveHomeAtomation(HomeAtomation homeAtomation){
        return homeAtomationRepository.save(homeAtomation);
    }
    public Optional<HomeAtomation> getHomeAtomation(){
        return homeAtomationRepository.findById(1);
    }
//    public void delete(Users user){
//        homeAtomationRepository.delete(user);
//    }
//
//    public Users findbyusername(String username){
//        return homeAtomationRepository.findByuserName(username);
//    }
//    public Users findbydeviceId(String deviceId){
//        return homeAtomationRepository.findBydeviceId(deviceId);
//    }
//
//    public Users addsensordata(int userid , SensorData sensorData){
//        Users user =  homeAtomationRepository.findById(userid).orElse(null);
//        assert user != null;
//        List<SensorData> l = user.getSensor_data();
//        l.add(sensorData);
//        user.setSensor_data(l);
//        return homeAtomationRepository.save(user);
//    }
//
//    public List<SensorData> getSensorData(String username, Date startDate , Date endDate){
//        ArrayList<SensorData> ret = new ArrayList<>();
//        Users users = findbyusername(username);
//        List<SensorData> data = users.getSensor_data();
//
//        for(int i =0 ; i<data.size();i++){
//            if(startDate.after(data.get(i).getDate()) && endDate.before(data.get(i).getDate())){
//                ret.add(data.get(i));
//            }
//        }
//        return ret;
//    }
}
