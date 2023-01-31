package gibson.exam.dowjones.common;

import lombok.Data;

@Data
public class Dto<T> {

    private String code;
    private T result;

}
