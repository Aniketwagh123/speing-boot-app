package com.example.springProject.model.sensor_data;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_no;
//    @CreationTimestamp
//    private LocalDateTime time;
    private int Humidity;
    private int temp;
    @CreationTimestamp
    private Date date ;

    public int getRow_no() {
        return row_no;
    }

//    public LocalDateTime getTime() {
//        return time;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHumidity() {
        return Humidity;
    }

    public int getTemp() {
        return temp;
    }

    public void setRow_no(int row_no) {
        this.row_no = row_no;
    }

//    public void setTime(LocalDateTime time) {
//        this.time = time;
//    }

    public void setHumidity(int humidity) {
        Humidity = humidity;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "row_no=" + row_no +
//                ", time=" + time +
                ", Humidity=" + Humidity +
                ", temp=" + temp +
                '}';
    }
}
