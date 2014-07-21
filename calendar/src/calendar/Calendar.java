/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calendar;

/**
 *
 * @author asus
 */
import java.io.*;


public class Calendar {
    static void print_month_v0(int days, int first_day)
{
     int d,i;
     System.out.println(" Sun Mon Tue Wed Thr Fri Sat");
     
     for(i=0;i<first_day;i++)
         System.out.print("   ");
         
     for(d=1;d<=days;d++)
     {
         System.out.printf("%4d",d);
        if((d+first_day)%7==0) System.out.println("");
     }
     
     System.out.println(""); 
     System.out.println(""); 
}
    static int is_leap(int year)    //0 not leap year,1 leap year
{
    if(year%4 !=0)return 0;
    if(year%100 !=0)return 1;
    if(year%400 !=0)return 0;
    return 1;
} 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    throws IOException
    {
          		
        java.util.Scanner scanner = new java.util.Scanner(System.in);
    BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));    
     int year=0,keyInMonth=0; int k;
     int first_day=1; int j;
     int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
     int leap_days[]={31,29,31,30,31,30,31,31,30,31,30,31};
     String month[]={"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
     System.out.println("Please enter a year and a month.");
     String st=keyin.readLine();
     year=Integer.parseInt(st);
     String stt=keyin.readLine();
     keyInMonth=Integer.parseInt(stt);
      //year=scanner.nextInt();
      //keyInMonth=scanner.nextInt();
      
     is_leap(year);
        for(k=1900;k<=(year);k++)//for(k=0;k<(year-1899);k++)
        {
         for(j=0;j<=11;j++)
         {
             if(k==year) //if(k==year-1900) 
             {
                 if(j==(keyInMonth-1))
                 {
                 System.out.printf("\n");
                 System.out.printf(" %s",month[j]);
                 System.out.printf("\n");
                 if (is_leap(year)==1) 
                 print_month_v0(leap_days[j],first_day);
                 else 
                 print_month_v0(days[j],first_day);
                 }
                 
             } 
             if (is_leap(k)==1) //if (is_leap(k+1900)==1) 
             first_day=(first_day+leap_days[j])%7; 
             else 
             first_day=(first_day+days[j])%7;     
         }
       }
    
    }
    }
    
       
       
        
  
  
  
 
  
 
 

