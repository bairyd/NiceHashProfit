package co.za.ethtobtc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

/**
 * Created by DevMachine on 2017/08/14.
 */
public class Nice {
    private BigDecimal btcRate;
    private BigDecimal ethRate;
    private int hashRate;
    private BigDecimal price;
    public Nice(BigDecimal btcRate, BigDecimal ethRate, BigDecimal price){
        this.btcRate = btcRate;
        this.ethRate = ethRate;
        this.price = price;
    }

    public BigDecimal getBtcVal(BigDecimal ethVal){
        return btcRate.multiply(ethVal).setScale(5, RoundingMode.UP);
    }

    public BigDecimal getEthVal(BigDecimal btcVal){
        return ethRate.multiply(btcVal).setScale(5, RoundingMode.UP);
    }

    public void setSpeed(int hashRate) {
        this.hashRate = hashRate;
    }

    public Calendar calculateTimeMining() {
    }
}
