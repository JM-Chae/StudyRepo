import java.util.Scanner;

class Main
  {
    public static void main(String[] args)
      {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int pt1 = 0;
        int pt2 = 0;
        int sum = 0;
        int count = 1;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
          {
            arr[i] = i+1;
          }

        while (pt2 < N)
          {
            if (sum < N)
              {
                sum += arr[pt2];
                pt2 += 1;
              } else if (sum == N)
              {
                count += 1;
                sum -= arr[pt1];
                pt1 += 1;
              } else if (sum > N)
              {
                sum -= arr[pt1];
                pt1 += 1;
              }
          }

        System.out.println(count);
      }
  }
