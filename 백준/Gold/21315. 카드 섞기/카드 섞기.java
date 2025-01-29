import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[] arr;
    static int k1;
    static int k2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int[] test1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            test1[i] = i + 1;
        }

        for (int i = 1; i <= 9; i++) {
            if (Math.pow(2, i) > n - 1) {
                continue;
            }

            int[] test2 = shuffle(i, test1.clone());

            for (int j = 1; j < 10; j++) {
                if (Math.pow(2, j) > n - 1) {
                    continue;
                }

                int[] ans = shuffle(j, test2.clone());

                if (Arrays.equals(arr, ans)) {
                    k1 = i;
                    k2 = j;
                    break;
                }
            }
        }

        System.out.print(k1 + " " + k2);
    }

    public static int[] shuffle(int k, int[] tmp) {
        int card = n;

        for (int i = 1; i <= k + 1; i++) {
            int[] next = new int[n];
            int up = (int) Math.pow(2, k - i + 1);
            int idx = 0;

            for (int j = card - up; j < card; j++) {
                next[idx] = tmp[j];
                idx++;
            }

            for (int j = 0; j < card - up; j++) {
                next[idx] = tmp[j];
                idx++;
            }

            for (int j = card; j < n; j++) {
                next[idx] = tmp[j];
                idx++;
            }

            tmp = next.clone();

            card = up;
        }

        return tmp;
    }
}