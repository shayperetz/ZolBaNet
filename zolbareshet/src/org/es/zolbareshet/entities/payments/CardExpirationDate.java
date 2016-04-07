package org.es.zolbareshet.entities.payments;

/**
 * Created by eilons on 3/30/2016.
 */
public class CardExpirationDate {

    private int Day    ;
    private int Month  ;
    private int Year   ;

    public CardExpirationDate () {
    }


    public CardExpirationDate (int day , int month , int year )
    {
        Day = day ;
        Month = month ;
        Year = year  ;
    }

    public int getDay ()
    {
        return Day ;
    }

    public int getMonth ()
    {
        return Month ;
    }

    public int getYear ()
    {
        return Year  ;
    }

    public String getDateToString ()
    {
        char tag = '-' ;
        String BirthDate = "";
        BirthDate = "" + this.Year +  tag + this.Month + tag + this.Day ;
        return BirthDate ;

    }

    public void setDay(int day) {
        Day = day;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public void setYear(int year) {
        Year = year;
    }
}
