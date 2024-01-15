public class ReverseString {
  
public static String revString(String str) {
   if(str.length() == 1) {
   return str;
  }
  char currChar = str.charAt(0);
  String nextString = revString(str.substring(1));
  return nextString + currChar;
 }
  
public static void main(String args[]) {

   String str = "abcd";
   String reversed = revString(str);
   System.out.println(reversed);
  }
}
