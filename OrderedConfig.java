public class OrderedConfig {

  public static String[] orderedConfiguration(String configuration){

    String[] values = configuration.split("\\|");
    String[] result = new String[values.length];

    for (String value : values) {
      int count = Integer.parseInt(value.substring(0, 4).toString());
      result[count-1] = value.substring(5, value.length());
    }

   return result;

  }

  public static void main(String[] args) {
    
    String[] x =orderedConfiguration("0001LAJ5KBX98H|0003UKURNK403F|0002M06K1Z9@FA|00040WRXZFMS2C");
    System.out.println(x);
  }
  
}
