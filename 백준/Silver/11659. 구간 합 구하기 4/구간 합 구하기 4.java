import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int counter = Integer.parseInt(st.nextToken());

        String[] a = br.readLine().split(" ");
        long sum = 0;
        long[] sumArray = new long[N];
        for (int q = 0; q < N; q++)
          {
            sum += Integer.parseInt(a[q]);
            sumArray[q] = sum;
          }

        for (int s = 0; s < counter; s++)
          {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sumArray[j-1] - (i == 1 ? 0 : sumArray[i-2]));
          }
      }
  }
