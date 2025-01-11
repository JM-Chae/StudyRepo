import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    static int max;
    static int[] arr;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int sum = 0;
        int maxValue = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
          {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            maxValue = Math.max(maxValue, arr[i]);
          }

        max = Integer.parseInt(br.readLine());

        if (sum <= max)
          {
            System.out.println(maxValue);
          } else find(1, maxValue);
      }

    static void find(int s, int e)
      {
        int m = (s + e) / 2;
        long maxTemp = max;

        for (int i = 0; i < arr.length; i++)
          {
            if (arr[i] < m)
              {
                maxTemp = maxTemp - arr[i];
              } else
              {
                maxTemp = maxTemp - m;
              }
          }

        if (maxTemp == 0)
          {
            System.out.println(m);
            return;
          }

        if (s > e)
          {
            System.out.println(m);
          } else if (maxTemp > 0)
          {
            find(m + 1, e);
          } else
          {
            find(s, m - 1);
          }
      }
  }