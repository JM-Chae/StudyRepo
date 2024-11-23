import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++)
          {
            a[i] = Integer.parseInt(br.readLine());
          }

        int sum = 0;
        int i = n - 1;

        while (m != 0)
          {
            if (a[i] > m)
              {
                i--;
              } else
              {
                sum += m / a[i];
                m = m % a[i];
                i--;
              }
          }

        System.out.println(sum);
        br.close();
      }
  }