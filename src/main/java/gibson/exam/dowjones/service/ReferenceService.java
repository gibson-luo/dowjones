package gibson.exam.dowjones.service;

import gibson.exam.dowjones.mapper.ReferenceMapper;
import gibson.exam.dowjones.pojo.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceService implements IReferenceService{

    @Autowired
    private ReferenceMapper referenceMapper;


    @Override
    public List<Reference> fetchByTicker(String ticker) {
        return referenceMapper.fetchByTicker(ticker);
    }

    @Override
    public int insert(Reference reference) {
        return referenceMapper.insert(reference);
    }
}
