/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsproject;

/**
 *
 * @author Mr Saurav
 */
public class Calculations {
    boolean checkNameStrength(String s){
        String s1 = "~!@#$%^&*()"; 
        String s2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s3 = "abcdefghijklmnopqrstuvwxyz";
        String s4 = "1234567890";

        String aa = s.substring(0,0);
        if(s.indexOf(aa)!=0){
            return false;
        }

        int flag1=0, flag2=0, flag3=0, flag4=0;

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            if(s.indexOf(ch)>=0){
                flag1=1;
            }
        }
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(s.indexOf(ch)>=0){
                flag2=1;
            }
        }
        for(int i=0;i<s3.length();i++){
            char ch = s3.charAt(i);
            if(s.indexOf(ch)>=0){
                flag3=1;
            }
        }
        for(int i=0;i<s4.length();i++){
            char ch = s4.charAt(i);
            if(s.indexOf(ch)>=0){
                flag4=1;
            }
        }
        if(flag1==0 && flag2==1 && flag3==1 && flag4==0){
            return true;
        } else {
            return false;
        }
    }
    boolean checkEmailStrength(String s){
        int a = s.indexOf("@");
        int b = s.indexOf(".");
        int c = s.indexOf(" ");


        if(a == -1 || b == -1 || c >= 0 || a==0 || b == 0){
            return false;
        }
        int i = s.indexOf("gmail.com");

        if(b-a > 1 && i != -1){
            return true;
        } else {
            return false;
        }
    }
    boolean checkPasswordStrength(String s){
        String s1 = "~!@#$%^&*()"; 
        String s2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s3 = "abcdefghijklmnopqrstuvwxyz";
        String s4 = "1234567890";

        int flag1=0, flag2=0, flag3=0, flag4=0;

        int a = s.indexOf(" ");
        if(a >= 0){
            return false;
        }

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            if(s.indexOf(ch)>=0){
                flag1=1;
            }
        }
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(s.indexOf(ch)>=0){
                flag2=1;
            }
        }
        for(int i=0;i<s3.length();i++){
            char ch = s3.charAt(i);
            if(s.indexOf(ch)>=0){
                flag3=1;
            }
        }
        for(int i=0;i<s4.length();i++){
            char ch = s4.charAt(i);
            if(s.indexOf(ch)>=0){
                flag4=1;
            }
        }
        if(flag1==1 && flag2==1 && flag3==1 && flag4==1){
            return true;
        } else {
            return false;
        }
    } 
    boolean checkInteger(String s){
        String s1 = "1234567890";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(s1.indexOf(ch)<0){
                return false;
            }
        }
        return true;
    }
    static int calcutateDateOfSameYear(int m1, int d1, int m2, int d2, int y){
        int day=0, mday=0, yday=0, totalDay=0;
        if(m1==m2){
            totalDay=d2-d1+1;
            return totalDay;
        }
        switch(m1){
            case 1:
                day=31+1-d1;
                break;
            case 2:
                if(y%4==0){
                    day = 29+1-d1;
                } else {
                    day=28+1-d1;
                }
                break;
            case 3:
                day=31+1-d1;
                break;
            case 4:
                day=30+1-d1;
                break;
            case 5:
                day=31+1-d1;
                break;
            case 6:
                day=30+1-d1;
                break;
            case 7:
                day=31+1-d1;
                break;
            case 8:
                day=31+1-d1;
                break;
            case 9:
                day=30+1-d1;
                break;
            case 10:
                day=31+1-d1;
                break;
            case 11:
                day=30+1-d1;
                break;
            case 12:
                day=31+1-d1;
        }
        for(int i=m1+1;i<m2;i++){
            switch(i){
                case 1:
                    mday+=31;
                    break;
                case 2:
                    if(y%4==0){
                        mday+=29;
                    } else{
                        mday+=28;
                    }
                    break;
                case 3:
                    mday+=31;
                    break;
                case 4:
                    mday+=30;
                    break;
                case 5:
                    mday+=31;
                    break;
                case 6:
                    mday+=30;
                    break;
                case 7:
                    mday+=31;
                    break;
                case 8:
                    mday+=31;
                    break;
                case 9:
                    mday+=30;
                    break;
                case 10:
                    mday+=31;
                    break;
                case 11:
                    mday+=30;
                    break;
                case 12:
                    mday+=31;
            }
        }
        totalDay = day+mday+d2;
        return totalDay;
    }
    int calcutateDate(String from, String to){
        int totalDaySum=0, yDay=0;
        
        int y1 = Integer.parseInt(from.substring(0,4));
        int m1 = Integer.parseInt(from.substring(5,7));
        int d1 = Integer.parseInt(from.substring(8,10));

        int y2 = Integer.parseInt(to.substring(0,4));
        int m2 = Integer.parseInt(to.substring(5,7));
        int d2 = Integer.parseInt(to.substring(8,10));

        for(int i=y1+1;i<y2;i++){
            if(i%4==0){
                yDay+=366;
            } else {
                yDay+=365;
            }
        }
        if(y1!=y2){
            totalDaySum += calcutateDateOfSameYear(m1, d1, 12, 31, y1);
            totalDaySum += yDay;
            totalDaySum += calcutateDateOfSameYear(01, 01, m2, d2, y2);
        } else {
            totalDaySum += calcutateDateOfSameYear(m1, d1, m2, d2, y2);
        }

        return totalDaySum;
    }
    public static void main(String[] args) {
        Calculations c = new Calculations();
        boolean s = c.checkEmailStrength("saurav@gmail.com");
        System.out.println(s);
    }
}
