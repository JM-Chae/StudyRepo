import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
  {
    static int count = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        count(n);

        for (int i = 0; i <= n; i++)
          {
            count = Math.min(arr[i] + i, count);
          }

        System.out.print(count > 5000 ? -1 : count);
      }

    static void count(int n)
      {
        for (int i = 0; i <= n; i++)
          {
            int temp = n - 5 * i;

            if (temp < 0)
              {
                arr[i] = Integer.MAX_VALUE - 10000;
                continue;
              }

            arr[i] = temp / 3;
            if (temp % 3 != 0) arr[i] = Integer.MAX_VALUE - 10000;
          }
      }
  }