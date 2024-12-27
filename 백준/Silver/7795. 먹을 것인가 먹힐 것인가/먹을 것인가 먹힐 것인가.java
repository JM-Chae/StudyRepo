import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int z = 0; z < t; z++)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++)
              {
                a[i] = Integer.parseInt(st.nextToken());
              }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++)
              {
                b[i] = Integer.parseInt(st.nextToken());
              }

            Arrays.sort(a);
            Arrays.sort(b);

            for (int i = 0; i < n; i++)
              {
                count += eat(a[i], b);
              }

            System.out.println(count);
          }
      }

    static int eat(int a, int[] b)
      {
        int s = 0;
        int e = b.length - 1;
        int m;

        while (s < e)
          {
            m = (s + e) / 2;

            if (a <= b[m])
              {
                e = m - 1;
              } else
              {
                s = m + 1;
              }
          }

        return a > b[s] ? s + 1 : s;
      }
  }
