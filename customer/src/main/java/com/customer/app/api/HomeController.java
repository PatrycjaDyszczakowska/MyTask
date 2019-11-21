package com.customer.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HomeController {
    @Autowired
    Environment environment;

    @RequestMapping("/")
    public String Hello() throws UnknownHostException{
        String datePattern = "dd/MM/yyyy HH:mm:ss";
        DateTimeFormatter df = DateTimeFormatter.ofPattern(datePattern);
        LocalDateTime now = LocalDateTime.now();
        String hostName = InetAddress.getLocalHost().getHostName();
        String port = environment.getProperty("local.server.port");
        return "Customer do you speak whale? - Web server @ "+df.format(now) +". <br/><br/><br/>Host:<br/>"+hostName+"<span style=\"color:red;\">;</span>"+port;
    }
}
