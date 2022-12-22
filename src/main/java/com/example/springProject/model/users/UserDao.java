// these class is doing all database operation

package com.example.springProject.model.users;

import com.example.springProject.model.sensor_data.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service // because these class is use from other classes for auto wiring
public class UserDao {

    @Autowired
    private UserRepository userRepository;  // this obj is not null, new instance is created through dependency injection automatically

    public Users saveUser(Users user){
        return userRepository.save(user);
    }
    public List<Users> getAllUsers(){
        List<Users>Users = new ArrayList<>();
        Streamable.of(userRepository.findAll())
                .forEach(Users::add);
        return Users;
    }
    public void delete(Users user){
        userRepository.delete(user);
    }

    public Users findbyusername(String username){
        return userRepository.findByuserName(username);
    }
    public Users findbydeviceId(String deviceId){
        return userRepository.findBydeviceId(deviceId);
    }




    public Users addSensorDataByDeviceId(String deviceId , SensorData sensorData){
        Users user =  userRepository.findBydeviceId(deviceId);
        assert user != null;
        List<SensorData> l = user.getSensor_data();
        l.add(sensorData);
        user.setSensor_data(l);
        return userRepository.save(user);
    }



    public Users addsensordata(int userid , SensorData sensorData){
        Users user =  userRepository.findById(userid).orElse(null);
        assert user != null;
        List<SensorData> l = user.getSensor_data();
        l.add(sensorData);
        user.setSensor_data(l);
        return userRepository.save(user);
    }

    public List<SensorData> getSensorData(String username, Date startDate , Date endDate){
        ArrayList<SensorData> ret = new ArrayList<>();
        Users users = findbyusername(username);
        List<SensorData> data = users.getSensor_data();

        for(int i =0 ; i<data.size();i++){
            if(startDate.after(data.get(i).getDate()) && endDate.before(data.get(i).getDate())){
                ret.add(data.get(i));
            }
        }
        return ret;
    }
}
