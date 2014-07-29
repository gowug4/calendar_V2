/*******************************************************************
    FileName    [ Calendar.java ]
    PackageName [ calendar ]
    JavaProjectName  [ Calendar ]
    Synopsis   
    [
        1.Check leap year.
        2.Check days in a month.
        3.Check what day is that day.
        4.Find a whole month.
        5.Check holidays.
    ]
    Author      [ Chi-Hsuan Hsu ]
    Copyright   [ Copyleft(c) 2014 MITLAB, GIEE, NTUST, Taiwan ]   
*********************************************************************/
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

    static void print_month_v0(int days, int first_day) {                        // 將日曆印出來
        int d, i;
        System.out.println(" Sun Mon Tue Wed Thr Fri Sat");

        for (i = 0; i < first_day; i++) {
            System.out.print("   ");
        }

        for (d = 1; d <= days; d++) {
            System.out.printf("%4d", d);
            if ((d + first_day) % 7 == 0) {
                System.out.println("");
            }
        }

        System.out.println("");
        System.out.println("");
    }

    static int is_leap(int year)                                                  //0 not leap year,1 leap year
    {
        if (year % 4 != 0) {
            return 0;
        }
        if (year % 100 != 0) {
            return 1;
        }
        if (year % 400 != 0) {
            return 0;
        }
        return 1;
    }

    static void Check_leap_year()throws IOException                              //判斷閏年
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        int year=0; int i=1;
         System.out.println(" Please enter a year.");
        while(i==1)                                                             //防呆
        {
            String yea = keyin.readLine();
            year = Integer.parseInt(yea);
            if(year>1899)
                break;
            else 
                System.out.println("Please enter a year.");
        }        
        if (is_leap(year) == 1) 
            System.out.println(year + " is a leap year.");
        else 
            System.out.println(year + " is not a leap year.");
    }

    static void Check_days() throws IOException                                 //判斷一個月有幾天
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        int year=0; int Keyinmonth = 0; int i=1;
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int leap_days[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String month[] = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.println(" Please enter a year and a month.");
        while(i==1)                                                             //防呆
        {
            String yea = keyin.readLine();
            year = Integer.parseInt(yea);
            String mon = keyin.readLine();
            Keyinmonth = Integer.parseInt(mon);
            if(year>1899 && Keyinmonth<13 && Keyinmonth>0 )
                break;
            else 
                System.out.println("Please enter a year and a month.");
        }
        if (is_leap(year) == 1) {
            System.out.println("In " + year + " there is " + leap_days[Keyinmonth - 1] + " days in " + month[Keyinmonth - 1]);
        } else {
            System.out.println("In " + year + " there is " + days[Keyinmonth - 1] + " days in " + month[Keyinmonth - 1]);
        }
    }

    static void Check_what_day() throws IOException                             //找星期幾
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        int year=0; int Keyinmonth = 0; int date=0; int i=1;
        int k; int j; int first_day = 1;
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int leap_days[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String month[] = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.println(" Please enter a year and a month and a date.");
        while(i==1)                                                             //防呆
        {
            String yea = keyin.readLine();
            year = Integer.parseInt(yea);
            String mon = keyin.readLine();
            Keyinmonth = Integer.parseInt(mon);
            String dayy = keyin.readLine();
            date = Integer.parseInt(dayy);
        if(is_leap(year)==1)
            if(year>1899 && Keyinmonth<13 && Keyinmonth>0 && date <=leap_days[Keyinmonth-1] && date > 0)
                break;
            else 
                System.out.println("Please enter a year and a month and a date.");
        else
            if(year>1899 && Keyinmonth<13 && Keyinmonth>0 && date <=days[Keyinmonth-1] && date > 0 )
                break;
            else 
                System.out.println("Please enter a year and a month and a date.");
        }
        String week[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (k = 1900; k <= (year); k++) 
        {
            for (j = 0; j <= 11; j++) 
            {
                if (k == year) {
                    if (j == (Keyinmonth - 1)) 
                    {
                        System.out.printf(" " + month[j] + " " + date + " is on " + week[(date-1 + first_day) % 7] + " in " + year);
                        System.out.printf("\n");
                    }
                }
                if (is_leap(k) == 1)                                              //算出First_day
                {
                    first_day = (first_day + leap_days[j]) % 7;
                } 
                else 
                {
                    first_day = (first_day + days[j]) % 7;
                }

            }
        }
    }
    static void Find_Month() throws IOException
    {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
     BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));    
     int year=0,Keyinmonth=0; int k; int i=1;
     int first_day=1; int j;
     int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
     int leap_days[]={31,29,31,30,31,30,31,31,30,31,30,31};
     String month[]={"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
     System.out.println(" Please enter a year and a month.");
        while(i ==1)
        {
            String yea = keyin.readLine();
            year = Integer.parseInt(yea);
            String mon = keyin.readLine();
            Keyinmonth = Integer.parseInt(mon);
            if(year>1899 && Keyinmonth<13 && Keyinmonth>0 )
            break;
            else 
            System.out.println("Please enter a year and a month.");
        }
        is_leap(year);
        for(k=1900;k<=(year);k++)
        {
         for(j=0;j<=11;j++)
         {
             if(k==year) 
             {
                 if(j==(Keyinmonth-1))
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
             if (is_leap(k)==1)
                first_day=(first_day+leap_days[j])%7; 
             else 
                first_day=(first_day+days[j])%7;     
         }
       }
    }
    static void Check_holiday() throws IOException
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        int year=0; int i=1; int first_day = 1 ; int k; int j;
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int leap_days[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println(" Please enter a year.");
        while(i==1)
        {
            String yea = keyin.readLine();
            year = Integer.parseInt(yea);
            if(year>1899)
            break;
            else 
            System.out.println("Please enter a year.");
        }
        for (k = 1900; k <= (year); k++) {
            for (j = 0; j <= 11; j++) {
                if (k == year) 
                {
                    if (j == 0) 
                    {
                        if (is_leap(year) == 1) 
                        {
                            switch (first_day) 
                            {
                                case (0):
                                    System.out.println(" There are " + 105 + " holidays in this year.");
                                    break;
                                case (5):
                                    System.out.println(" There are " + 105 + " holidays in this year.");
                                    break;
                                case (6):
                                    System.out.println(" There are " + 106 + " holidays in this year.");
                                    break;
                                default:
                                    System.out.println(" There are " + 104 + " holidays in this year.");
                                    break;
                            }
                        }
                        if (is_leap(year) == 0) 
                        {
                            switch (first_day) 
                            {
                                case (0):
                                    System.out.println(" There are " + 105 + " holidays in this year.");
                                    break;
                                case (6):
                                    System.out.println(" There are " + 105 + " holidays in this year.");
                                    break;
                                default:
                                    System.out.println(" There are " + 104 + " holidays in this year.");
                                    break;
                            }
                        }
                    }
                }
                if (is_leap(k) == 1) 
                {
                    first_day = (first_day + leap_days[j]) % 7;
                } 
                else 
                {
                    first_day = (first_day + days[j]) % 7;
                }

            }
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
        throws IOException 
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        int i = 1;
        int choice;
        int did = 0;
        System.out.println("Please enter your choice.");
        System.out.println(" 1.Is this year a leap year? ");
        System.out.println(" 2.How many days in this month? ");
        System.out.println(" 3.See what day is this day. ");
        System.out.println(" 4.Find a whole month. ");
        System.out.println(" 5.Check how many holidays in this year. ");
        while(i==1)        
        {
        String cho = keyin.readLine();                                          //選項
        choice = Integer.parseInt(cho);         
        if(choice>0 && choice<6)                                                //防呆
            switch(choice)
            {
                case(1):
                Check_leap_year();
                System.out.println(" ");
                System.out.println("Do you want to continue?");
                System.out.println(" 0. Yes");
                System.out.println("Else No");
                String d = keyin.readLine();
                did = Integer.parseInt(d);
                if(did!=0)
                {
                    i++;
                    break;
                }
                else
                {
                    System.out.println("Please enter your choice.");
                    System.out.println(" 1.Is this year a leap year? ");
                    System.out.println(" 2.How many days in this month? ");
                    System.out.println(" 3.See what day is this day. ");
                    System.out.println(" 4.Find a whole month. ");
                    System.out.println(" 5.Check how many holidays in this year. ");
                }
                break;
                case(2):        
                Check_days();
                System.out.println(" ");
                System.out.println("Do you want to continue?");
                System.out.println(" 0. Yes");
                System.out.println("Else No");
                String e = keyin.readLine();
                did = Integer.parseInt(e);
                if(did!=0)
                {
                    i++;
                    break;
                }
                else
                {
                    System.out.println("Please enter your choice.");
                    System.out.println(" 1.Is this year a leap year? ");
                    System.out.println(" 2.How many days in this month? ");
                    System.out.println(" 3.See what day is this day. ");
                    System.out.println(" 4.Find a whole month. ");
                    System.out.println(" 5.Check how many holidays in this year. ");
                }
                break;
                case(3):
                Check_what_day();
                System.out.println(" ");
                System.out.println("Do you want to continue?");
                System.out.println(" 0. Yes");
                System.out.println("Else No");
                String f = keyin.readLine();
                did = Integer.parseInt(f);
                if(did!=0)
                {
                    i++;
                    break;
                }
                else
                {
                    System.out.println("Please enter your choice.");
                    System.out.println(" 1.Is this year a leap year? ");
                    System.out.println(" 2.How many days in this month? ");
                    System.out.println(" 3.See what day is this day. ");
                    System.out.println(" 4.Find a whole month. ");
                    System.out.println(" 5.Check how many holidays in this year. ");
                }
                break;
                case(4):
                Find_Month();
                System.out.println(" ");
                System.out.println("Do you want to continue?");
                System.out.println(" 0. Yes");
                System.out.println("Else No");
                String g = keyin.readLine();
                did = Integer.parseInt(g);
                if(did!=0)
                {
                    i++;
                    break;
                }
                else
                {
                    System.out.println("Please enter your choice.");
                    System.out.println(" 1.Is this year a leap year? ");
                    System.out.println(" 2.How many days in this month? ");
                    System.out.println(" 3.See what day is this day. ");
                    System.out.println(" 4.Find a whole month. ");
                    System.out.println(" 5.Check how many holidays in this year. ");
                }
                break;
                case(5):
                Check_holiday();
                System.out.println(" ");
                System.out.println("Do you want to continue?");
                System.out.println(" 0. Yes");
                System.out.println("Else No");
                String h = keyin.readLine();
                did = Integer.parseInt(h);
                if(did!=0)
                {
                    i++;
                    break;
                }
                else
                {
                    System.out.println("Please enter your choice.");
                    System.out.println(" 1.Is this year a leap year? ");
                    System.out.println(" 2.How many days in this month? ");
                    System.out.println(" 3.See what day is this day. ");
                    System.out.println(" 4.Find a whole month. ");
                    System.out.println(" 5.Check how many holidays in this year. ");
                }
                break;    
                default : 
                System.out.println("error");
                break;
            }
            else
            {
                System.out.println("Please make sure your choice.");
                System.out.println(" 1.Is this year a leap year? ");
                System.out.println(" 2.How many days in this month? ");
                System.out.println(" 3.See what day is this day. ");
                System.out.println(" 4.Find a whole month. ");
                System.out.println(" 5.Check how many holidays in this year. ");
            }
        }
    } 
}
