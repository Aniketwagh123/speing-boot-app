package com.example.springProject;

import com.example.springProject.controller.UserController;
import com.example.springProject.model.sensor_data.SensorData;
import com.example.springProject.model.users.UserDao;
import com.example.springProject.model.users.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
@RestController
public class SpringProjectApplication {
    int x=0;
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}
//	@Autowired
//	UserDao userDao;
	@Scheduled(fixedRate = 10000)
	@GetMapping(value="/hello11")
	public void greeting() {
//		String uri = "http://192.168.1.6";
//		RestTemplate restTemplate1 = new RestTemplate();
//		String result1 = restTemplate1.getForObject(uri,String.class);
//		System.out.println(result1);
//		List<String> list = Arrays.asList(result1.split(","));
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		SensorData sendUser = new SensorData();
//		sendUser.setHumidity(Integer.parseInt(list.get((1))));
//		sendUser.setTemp(Integer.parseInt(list.get((0))));
//		String json = "";
//		try {
//			json = new ObjectMapper().writeValueAsString(sendUser);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		HttpEntity entity = new HttpEntity(json,headers);
//		String uri1 = "https://speing-boot-app-production.up.railway.app/postSensorDataTo?userid=1&humidity="+Integer.parseInt(list.get((1)))+"&temp="+Integer.parseInt(list.get((0)));
//		RestTemplate restTemplate = new RestTemplate();
//		Object result = restTemplate.exchange(uri1, HttpMethod.POST ,entity , Object.class);
//		System.out.println(result);

	}

}
