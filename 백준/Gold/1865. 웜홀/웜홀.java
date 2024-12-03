import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main
  {
    static int n;
    static int m;
    static int w;
    static List<Integer[]> arr;
    static long[] distance;
    static boolean negative;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++)
          {
            st = new StringTokenizer(br.readLine());
            negative = false;

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            distance = new long[n + 1];
            arr = new ArrayList<>();

            for (int j = 0; j <= n; j++)
              {
                if (j == 1)
                  {
                    distance[i] = 0;
                  } else
                  {
                    distance[i] = Integer.MAX_VALUE;
                  }
              }


            for (int j = 1; j <= m; j++)
              {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr.add(new Integer[]{b, a, c});
                arr.add(new Integer[]{a, b, c});
              }

            for (int j = 1; j <= w; j++)
              {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr.add(new Integer[]{a, b, -c});
              }

            findDistance();

            if (negative)
              {
                sb.append("YES\n");
              } else
              {
                sb.append("NO\n");
              }
          }

        System.out.println(sb);
        br.close();
      }

    static void findDistance()
      {
        for (int j = 1; j < n; j++)
          {
            for (int i = 0; i < arr.size(); i++)
              {
                int start = arr.get(i)[0];
                int end = arr.get(i)[1];
                int cost = arr.get(i)[2];

                if (distance[start] == Integer.MAX_VALUE) continue;

                if (distance[end] > distance[start] + cost)
                  {
                    distance[end] = distance[start] + cost;
                  }
              }
          }

        for (int i = 0; i < arr.size(); i++)
          {
            int start = arr.get(i)[0];
            int end = arr.get(i)[1];
            int cost = arr.get(i)[2];

            if (distance[start] == Integer.MAX_VALUE) continue;

            if (distance[end] > distance[start] + cost)
              {
                negative = true;
              }
          }
      }
  }