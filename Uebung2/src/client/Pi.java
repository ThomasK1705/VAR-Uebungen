package client;

import compute.Task;
import java.io.Serializable;
import java.math.BigDecimal;

public class Pi implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;

    /** constants used in pi computation */
    private static final BigDecimal FOUR =
        BigDecimal.valueOf(4);

    /** rounding mode to use during pi computation */
    private static final int roundingMode = 
        BigDecimal.ROUND_HALF_EVEN;

    /** digits of precision after the decimal point */
    private final int digits;
	private int randoms;
    
    /**
     * Construct a task to calculate pi to the specified
     * precision.
     */
    public Pi(int digits, int randoms) {
        this.digits = digits;
        this.randoms = randoms;
    }

    /**
     * Calculate pi.
     */
    public BigDecimal execute() {
        return computePi(digits, randoms);
    }
    
    public static BigDecimal computePi(int digits, int randoms){
        int DropsInside = 0; 
        double xCord,yCord;
        for (int i = 1; i <= randoms; i++)   {	
          xCord = Math.random();
          yCord = Math.random();
          if (Math.hypot(xCord,yCord) <= 1)	
        	  DropsInside++;
        }  
        double pi = 4*DropsInside / randoms;
        BigDecimal bigPi = new BigDecimal(pi);
        return bigPi;
      }

}
