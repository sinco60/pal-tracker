package io.pivotal.pal.tracker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memLimit;
    private String instanceIndex;
    private String instanceAddress;

    public EnvController(@Value("${PORT}") String port,
                         @Value("${MEMORY_LIMIT}") String memLimit,
                         @Value("${CF_INSTANCE_INDEX}") String instanceIndex,
                         @Value("${CF_INSTANCE_ADDR}") String instanceAddress) {
        this.port = port;
        this.memLimit = memLimit;
        this.instanceIndex = instanceIndex;
        this.instanceAddress = instanceAddress;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> map = new HashMap<>();
        map.put("PORT", port);
        map.put("MEMORY_LIMIT", memLimit);
        map.put("CF_INSTANCE_INDEX", instanceIndex);
        map.put("CF_INSTANCE_ADDR", instanceAddress);

        return map;
    }
}