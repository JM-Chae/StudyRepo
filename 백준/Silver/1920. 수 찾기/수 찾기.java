import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++)
          {
            q.offer(Integer.parseInt(st.nextToken()));
          }

        for (int i = 0; i < n; i++)
          {
            a[i] = q.poll();
          }


        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++)
          {
            b[i] = Integer.parseInt(st.nextToken());
          }

        StringBuilder sb = new StringBuilder();

        a:
        for (int i = 0; i < m; i++)
          {
            int j = 0;
            int k = n - 1;
            int c;

            while (j <= k)
              {
                c = (j + k) / 2;

                if (b[i] > a[c])
                  {
                    j = c + 1;
                  } else if (b[i] < a[c])
                  {
                    k = c - 1;
                  } else
                  {
                    sb.append("1\n");
                    continue a;
                  }
              }

            sb.append("0\n");
          }

        System.out.println(sb);
        br.close();
      }
  }