import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];

        for (int i = 0; i < k; i++)
          {
            arr[i] = Integer.parseInt(br.readLine());
          }

        long max = 0;
        long min = 1;
        long ans = 0;

        for (int i = 0; i < k; i++)
          {
            max = Math.max(max, arr[i]);
          }

        while (min <= max)
          {
            int count = 0;
            long mid = (min + max) / 2;

            for (int i = 0; i < k; i++)
              {
                count += arr[i] / mid;
              }

            if (count >= n)
              {
                ans = mid;
                min = mid + 1;
              } else
              {
                max = mid - 1;
              }
          }

        System.out.println(ans);
      }
  }