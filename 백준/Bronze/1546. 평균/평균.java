import java.util.Arrays;
import java.util.Scanner;

class Main
  {
    public static void main(String[] args)
      {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int M;
        for (int i = 0; i < N; i++)
          {
            a[i] = sc.nextInt();
          }
        M = Arrays.stream(a).max().orElseThrow();
        int sum = Arrays.stream(a).sum();
        double avg = (double) sum / M * 100 / N;
        
        System.out.println(avg);
      }
  }
