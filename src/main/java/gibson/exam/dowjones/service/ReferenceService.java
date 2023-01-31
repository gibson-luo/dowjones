package gibson.exam.dowjones.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gibson.exam.dowjones.mapper.ReferenceMapper;
import gibson.exam.dowjones.pojo.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceService extends ServiceImpl<ReferenceMapper, Reference> {

    @Autowired
    private ReferenceMapper referenceMapper;

    public List<Reference> fetchByTicker(String ticker) {
        return referenceMapper.fetchByTicker(ticker);
    }

}
