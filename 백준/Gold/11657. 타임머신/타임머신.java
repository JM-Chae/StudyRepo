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
    static List<Integer[]> arr;
    static long[] distance;
    static boolean negative = false;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new long[n + 1];
        arr = new ArrayList<>();

        for (int i = 0; i <= n; i++)
          {
            if (i == 1)
              {
                distance[i] = 0;
              } else
              {
                distance[i] = Integer.MAX_VALUE;
              }
          }


        for (int i = 1; i <= m; i++)
          {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.add(new Integer[]{a, b, c});
          }

        findDistance();

        if (negative)
          {
            System.out.println(-1);
          } else
          {

            for (int i = 2; i <= n; i++)
              {
                if (distance[i] == Integer.MAX_VALUE)
                  {
                    System.out.println(-1);
                  } else
                  {
                    System.out.println(distance[i]);
                  }
              }
          }
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