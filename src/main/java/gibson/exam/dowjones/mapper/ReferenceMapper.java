package gibson.exam.dowjones.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gibson.exam.dowjones.pojo.Reference;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReferenceMapper extends BaseMapper<Reference> {

    @Select("SELECT * FROM reference WHERE stock = #{ticker}")
    List<Reference> fetchByTicker(String ticker);

    @Insert({"INSERT INTO reference(quarter, stock, date, open, high, low, close, volume, percent_change_price, percent_change_volume_over_last_wk, previous_weeks_volume, next_weeks_open, next_weeks_close, percent_change_next_weeks_price, days_to_next_dividend, percent_return_next_dividend)",
            "VALUES (#{quarter}, #{stock}, #{date}, #{open}, #{high}, #{low}, #{close}, #{volume}, #{percentChangePrice}, #{percentChangeVolumeOverLastWk}, #{previousWeeksVolume}, #{nextWeeksOpen}, #{nextWeeksClose}, #{percentChangeNextWeeksPrice}, #{daysToNextDividend}, #{percentReturnNextDividend})"})
    int insert(Reference reference);

}
