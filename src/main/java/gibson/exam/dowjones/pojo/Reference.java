package gibson.exam.dowjones.pojo;


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

    // the percentage change in the number of shares of
    //stock that traded hands for this week compared to the previous week
    private String percentChangeVolumeOverLastWk;

    // the number of shares of stock that traded hands in the previous week
    private String previousWeeksVolume;

    // the opening price of the stock in the following week (unit is cent)
    private String nextWeeksOpen;

    // the closing price of the stock in the following week (unit is cent)
    private String nextWeeksClose;

    // the percentage change in price of the stock in the following week
    private String percentChangeNextWeeksPrice;

    // the number of days until the next dividend
    private Integer daysToNextDividend;

    // the percentage of return on the next dividend
    private String percentReturnNextDividend;

}
