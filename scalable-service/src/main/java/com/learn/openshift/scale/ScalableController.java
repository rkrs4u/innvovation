package com.learn.openshift.scale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ScalableController {
    private String instanceId = UUID.randomUUID().toString();
    ;

    @RequestMapping("/process")
    public String generate(@RequestParam(value = "requestId", defaultValue = "-") int requestId) {
        return " instanceId: " + instanceId;
    }
}
