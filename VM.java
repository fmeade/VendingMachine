//package vendingmachine;

import java.io.*;
import java.util.*;

/**
 * VM.java
 * 
 * 
 * 
 * @author fmeade
 */
public class VM 
{
    private VMProduct[] product = new VMProduct[6];
    private VMMoney money = new VMMoney(0);
    
    private String[] name = {"Coke","Pepsi","Sprite",
                             "Brisk","7up","Sunkist"};
    
    private final double price1 = 0.75;
    private final double price2 = .75;
    
    private final int maxCount = 2;
    
    private String amount;
    private String item;
    private String choice;
    private int passcode;
    private double profit;
    
    private Scanner scan = new Scanner(System.in);
    
    public VM() throws Exception
    {
        Scanner scan = new Scanner(System.in);
        
        for(int x=0;x<product.length;x++)
        {
            product[x] = new VMProduct(name[x],price1,maxCount);
        }
        
        start();
        
    }
    
    public void start() throws Exception
    {
        item = "";
        choice = "";
        amount = "";
        
        System.out.println(" Welcome to the Soda Machine");
        
        System.out.println("   ______________________________");
        System.out.println("  /  __         __      |        \\");
        System.out.println(" |  /  \\       /  \\     |  "+ name[0] +"   |");
        System.out.println(" | |    |     |    |    |         |");
        System.out.println(" |  \\__/       \\__/     |  "+ name[1] +"  |");
        System.out.println(" |                      |         |______");
        System.out.println(" |   __         __      |         | Coin |");
        System.out.println(" |  /  \\       /  \\     |  "+ name[2] +" | ---- |");
        System.out.println(" | |    |     |    |    |         |______|");
        System.out.println(" |  \\__/       \\__/     |  "+ name[3] +"  |");
        System.out.println(" |                      |         |");
        System.out.println(" |   __         __      |         |  ");
        System.out.println(" |  /  \\       /  \\     |   "+ name[4] +"   |");
        System.out.println(" | |    |     |    |    |         |");
        System.out.println(" |  \\__/       \\__/     | "+ name[5] +" |");
        System.out.println(" | ____________________ | _______ |");
        System.out.println(" |  _______    _____    |  ____   |");
        System.out.println(" | _____    _________   | |____|  |");
        System.out.println("  \\_____________________|________/");
        
        System.out.println("");
            
        while(!choice.equals("Customer") && !choice.equals("Manager") && 
              !choice.equals("customer") && !choice.equals("manager") && 
              !choice.equals("exit")     && !choice.equals("Exit"))
        {
            System.out.print(" Customer or Manager? ");
            choice = scan.next();
        }
        if(choice.equals("exit") || choice.equals("Exit"))
        {
            System.exit(0);
        }    
        else if(choice.equals("Customer") || choice.equals("customer"))
        {
            customer();
        }
        else if(choice.equals("Manager") || choice.equals("manager"))
        {
            
            System.out.println("   ____________________");
            System.out.println("  /                    \\");
            System.out.println(" |    Enter Passcode   |");
            System.out.println(" |                     |");
            System.out.println(" |     __ __ __ __     |");
            System.out.println("  \\____________________/");
            
            System.out.println("");
            
            System.out.print("Enter passcode: ");
                passcode = scan.nextInt();
            
            while(passcode != 1234)
            {
                System.out.println("Invalid Passcode");
                System.out.print("Enter passcode: ");
                passcode = scan.nextInt();
            }
                
            manager();
        }
        else if(choice.equals("exit"))
        {
            System.exit(0);
        }
        else
        {
            start();
        }
    }
    
    public void customer() throws Exception
    {
        purchase();
    }
    
    public void purchase() throws Exception {
        amount = "-1";
        
        System.out.println("  __________________");
        System.out.println(" /                  \\");
        System.out.println("|    Enter Amount    |");
        System.out.println("|      ($0.75)       |");
        System.out.println("|     $__.__ __      |");
        System.out.println(" \\__________________/");
        
        System.out.println("");
        
        System.out.print("Please enter $0.75 cents: ");
            amount = scan.next();
            
        boolean hm = false;
        
        while(amount.equals("-1"))
        {
        try {
            while ((Double.parseDouble(amount)) != price1 && (Double.parseDouble(amount)) != price2) {
                hm = false;

                if(hm == false && !amount.equals("-1"))
                {
                System.out.println("Invalid Amount");
                hm = true;
                }

                amount = "0";

                System.out.print("Please reenter amount: ");
                amount = scan.next();
            }
        } catch (Exception e) {
            System.out.println("Invalid Amount Format");
            amount = "-1";
            hm = true;
        }
        }
        
        money.calculate();
        
        boolean OutofStock = true;
        
        while(OutofStock == true)
        {
        
        System.out.println("   ______________________________");
        System.out.println("  /  __         __      |        \\");
        System.out.println(" |  /  \\       /  \\     |  "+ name[0] +"   |");
        System.out.println(" | |    |     |    |    |         |");
        System.out.println(" |  \\__/       \\__/     |  "+ name[1] +"  |");
        System.out.println(" |                      |         |______");
        System.out.println(" |   __         __      |         | Coin |");
        System.out.println(" |  /  \\       /  \\     |  "+ name[2] +" | paid |");
        System.out.println(" | |    |     |    |    |         |______|");
        System.out.println(" |  \\__/       \\__/     |  "+ name[3] +"  |");
        System.out.println(" |                      |         |");
        System.out.println(" |   __         __      |         |  ");
        System.out.println(" |  /  \\       /  \\     |   "+ name[4] +"   |");
        System.out.println(" | |    |     |    |    |         |");
        System.out.println(" |  \\__/       \\__/     | "+ name[5] +" |");
        System.out.println(" | ____________________ | _______ |");
        System.out.println(" |  _______    _____    |  ____   |");
        System.out.println(" | _____    _________   | |____|  |");
        System.out.println("  \\_____________________|________/");
        
        System.out.println("");
        
        System.out.println("(Type \"Refund\" to get money back)");
        System.out.print("Please enter desired item: ");
            item = scan.next();
            
        
        boolean choice = false;    
        int count = 0;
        while(choice == false && count < product.length)
        {
            if(item.equals("Refund") || item.equals("refund"))
            {
                refund();
            }
            //System.out.println("test");
            if((item.toLowerCase()).equals((product[count].getName()).toLowerCase()))
            {
                choice = true;
            }
            
            count++;
        }
        
        while(choice == false)
        {
            //System.out.println("test");
            count = 0;
            System.out.println("Invalid Item");
            
            System.out.println();
            
            System.out.println("   ______________________________");
        System.out.println("  /  __         __      |        \\");
        System.out.println(" |  /  \\       /  \\     |  "+ name[0] +"   |");
        System.out.println(" | |    |     |    |    |         |");
        System.out.println(" |  \\__/       \\__/     |  "+ name[1] +"  |");
        System.out.println(" |                      |         |______");
        System.out.println(" |   __         __      |         | Coin |");
        System.out.println(" |  /  \\       /  \\     |  "+ name[2] +" | paid |");
        System.out.println(" | |    |     |    |    |         |______|");
        System.out.println(" |  \\__/       \\__/     |  "+ name[3] +"  |");
        System.out.println(" |                      |         |");
        System.out.println(" |   __         __      |         |  ");
        System.out.println(" |  /  \\       /  \\     |   "+ name[4] +"   |");
        System.out.println(" | |    |     |    |    |         |");
        System.out.println(" |  \\__/       \\__/     | "+ name[5] +" |");
        System.out.println(" | ____________________ | _______ |");
        System.out.println(" |  _______    _____    |  ____   |");
        System.out.println(" | _____    _________   | |____|  |");
        System.out.println("  \\_____________________|________/");
        
            System.out.println();
            System.out.print("Please reenter item: ");
                item = scan.next();
                
             while(choice == false && count < product.length)
            {
                if(item.equals("Refund") || item.equals("refund"))
                {
                    refund();
                }
            
                if((item.toLowerCase()).equals((product[count].getName()).toLowerCase()))
                {
                    choice = true;
                }
            
                count++;
            }
        }
        
        int itemIndex = 0;
        
        for(int i=0;i<product.length;i++)
        {
            if((item.toLowerCase()).equals((product[i].getName()).toLowerCase()))
            {
                product[i].setCount(product[i].getCount()-1);
                itemIndex = i;
                
            }
        }
        
        
            if(product[itemIndex].getCount() >= 0)
            {
                System.out.println("   ______________________________");
        System.out.println("  /  __         __      |        \\");
        System.out.println(" |  /  \\       /  \\     |  "+ name[0] +"   |");
        System.out.println(" | |    |     |    |    |         |");
        System.out.println(" |  \\__/       \\__/     |  "+ name[1] +"  |");
        System.out.println(" |                      |         |______");
        System.out.println(" |   __         __      |         | Coin |");
        System.out.println(" |  /  \\       /  \\     |  "+ name[2] +" | paid |");
        System.out.println(" | |    |     |    |    |         |______|");
        System.out.println(" |  \\__/       \\__/     |  "+ name[3] +"  |");
        System.out.println(" |                      |         |");
        System.out.println(" |   __         __      |         |  ");
        System.out.println(" |  /  \\       /  \\     |   "+ name[4] +"   |");
        System.out.println(" | |    |     |    |    |         |");
        System.out.println(" |  \\__/       \\__/     | "+ name[5] +" |");
        System.out.println(" | ____________________ | _______ |");
        System.out.println(" |  _______    _____    |  ____   |");
        System.out.println(" | _____    _________   | |XXXX|  |");
        System.out.println("  \\_____________________|________/");
                System.out.println();
                System.out.println("Item Dropped: " + item);
                System.out.println();
                System.out.println();
                
                OutofStock = false;
                
                resetMain();
            }
            else
            {
                System.out.println("\nItem Out of Stock\n");
                OutofStock = true;
            }
        }
        
    }
    
    public void refund() throws Exception
    {
        money.refund();
        resetMain();
    }
    
    public void manager() throws Exception
    {
        System.out.println("   ____________________");
        System.out.println("  /                    \\");
        System.out.println(" |       Restock       |");
        System.out.println(" |          or         |");
        System.out.println(" |   Empty Money Box   |");
        System.out.println("  \\____________________/");
        
        System.out.println("");
        
        
        System.out.println("Restock or Empty money box(Enter \"Empty\")?");
                choice = scan.next();
        
        if(choice.equals("Restock"))
        {
            restock();
            resetManager();
        }
        else if(choice.equals("Empty") || choice.equals("empty"))
        {
            profit = empty();
            System.out.println("Profit: $" + profit);
            resetManager();
        }
        else if(choice.equals("exit") || choice.equals("Exit"))
        {
            start();
        }
        
        manager();
    }
    
    public void restock()
    {
        for(int i=0;i<product.length;i++)
        {
            product[i] = new VMProduct(name[i],price1,maxCount);
        }
        
        System.out.println("Restocked");
    }
    
    public double empty()
    {
        profit = money.reset();

        return profit;
    }
    
    public void resetMain() throws Exception
    {
        start();
    }
    
    public void resetManager() throws Exception
    {
        manager();
    }
}
