package com.learn.openshift.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/generate")
    public String generate(@RequestParam(value = "requests", defaultValue = "5") int requests) {
        List<String> responses = new ArrayList<>(requests);
        long startTime = System.currentTimeMillis();

        for (int requestId = 0; requestId < requests; requestId++) {
            responses.add("Req:" + requestId + " " + restTemplate.getForObject("http://scalable-service:8080/process?requestId=" + requestId, String.class));
        }
        StringBuilder text = new StringBuilder();
        text.append("<BR> Requests: " + requests);
        text.append("<BR> Execution Time : " + (System.currentTimeMillis() - startTime) + " ms");
        responses.stream().forEach(s -> text.append("<BR>" + s));
        text.append(text);

        return text.toString();
    }
}
