import java.util.Scanner;

class Main
  {
    public static void main(String[] args)
      {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int pt1 = 1;
        int pt2 = 1;
        int sum = 0;
        int count = 1;

        while (pt2 <= N)
          {
            if (sum < N)
              {
                sum += pt2;
                pt2 += 1;
              } else if (sum == N)
              {
                count += 1;
                sum -= pt1;
                pt1 += 1;
              } else
              {
                sum -= pt1;
                pt1 += 1;
              }
          }

        System.out.println(count);
      }
  }
