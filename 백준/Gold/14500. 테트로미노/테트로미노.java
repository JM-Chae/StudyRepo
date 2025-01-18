import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] map;
    static int[] x = new int[]{-1, 1, 0, 0};
    static int[] y = new int[]{0, 0, -1, 1};
    static int ansDFS = 0;
    static int ansT = 0;
    static int n;
    static int m;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                DFS(i, j, 0, 0);
                if (i > 0 && j > 0 && i < n - 1 && j < m - 1) {
                    TSearch(i, j);
                }
            }
        }

        System.out.println(Math.max(ansT, ansDFS));
    }

    static void DFS(int cx, int cy, int d, int max) {
        if (d > 3) {
            ansDFS = Math.max(ansDFS, max);
            return;
        }
        max = max + map[cx][cy];
        visited[cx][cy] = true;

        for (int i = 0; i < 4; i++) {
            int nx = cx + x[i];
            int ny = cy + y[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                DFS(nx, ny, d + 1, max);
            }
        }
        visited[cx][cy] = false;
    }

    static void TSearch(int cx, int cy) {
        int max = map[cx - 1][cy + 1] + map[cx][cy + 1] + map[cx + 1][cy + 1];
        max = Math.max(map[cx - 1][cy + 1] + map[cx - 1][cy] + map[cx - 1][cy - 1], max);
        max = Math.max(map[cx - 1][cy - 1] + map[cx][cy - 1] + map[cx + 1][cy - 1], max);
        max = Math.max(map[cx + 1][cy + 1] + map[cx + 1][cy] + map[cx + 1][cy - 1], max);
        max = Math.max(map[cx + 1][cy] + map[cx - 1][cy] + map[cx][cy - 1], max);
        max = Math.max(map[cx + 1][cy] + map[cx - 1][cy] + map[cx][cy + 1], max);
        max = Math.max(map[cx + 1][cy] + map[cx][cy + 1] + map[cx][cy - 1], max);
        max = Math.max(map[cx - 1][cy] + map[cx][cy + 1] + map[cx][cy - 1], max);

        ansT = Math.max(max + map[cx][cy], ansT);
    }
}