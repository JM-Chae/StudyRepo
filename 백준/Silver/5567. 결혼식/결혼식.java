import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
  {
    static ArrayList<Integer>[] friendMap;
    static boolean[] visited;
    static int[] rank;
    static int count = -1;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        friendMap = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++)
          {
            friendMap[i] = new ArrayList<>();
            rank[i] = 0;
          }

        for (int i = 1; i <= m; i++)
          {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friendMap[a].add(b);
            friendMap[b].add(a);
          }

        counting();

        System.out.println(count);
      }

    static void counting()
      {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty())
          {
            int student = q.poll();

            if (!visited[student] && rank[student] <= 2)
              {
                visited[student] = true;
                count++;
                for (int i = 0; i < friendMap[student].size(); i++)
                  {
                    int friend = friendMap[student].get(i);
                    if (!visited[friend] && !q.contains(friend))
                      {
                            q.add(friend);
                            rank[friend] = rank[student] + 1;
                      }
                  }
              }
          }
      }
  }