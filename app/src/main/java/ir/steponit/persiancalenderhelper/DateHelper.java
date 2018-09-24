package ir.steponit.persiancalenderhelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Amirreza Erfanian on 30/12/2017.
 * A.E
 * version = 3
 */

public class DateHelper {

  private class SolarCalendar {

    public String strWeekDay = "";
    public String strMonth   = "";

    int           date;
    int           month;
    int           year;

    public SolarCalendar()
    {
      Date MiladiDate = new Date();
      calcSolarCalendar(MiladiDate);
    }

    public SolarCalendar(Date MiladiDate)
    {
      calcSolarCalendar(MiladiDate);
    }

    private void calcSolarCalendar(Date MiladiDate) {

      int ld;

      int miladiYear = MiladiDate.getYear() + 1900;
      int miladiMonth = MiladiDate.getMonth() + 1;
      int miladiDate = MiladiDate.getDate();
      int WeekDay = MiladiDate.getDay();

      int[] buf1 = new int[12];
      int[] buf2 = new int[12];

      buf1[0] = 0;
      buf1[1] = 31;
      buf1[2] = 59;
      buf1[3] = 90;
      buf1[4] = 120;
      buf1[5] = 151;
      buf1[6] = 181;
      buf1[7] = 212;
      buf1[8] = 243;
      buf1[9] = 273;
      buf1[10] = 304;
      buf1[11] = 334;

      buf2[0] = 0;
      buf2[1] = 31;
      buf2[2] = 60;
      buf2[3] = 91;
      buf2[4] = 121;
      buf2[5] = 152;
      buf2[6] = 182;
      buf2[7] = 213;
      buf2[8] = 244;
      buf2[9] = 274;
      buf2[10] = 305;
      buf2[11] = 335;

      if ((miladiYear % 4) != 0) {
        date = buf1[miladiMonth - 1] + miladiDate;

        if (date > 79) {
          date = date - 79;
          if (date <= 186) {
            switch (date % 31) {
              case 0:
                month = date / 31;
                date = 31;
                break;
              default:
                month = (date / 31) + 1;
                date = (date % 31);
                break;
            }
            year = miladiYear - 621;
          } else {
            date = date - 186;

            switch (date % 30) {
              case 0:
                month = (date / 30) + 6;
                date = 30;
                break;
              default:
                month = (date / 30) + 7;
                date = (date % 30);
                break;
            }
            year = miladiYear - 621;
          }
        } else {
          if ((miladiYear > 1996) && (miladiYear % 4) == 1) {
            ld = 11;
          } else {
            ld = 10;
          }
          date = date + ld;

          switch (date % 30) {
            case 0:
              month = (date / 30) + 9;
              date = 30;
              break;
            default:
              month = (date / 30) + 10;
              date = (date % 30);
              break;
          }
          year = miladiYear - 622;
        }
      } else {
        date = buf2[miladiMonth - 1] + miladiDate;

        if (miladiYear >= 1996) {
          ld = 79;
        } else {
          ld = 80;
        }
        if (date > ld) {
          date = date - ld;

          if (date <= 186) {
            switch (date % 31) {
              case 0:
                month = (date / 31);
                date = 31;
                break;
              default:
                month = (date / 31) + 1;
                date = (date % 31);
                break;
            }
            year = miladiYear - 621;
          } else {
            date = date - 186;

            switch (date % 30) {
              case 0:
                month = (date / 30) + 6;
                date = 30;
                break;
              default:
                month = (date / 30) + 7;
                date = (date % 30);
                break;
            }
            year = miladiYear - 621;
          }
        }

        else {
          date = date + 10;

          switch (date % 30) {
            case 0:
              month = (date / 30) + 9;
              date = 30;
              break;
            default:
              month = (date / 30) + 10;
              date = (date % 30);
              break;
          }
          year = miladiYear - 622;
        }

      }

      switch (month) {
        case 1:
          strMonth = "فروردين";
          break;
        case 2:
          strMonth = "ارديبهشت";
          break;
        case 3:
          strMonth = "خرداد";
          break;
        case 4:
          strMonth = "تير";
          break;
        case 5:
          strMonth = "مرداد";
          break;
        case 6:
          strMonth = "شهريور";
          break;
        case 7:
          strMonth = "مهر";
          break;
        case 8:
          strMonth = "آبان";
          break;
        case 9:
          strMonth = "آذر";
          break;
        case 10:
          strMonth = "دي";
          break;
        case 11:
          strMonth = "بهمن";
          break;
        case 12:
          strMonth = "اسفند";
          break;
      }
      switch (WeekDay) {

        case 0:
          strWeekDay = "يکشنبه";
          break;
        case 1:
          strWeekDay = "دوشنبه";
          break;
        case 2:
          strWeekDay = "سه شنبه";
          break;
        case 3:
          strWeekDay = "چهارشنبه";
          break;
        case 4:
          strWeekDay = "پنج شنبه";
          break;
        case 5:
          strWeekDay = "جمعه";
          break;
        case 6:
          strWeekDay = "شنبه";
          break;
      }

    }

    public int getDate() {
      return date;
    }

    public int getMonth() {
      return month;
    }
  }

  public static YearMonthDate getCurrentJalaliDate() {
    Locale loc = new Locale("en_US");
    DateHelper util = new DateHelper();
    SolarCalendar sc = util.new SolarCalendar();
    Date d = new Date();
    return new YearMonthDate(sc.year,sc.month,sc.strMonth,sc.date,sc.strWeekDay,d.getHours(),d.getMinutes(),d.getSeconds());
  }

  public static Date getCurrentGregorianDate(){
    Date date = new Date();
    return date;
  }

  public static YearMonthDate gregorianToJalali(Date date) {
    DateHelper util = new DateHelper();
    SolarCalendar sc = util.new SolarCalendar(date);
    return new YearMonthDate(sc.year,sc.month,sc.strMonth,sc.date,sc.strWeekDay,date.getHours(),date.getMinutes(),date.getSeconds());
  }

  public static Date jalaliToGregorian(YearMonthDate jDate){
    int countKYears = (jDate.getYear()-1348)/4;
    int countAllYears = jDate.getYear()-1348-1;
    int countNYears = countAllYears-countKYears;

    long lastSecond1348 = 6739200;
    long secondNYear = 31536000;
    long secondKYear = 31622400;
    long secondM31 = 2678400;
    long secondM30 = 2592000;
    long aHour = 3600000;
    long secondCurrentYear;
    long secondCurrentMonth;

    secondCurrentMonth = jDate.getDate()*86400;
    int lastCompMonth = jDate.getMonth()-1;
    if(lastCompMonth<6){
      secondCurrentYear = (secondM31*lastCompMonth) + secondCurrentMonth;
    }else{
      secondCurrentYear = (secondM31*6)+(secondM30*(lastCompMonth-6)) + secondCurrentMonth;
    }
    long second  = (secondKYear*countKYears)+(secondNYear*countNYears)+lastSecond1348+secondCurrentYear;

    //12600 is GMT+3:30
    second = second + (jDate.getHour()*3600)+(jDate.getMinutes()*60)+jDate.getSecond()-12600;
    second *= 1000;

    //To calculate the clock change in the first six months of the year
    if(lastCompMonth<6 && !(lastCompMonth==5 && jDate.getDate()==31) && !(lastCompMonth==0 && jDate.getDate()==1)){
      second -= aHour;
    }

    Date date = new Date(second);
    return date;
  }


  public static ArrayList<Date> listOfDatesBetween(Date date1, Date date2){
    ArrayList<Date> dates = new ArrayList<>();
    long lengthOfDay = 86400000;
    for (long i=date1.getTime();i<=date2.getTime();i=i+lengthOfDay)
      dates.add(new Date(i));
    return dates;
  }

  public static ArrayList<Date> listOfDatesBetween(Date date, int afterDate){
    ArrayList<Date> dates = new ArrayList<>();
    long lengthOfDay = 86400000;
    for (long i=0;i<afterDate;i++)
      dates.add(new Date(date.getTime()+(lengthOfDay*i)));
    return dates;
  }

  public static ArrayList<Date> listOfDatesBetween(int beforeDate,Date date){
    ArrayList<Date> dates = new ArrayList<>();
    long lengthOfDay = 86400000;
    for (long i=beforeDate;i>=0;i--)
      dates.add(new Date(date.getTime()-(lengthOfDay*i)));
    return dates;
  }

  public static Date getBeforeDays(int count){
    Date date = new Date();
    long x = date.getTime();
    date.setTime(x-(86400000l*count));
    return date;
  }

  public static Date getAfterDays(int count){
    Date date = new Date();
    long x = date.getTime();
    date.setTime(x+(86400000l*count));
    return date;
  }

  public static Date getAfterDays(Date date,int count){
    long x = date.getTime();
    Date date1 = new Date();
    date1.setTime(x+(86400000l*count));
    return date1;
  }

  public static Date parseFormat(String date,String format) throws Exception {
    try {
      DateFormat f;
      if(format==null){
        f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
      }else{
        f = new SimpleDateFormat(format);
      }
      Date d = null;
      f.setTimeZone(TimeZone.getTimeZone("GMT"));
      d = f.parse(date);
      DateFormat time = new SimpleDateFormat("HH:mm:ss");
      time.format(d);
      return d;
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String strPersianDate(Date date){
    DateHelper util = new DateHelper();
    SolarCalendar sc = util.new SolarCalendar(date);
    String middle = ((date.getHours()>12&&date.getHours()<24)?"بعد از ظهر":"صبح");
    return String.format(new Locale("en_US"),"%s %s %02d %s ساعت %02d:%02d",middle,sc.strWeekDay,sc.date,sc.strMonth,date.getHours(),date.getMinutes());
  }

  /**
   * jalali date input
   * @param date intput type 1373/02/09
   * @param time intput type 12:16:12
   * @return
   */
  public static Date parseDate(String date ,String time) throws Exception{

    String[] date1 = date.split("/");
    String[] time1 = time.split(":");

    Date d = DateHelper.jalaliToGregorian(new YearMonthDate(
            Integer.parseInt(date1[0])
            ,Integer.parseInt(date1[1])
            ,Integer.parseInt(date1[2])
            ,Integer.parseInt(time1[0])
            ,Integer.parseInt(time1[1])
            ,Integer.parseInt(time1[2])));
    return d;
  }

  public static Date parseDate(String time) throws Exception{

    String[] time1 = time.split(":");

    Date d = DateHelper.jalaliToGregorian(new YearMonthDate(
            getCurrentJalaliDate().getYear()
            ,getCurrentJalaliDate().getMonth()
            ,getCurrentJalaliDate().getDate()
            ,Integer.parseInt(time1[0])
            ,Integer.parseInt(time1[1])
            ,Integer.parseInt(time1[2])));
    return d;
  }

}
