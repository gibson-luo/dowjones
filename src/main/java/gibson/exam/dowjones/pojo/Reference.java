package gibson.exam.dowjones.pojo;


import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reference {

    private BigInteger id;

    // the yearly quarter (1 = Jan-Mar; 2 = Apr=Jun).
    private Integer quarter;

    // the stock symbol
    private String stock;

    // the last business day of the work (this is typically a Friday)
    private String date;

    // the price of the stock at the beginning of the week (unit is cent)
    private String open;

    // the highest price of the stock during the week  (unit is cent)
    private String high;

    // the lowest price of the stock during the week (unit is cent)
    private String low;

    // the price of the stock at the end of the week (unit is cent)
    private String close;

    // the number of shares of stock that traded hands in the week
    private String volume;

    // the percentage change in price throughout the week
    private String percentChangePrice;

    @JsonSetter("percent_change_price")
    public void setPercentChangePrice(String percentChangePrice) {
        this.percentChangePrice = percentChangePrice;
    }

    // the percentage change in the number of shares of
    //stock that traded hands for this week compared to the previous week
    private String percentChangeVolumeOverLastWk;

    @JsonSetter("percent_change_volume_over_last_wk")
    public void setPercentChangeVolumeOverLastWk(String percentChangeVolumeOverLastWk) {
        this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
    }

    // the number of shares of stock that traded hands in the previous week
    private String previousWeeksVolume;

    @JsonSetter("previous_weeks_volume")
    public void setPreviousWeeksVolume(String previousWeeksVolume) {
        this.previousWeeksVolume = previousWeeksVolume;
    }

    // the opening price of the stock in the following week (unit is cent)
    private String nextWeeksOpen;

    @JsonSetter("next_weeks_open")
    public void setNextWeeksOpen(String nextWeeksOpen) {
        this.nextWeeksOpen = nextWeeksOpen;
    }

    // the closing price of the stock in the following week (unit is cent)
    private String nextWeeksClose;

    @JsonSetter("next_weeks_close")
    public void setNextWeeksClose(String nextWeeksClose) {
        this.nextWeeksClose = nextWeeksClose;
    }

    // the percentage change in price of the stock in the following week
    private String percentChangeNextWeeksPrice;

    @JsonSetter("percent_change_next_weeks_price")
    public void setPercentChangeNextWeeksPrice(String percentChangeNextWeeksPrice) {
        this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
    }

    // the number of days until the next dividend
    private Integer daysToNextDividend;

    @JsonSetter("days_to_next_dividend")
    public void setDaysToNextDividend(Integer daysToNextDividend) {
        this.daysToNextDividend = daysToNextDividend;
    }

    // the percentage of return on the next dividend
    private String percentReturnNextDividend;

    @JsonSetter("percent_return_next_dividend")
    public void setPercentReturnNextDividend(String percentReturnNextDividend) {
        this.percentReturnNextDividend = percentReturnNextDividend;
    }

}
