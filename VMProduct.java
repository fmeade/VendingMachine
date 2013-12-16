//package vendingmachine;

/**
 * VMProduct.java
 * 
 * Product Object
 * 
 * @author fmeade
 */
public class VMProduct 
{
    private String name;
    private double price;
    private int count;
    
    public VMProduct(String _name,double _price,int _count)
    {
        name = _name;
        price = _price;
        count = _count;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String _name)
    {
        name = _name;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double _price)
    {
        price = _price;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void setCount(int _count)
    {
        count = _count;
    }
}
