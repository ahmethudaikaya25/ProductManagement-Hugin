package com.ahk.db.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInitializr implements Runnable{
    String [] args;

    public SpringInitializr(String [] args){
        this.args = args;
    }

    @Override
    public void run() {
        SpringApplication.run(SpringInitializr.class,args);
    }
}
