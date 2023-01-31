package gibson.exam.dowjones.controller;

import gibson.exam.dowjones.service.IReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/reference")
public class ReferenceController {

    @Autowired
    private IReferenceService referenceService;

    @GetMapping(value = "fetchByTicker")
    public ResponseEntity fetchByTicker(@RequestParam("ticker") String ticker) {
        return ResponseEntity.ok().body(referenceService.fetchByTicker(ticker));
    }
}
