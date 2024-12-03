import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
          {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
              {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) arr[i][j] = temp;
                else arr[i][j] = 300;
              }
          }

        for (int i = 1; i <= n; i++)
          {
            for (int j = 1; j <= n; j++)
              {
                for (int k = 1; k <= n; k++)
                  {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                  }
              }
          }

        for (int i = 1; i <= n; i++)
          {
            for (int j = 1; j <= n; j++)
              {
                int temp = arr[i][j];
                if (temp == 300) System.out.print("0 ");
                else System.out.print("1 ");
              }
            System.out.println();
          }
      }
  }