package day1;
import java.util.List;

class TimeConversion {

  public static void doTimeConversion(String s) {
    String morningOrAfternoon = s.substring(s.length() - 2);

    String time = s.substring(0, s.length() - 2);
    String hours = time.substring(0, 2);
    String rest = time.substring(2, time.length());

    if (morningOrAfternoon.equalsIgnoreCase("AM") && hours.equals("12")) {
      time = "00" + rest;
    } else if (morningOrAfternoon.equalsIgnoreCase("PM") && hours.equals("12")) {
      time = "12" + rest;
    } else if (morningOrAfternoon.equalsIgnoreCase("PM")) {
      time = Integer.toString(Integer.valueOf(hours) + 12) + rest;
    }

    System.out.println(time);

  }

  public static void main(String[] args) {
    doTimeConversion("07:01:40AM");
  }

}