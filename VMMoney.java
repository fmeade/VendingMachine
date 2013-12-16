//package vendingmachine;

/**
 * VMMoney.java
 * 
 * Money Object
 * 
 * @author forrest_meade
 */
public class VMMoney 
{
    private double bank;
    
    public VMMoney(double _bank)
    {
        bank = _bank;
    }
    
    public void calculate()
    {
        bank = bank + 0.75;
    }
    
    public double refund()
    {
        bank = bank - 0.75;
        
        return 0.75;
    }
    
    public double reset()
    {
        double profit = bank;
        bank = 0;
        
        return profit;
    }
}
