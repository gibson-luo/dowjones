package gibson.exam.dowjones.service;

import gibson.exam.dowjones.pojo.Reference;

import java.util.List;

public interface IReferenceService {

    List<Reference> fetchByTicker(String ticker);

    int insert(Reference reference);
}
