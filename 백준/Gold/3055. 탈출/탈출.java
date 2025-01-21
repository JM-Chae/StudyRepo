import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static Queue<int[]>[] s = new LinkedList[501];
    static int[] e;
    static Queue<int[]>[] f = new LinkedList[501];
    static char[][] map;
    static int turn = 1;
    static boolean done = false;
    static int[] x = new int[]{-1, 1};
    static int[] y = new int[]{-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 1; i <= 500; i++) {
            s[i] = new LinkedList<int[]>();
            f[i] = new LinkedList<int[]>();
        }

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char temp = row.charAt(j);
                map[i][j] = temp;
                if (temp == 'S') {
                    s[1].add(new int[]{i, j});
                } else if (temp == 'D') {
                    e = new int[]{i, j};
                } else if (temp == '*') {
                    f[1].add(new int[]{i, j});
                }
            }
        }

        while (!done) {
            flood(turn);
            move(turn);
            turn++;
            if (turn > 500) {
                break;
            }
        }

        if (!done) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(turn - 1);
        }
    }

    public static void flood(int turn) {
        while (!f[turn].isEmpty()) {
            for (int i = f[turn].size() - 1; i >= 0; i--) {
                int[] temp = f[turn].poll();
                int cx = temp[1];
                int cy = temp[0];

                for (int j = 0; j < 2; j++) {
                    int nx = cx + x[j];
                    int ny = cy + y[j];
                    if (nx < map[cy].length && nx >= 0) {
                        if (map[cy][nx] == '.' || map[cy][nx] == 'S') {
                            map[cy][nx] = '*';
                            f[turn + 1].add(new int[]{cy, nx});
                        }
                    }
                    if (ny < map.length && ny >= 0) {
                        if (map[ny][cx] == '.' || map[ny][cx] == 'S') {
                            map[ny][cx] = '*';
                            f[turn + 1].add(new int[]{ny, cx});
                        }
                    }
                }
            }
        }
    }

    public static void move(int turn) {
        while (!s[turn].isEmpty()) {
            for (int i = s[turn].size() - 1; i >= 0; i--) {
                int[] temp = s[turn].poll();
                int cx = temp[1];
                int cy = temp[0];

                for (int j = 0; j < 2; j++) {
                    int nx = cx + x[j];
                    int ny = cy + y[j];

                    if (nx < map[cy].length && nx >= 0) {
                        if (map[cy][nx] == '.') {
                            map[cy][nx] = '*';
                            s[turn + 1].add(new int[]{cy, nx});
                        } else if (map[cy][nx] == 'D') {
                            done = true;
                            return;
                        }
                    }
                    if (ny < map.length && ny >= 0) {
                        if (map[ny][cx] == '.') {
                            map[ny][cx] = '*';
                            s[turn + 1].add(new int[]{ny, cx});
                        } else if (map[ny][cx] == 'D') {
                            done = true;
                            return;
                        }
                    }
                }
            }
        }
    }
}