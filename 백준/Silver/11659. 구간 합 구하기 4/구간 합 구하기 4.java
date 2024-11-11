import java.util.Scanner;

class Main
  {
    public static void main(String[] args)
      {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int counter = sc.nextInt();
        int i = 0;
        int j = 0;
        int[] a = new int[N];
        int sum = 0;
        int[] sumArray = new int[N];
        for (int q = 0; q < N; q++)
          {
            a[q] = sc.nextInt();
            sum += a[q];
            sumArray[q] = sum;
          }

        for (int s = 0; s < counter; s++)
          {
            i = sc.nextInt();
            j = sc.nextInt();
            System.out.println(sumArray[j-1] - (i == 1 ? 0 : sumArray[i-2]));
          }
      }
  }
