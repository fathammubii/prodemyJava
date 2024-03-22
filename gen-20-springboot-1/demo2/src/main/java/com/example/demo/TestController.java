package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ServiceHello serviceHello;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public ModelHello getHello(){
        return serviceHello.getKata();
    }
    @RequestMapping(path ="/test", method = RequestMethod.POST)
    public String m2(){
        return "getMethod";
    }
    @RequestMapping(path ="/test", method = RequestMethod.PUT)
    public String m3(){
        return "Update Record";
    }
    @RequestMapping(path ="/test", method = RequestMethod.DELETE)
    public String m4(){
        return "Delete Record";
    }
}
