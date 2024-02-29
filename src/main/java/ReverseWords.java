public class ReverseWords {
    public static void main(String[] args) {
        String str = "My name is Java";
        
      StringBuilder sb=new StringBuilder(str);
      sb.reverse();
      System.out.println(sb);
    }
}
