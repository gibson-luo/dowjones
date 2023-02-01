package gibson.exam.dowjones.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import gibson.exam.dowjones.common.BusinessError;
import gibson.exam.dowjones.common.Dto;
import gibson.exam.dowjones.common.DtoUtil;
import gibson.exam.dowjones.pojo.Reference;
import gibson.exam.dowjones.service.ReferenceService;
import gibson.exam.dowjones.tools.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/reference")
public class ReferenceController {

    @Autowired
    private ReferenceService referenceService;

    @GetMapping(value = "fetchByTicker")
    public ResponseEntity<Dto> fetchByTicker(@RequestParam("ticker") String ticker) {
        List<Reference> result = referenceService.fetchByTicker(ticker);
        return DtoUtil.ok(result);
    }

    @PostMapping(value = "importData")
    public ResponseEntity<Dto> importData(@RequestParam("file") MultipartFile file) {
        try {
            List<Reference> dataSet = CsvReader.loadObjectList(Reference.class, file);
            boolean result = referenceService.saveBatch(dataSet);
        }catch (Exception e){
            return DtoUtil.error(BusinessError.IMPORT_DATA_FAILED, e);
        }
        return DtoUtil.ok();
    }

    @PostMapping(value = "save")
    public ResponseEntity<Dto> save(@RequestBody Reference reference) {
        QueryWrapper<Reference> wrapper = new QueryWrapper<>();
        long count = referenceService.count(wrapper.eq("stock", reference.getStock()).eq("date", reference.getDate()));
        if(count > 0){
            return DtoUtil.error(BusinessError.RECORD_IS_EXIST);
        }
        return DtoUtil.ok(referenceService.save(reference));
    }
}
