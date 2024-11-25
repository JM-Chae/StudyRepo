import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int mod = 1;
            int h = Math.max(x, y);
            int l = Math.min(x, y);
            while (mod != 0)
              {
                mod = h % l;
                h = l;
                l = mod;
              }

            System.out.println(x * y / h);
          }
      }
  }