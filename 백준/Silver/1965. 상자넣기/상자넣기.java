import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    static int n;
    static int[] m;
    static int[] dp;
    static int ans = 0;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = new int[n + 1];
        dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++)
          {
            m[i] = Integer.parseInt(st.nextToken());
          }

        for (int i = 1; i <= n; i++)
          {
            dp[i] = 1;

            for (int j = 1; j <= i; j++)
              {
                if (m[i] > m[j])
                  {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                  }
              }
            ans = Math.max(ans, dp[i]);
          }

        System.out.println(ans);
      }
  }