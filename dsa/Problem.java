import java.util.TreeSet;

public class Problem {
   public static void main(String[] args) {
      int[] arr = {3, 5, 2, 5, 6, 6, 1};

      TreeSet<Integer> st = new TreeSet<>();

      for(int num:arr){
         st.add(num);
      }

      if(st.size() > 2 ){
         st.pollLast();
         System.out.println("Second Largest Value: " + st.last());
      }else{
         System.out.println("-1"); 
      }
   }
}