/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    
   public double accno;
    public double bal;
    
    public void deposit(double damt)
    {
        bal+=damt;
    }
    
    public void withdraw(double wamt)
    {
        if(bal>wamt)
            bal-=wamt;
        else
            System.out.println("Insufficient balance");
    }
    
   public void disp()
    {
         System.out.println("Bal="+bal);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
           int c,i;
           c=0;
        Scanner in = new Scanner(System.in);
        Bank[] b = new Bank[20];
        for(i=0;i<b.length;i++)
        {
            b[i]=new Bank();
        }
        exit:
                      
        while(true)
        {
             System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Transfer 5.Total amount 6.Richst person 7.Exit ");
             System.out.println("\nEnter your choice : ");
             int ch = in.nextInt();
             switch(ch)
             {
                 case 1:{
                            System.out.println("Enter account number : ");
                            int acc = in.nextInt();
                            
                            for(i=0;i<b.length;i++)
                            {
                                if(b[i].accno==acc)
                                {
                                    System.out.println("Account exists ");
                                    break;
                                }
                            }
                                b[c].accno = acc;
                                System.out.println("Enter the initial amount ");
                                b[c].bal = in.nextDouble();
                                c++;
                                break;
                 }
                     
                 case 2:{
                            System.out.println("Enter account number : ");
                            int acc = in.nextInt();
                            System.out.println("Enter the deposit amount : ");
                            double damt = in.nextDouble();
                            for(i=0;i<b.length;i++)
                            {
                                if(b[i].accno==acc)
                                {
                                    b[i].deposit(damt);
                                    b[i].disp();
                                    break;
                                }
                            }
                            if(i==b.length)
                                System.out.println("Account does not exist");
                            break;
                 }
                 case 3:{
                            System.out.println("Enter account number : ");
                            int acc = in.nextInt();
                            System.out.println("Enter the withdrawal amount : ");
                            double wamt = in.nextDouble();
                            
                            for(i=0;i<b.length;i++)
                            {
                                if(b[i].accno==acc)
                                {
                                    b[i].withdraw(wamt);
                                    b[i].disp();
                                    break;
                                }
                            }
                            if(i==b.length)
                                System.out.println("Account does not exist  ");
                                break;
                                
                        }
                 case 4:{
                            System.out.println("Enter the account no. from which you want to transfer : ");
                            int acc1 = in.nextInt();
                            System.out.println("Enter the account no. to which you want to transfer : ");
                            int acc2 = in.nextInt();
                            System.out.println("Enter the transferirng amount : ");
                            double tamt = in.nextDouble();
                            
                            for(i=0;i<b.length;i++)
                            {
                                if(b[i].accno==acc1)
                                {
                                    b[i].withdraw(tamt);
                                    b[i].disp();
                                    break;
                                }
                            }
                            
                            for(i=0;i<b.length;i++)
                            {
                                if(b[i].accno==acc2)
                                {
                                    b[i].deposit(tamt);
                                    b[i].disp();
                                    break;
                                    
                                }
                            }
                            if(i==b.length)
                                System.out.println("Account does not exist ");
                            break;
                 }
                 
                 case 5 : {
                            double totamt =0;
                            for(i=0;i<b.length;i++)
                            {
                                totamt+=b[i].bal;
                            }
                             System.out.println("Total amount in the bank = "+totamt);
                             break;
                             
                 }
                 case 6 : {
                            double largebal=0;
                            int j = 0;
                            for(i=0;i<b.length;i++)
                            {
                                if(b[i].bal>largebal)
                                {
                                    largebal=b[i].bal;
                                    j=i;
                                }
                            }
                            
                             System.out.println("Richest person in the bank is with account number  "+b[j].accno);
                             break;
                 }
                 case 7: break exit;
             }
        }
                 
                 
             
             

        
        
    } 
    

}