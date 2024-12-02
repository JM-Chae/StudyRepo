import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
  {
    static int n;
    static int m;
    static int k;
    static int x;
    static ArrayList<Integer>[] arr;
    static int[] distance;
    static boolean no = false;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        arr = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++)
          {
            distance[i] = -1;
            arr[i] = new ArrayList<>();
          }
        distance[x] = 0;

        for (int i = 1; i <= m; i++)
          {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
          }

        findDistance(x);

        for (int i = 0; i <= n; i++)
          {
            if (distance[i] == k)
              {
                System.out.println(i);
                no = true;
              }
          }

        if (!no)
          {
            System.out.println(-1);
          }
      }

    static void findDistance(int i)
      {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty())
          {
            int curr = q.poll();

            for (int j = 0; j < arr[curr].size(); j++)
              {
                int z = arr[curr].get(j);
                if (distance[z] == -1)
                  {
                    q.add(z);
                    distance[z] = distance[curr] + 1;
                  }
              }
          }
      }
  }