import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    static int[] k;
    static int n;
    static int[] max;

    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = new int[n];
        max = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
          {
            k[i] = Integer.parseInt(st.nextToken());
          }

        max[0] = k[0];

        find();

        System.out.println(max[n - 1]);
      }

    static void find()
      {
        int sum = k[0];
        int flag = 0;
        for (int i = 1; i < n; i++)
          {

            if (sum + k[i] <= k[i])
              {
                flag = 1;
              }
            sum += k[i];
            max[i] = Math.max(sum, max[i - 1]);
            max[i] = Math.max(max[i], k[i]);

            if (flag == 1)
              {
                sum = k[i];
                flag = 0;
              }
          }
      }
  }