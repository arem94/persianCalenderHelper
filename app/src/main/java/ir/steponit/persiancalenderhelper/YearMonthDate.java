package ir.steponit.persiancalenderhelper;


public class YearMonthDate {

  public YearMonthDate(int year, int month, int date) {
    this.year = year;
    this.month = month;
    this.date = date;
    hour=0;
    Minutes=0;
    Second=0;
  }


  public YearMonthDate(int year, int month, String monthText, int date, String weekText, int hour, int minutes, int second) {
    this.year = year;
    this.month = month;
    this.monthText = monthText;
    this.date = date;
    this.weekText = weekText;
    this.hour = hour;
    Minutes = minutes;
    Second = second;
  }

  public YearMonthDate(int year, int month, int date, int hour, int minutes, int second) {
    this.year = year;
    this.month = month;
    this.date = date;
    this.hour = hour;
    Minutes = minutes;
    Second = second;
  }

  private int year;
  private int month;
  private String monthText;
  private int date;
  private String weekText;
  private int hour;
  private int Minutes;
  private int Second;

  public String getMonthText() {
    return monthText;
  }

  public void setMonthText(String monthText) {
    this.monthText = monthText;
  }

  public String getWeekText() {
    return weekText;
  }

  public void setWeekText(String weekText) {
    this.weekText = weekText;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinutes() {
    return Minutes;
  }

  public void setMinutes(int minutes) {
    Minutes = minutes;
  }

  public int getSecond() {
    return Second;
  }

  public void setSecond(int second) {
    Second = second;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public String toString() {
    return getYear() + "/" + getMonth() + "/" + getDate();
  }
}
