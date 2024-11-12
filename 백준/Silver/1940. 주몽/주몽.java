import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int pt1 = 0;
        int pt2 = N - 1;
        int count = 0;
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
          {
            arr[i] = Integer.parseInt(st.nextToken());
          }

        Arrays.sort(arr);

        while (pt1 < pt2)
          {
            if (arr[pt1] + arr[pt2] < M)
              {
                pt1 += 1;
              } else if (arr[pt1] + arr[pt2] == M)
              {
                count += 1;
                pt1 += 1;
                pt2 -= 1;
              } else
              {
                pt2 -= 1;
              }
          }

        System.out.println(count);
      }
  }