import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main
  {
    static int[][] map;
    static int n;
    static int m;
    static int[] xd = {0, 1, 0, -1};
    static int[] yd = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++)
          {
            String temp = br.readLine();
            for (int j = 0; j < m; j++)
              {
                map[i][j] = temp.charAt(j) - '0';
              }
          }

        BFS(0, 0);

        System.out.println(map[n - 1][m - 1]);
      }

    static void BFS(int y, int x)
      {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while (!q.isEmpty())
          {

            int[] cur = q.poll();
            int current = map[cur[0]][cur[1]];

            for (int i = 0; i < 4; i++)
              {
                int tx = cur[1] + xd[i];
                int ty = cur[0] + yd[i];

                if (tx >= 0 && tx < m && ty >= 0 && ty < n)
                  {
                    if (map[ty][tx] == 1)
                      {
                        map[ty][tx] = map[ty][tx] + current;
                        q.add(new int[]{ty, tx});
                      }
                  }
              }
          }
      }
  }