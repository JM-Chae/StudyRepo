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
            for (int j = 0; j < n - i; j++)
              {
                if (j < n - 1)
                  {
                    int temp = arr[j];
                    arr[j] = Math.min(arr[j], arr[j + 1]);
                    if (arr[j] != temp)
                      {
                        arr[j + 1] = temp;
                      }
                  }
              }
          }
        for (int i = 0; i < n; i++)
          {
            System.out.println(arr[i]);
          }
      }
  }