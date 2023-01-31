package gibson.exam.dowjones.tools;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvReader {

    public static <T> List<T> loadObjectList(Class<T> type, MultipartFile file) throws IOException {
        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper mapper = new CsvMapper();
        MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(file.getInputStream());
        return readValues.readAll();
    }

}
