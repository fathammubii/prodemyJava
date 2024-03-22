package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ServiceHello {
    private ModelHello modelHello;

    public ServiceHello(){
        modelHello = new ModelHello("Hello World");
    }

    public ModelHello getKata(){
        return modelHello;
    }
}
