package com.example.pingproject.controller;

import com.example.pingproject.service.PingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Log4j2
@RestController
public class PingController {


    @GetMapping(path = "/pings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> getPing() {
        log.info("status ok");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
