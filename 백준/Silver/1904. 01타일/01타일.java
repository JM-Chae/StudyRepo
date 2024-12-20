import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
  {
    static int n;
    static int[] ans;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;

        for (int i = 2; i <= n; i++)
          {
            ans[i] = -1;
          }

        System.out.println(find(n));
      }

    static int find(int i)
      {
        if (ans[i] == -1) ans[i] = (find(i - 1) + find(i - 2)) % 15746;
        return ans[i];
      }
  }