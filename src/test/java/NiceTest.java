import co.za.ethtobtc.Nice;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by DevMachine on 2017/08/14.
 */
public class NiceTest {

    private Nice nice;

    @Before
    public void setup(){
        nice = new Nice(BigDecimal.valueOf(0.0707597675), BigDecimal.valueOf(14.1323245), BigDecimal.valueOf(0.0172));
    }

    @Test
    public void validateThatBitcoinConvertedCorrectly(){
        BigDecimal btcVal = nice.getBtcVal(BigDecimal.valueOf(2));
        assertEquals(BigDecimal.valueOf(0.141520).setScale(5, RoundingMode.UP), btcVal);
    }

    @Test
    public void validateThatEthConvertedCorrectly(){
        BigDecimal ethVal = nice.getEthVal(BigDecimal.valueOf(2));
        assertEquals(BigDecimal.valueOf(28.2646490).setScale(5, RoundingMode.UP), ethVal);
    }

    @Test
    public void validateThatReturnedEthEqualsSuppliedEth(){
        BigDecimal btcVal = nice.getBtcVal(BigDecimal.ONE);
        BigDecimal ethVal = nice.getEthVal(btcVal);
        assertEquals(BigDecimal.ONE,ethVal.setScale(0, RoundingMode.DOWN));
    }

    @Test
    public void increaseSpeed(){
        nice.setSpeed(350000);
        Calendar calendar = nice.calculateTimeMining();
    }

}
