import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        String[] str = s.split("-");

        int[] a = new int[str.length];

        for (int i = 0; i < str.length; i++)
          {
            if (str[i].contains("+"))
              {
                int temp = Arrays.stream(str[i].split("\\+")).mapToInt(s1 -> Integer.parseInt(s1)).sum();
                str[i] = String.valueOf(temp);
              }
            a[i] = Integer.parseInt(str[i]);
          }

        int sum = a[0];

        for (int i = 1; i < a.length; i++)
          {
            sum -= a[i];
          }

        System.out.println(sum);
        br.close();
      }
  }