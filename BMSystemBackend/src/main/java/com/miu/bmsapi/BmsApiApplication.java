package com.miu.bmsapi;

import com.miu.bmsapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootApplication
@EnableScheduling
public class BmsApiApplication{
    public static void main(String[] args) {
        SpringApplication.run(BmsApiApplication.class, args);
        System.out.println("APPLICATION HAS STARTED!!!");
    }

}