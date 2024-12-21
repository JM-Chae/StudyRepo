import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
  {
    static int n;
    static long[] ans;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int j = 0; j < t; j++)
          {
            n = Integer.parseInt(br.readLine());

            ans = new long[n + 1];
            ans[1] = 1;
            if (n > 1) ans[2] = 1;
            if (n > 2) ans[3] = 1;

            for (int i = 4; i <= n; i++)
              {
                ans[i] = -1;
              }

            System.out.println(find(n));
          }
      }

    static long find(int i)
      {
        if (ans[i] == -1) ans[i] = (find(i - 2) + find(i - 3));
        return ans[i];
      }
  }