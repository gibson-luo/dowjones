package gibson.exam.dowjones.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DtoUtil {

    public static ResponseEntity<Dto> ok() {
        Dto dto = new Dto();
        dto.setCode("OK");
        return ResponseEntity.ok().body(dto);
    }

    public static <T> ResponseEntity<Dto> ok(T t) {
        Dto dto = new Dto();
        dto.setCode("OK");
        dto.setResult(t);
        return ResponseEntity.ok().body(dto);
    }

    public static ResponseEntity<Dto> created() {
        Dto dto = new Dto();
        dto.setCode("Created");
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    public static <T> ResponseEntity<Dto> error(Exception e) {
        Dto dto = new Dto();
        dto.setCode("Error");
        dto.setResult(e.getMessage());
        return ResponseEntity.internalServerError().body(dto);
    }

    public static <T> ResponseEntity<Dto> error(BusinessError error) {
        Dto dto = new Dto();
        dto.setCode(error.getCode());
        return ResponseEntity.internalServerError().body(dto);
    }

    public static <T> ResponseEntity<Dto> internalError() {
        Dto dto = new Dto();
        dto.setCode("internal server error");
        return ResponseEntity.internalServerError().body(dto);
    }

    public static <T> ResponseEntity<Dto> error(BusinessError error, Exception e) {
        Dto dto = new Dto();
        dto.setCode(error.getCode());
        dto.setResult(e.getLocalizedMessage());
        return ResponseEntity.internalServerError().body(dto);
    }
}
