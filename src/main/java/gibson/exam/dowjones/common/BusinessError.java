package gibson.exam.dowjones.common;

public enum BusinessError {

    RECORD_IS_EXIST("the record is exist"),
    IMPORT_DATA_FAILED("fail to import data"),

    ;

    private final String code;

    BusinessError(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
