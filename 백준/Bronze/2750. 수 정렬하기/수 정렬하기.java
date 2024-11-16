import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];


        for (int i = 0; i < n; i++)
          {
            arr[i] = Integer.parseInt(br.readLine());
          }

        for (int i = 0; i < n; i++)
          {
            boolean done = true;
            for (int j = 0; j < n - i; j++)
              {
                if (j < n - 1)
                  {
                    int temp = arr[j];
                    if (arr[j] > arr[j + 1])
                      {
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        done = false;
                      }
                  }
              }
            if (done)
              {
                break;
              }
          }

        for (int i = 0; i < n; i++)
          {
            System.out.println(arr[i]);
          }
      }
  }