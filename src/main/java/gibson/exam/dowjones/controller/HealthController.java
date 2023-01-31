package gibson.exam.dowjones.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping(value = "/v1/health")
    public ResponseEntity health() {
        return ResponseEntity.ok().build();
    }
}
