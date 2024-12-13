import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int q = 0; q < t; q++)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] d = new int[m + 1][m + 1];

            for (int i = 1; i <= m; i++)
              {
                d[i][0] = 1;
                d[i][1] = i;
                d[i][i] = 1;
              }

            for (int i = 2; i <= m; i++)
              {
                for (int j = 1; j <= m; j++)
                  {
                    d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
                  }
              }

            System.out.println(d[m][n]);
          }
      }
  }