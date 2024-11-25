import java.util.Scanner;

public class Main
  {
    public static void main(String[] args)
      {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long res = n;

        for (int i = 2; i <= n; i++)
          {
            if (n % i == 0)
              {
                res = res - res/i;
                while(n % i == 0)
                  {
                    n = n / i;
                  }
              }
            if (i > (int)Math.sqrt(n)) break;
          }

        if (n > 1)
          {
            res = res - res/n;
          }

        System.out.println(res);
      }
  }