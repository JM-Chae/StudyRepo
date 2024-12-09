import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main
  {
    public static void main(String[] args) throws IOException
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] tree;
        int k = 1;

        int dataLength = n.split(" ").length;
        int treeLength = 2;

        while(treeLength <= dataLength)
          {
            k++;
            treeLength *= 2;
          }

        treeLength *=2;

        tree = new int[treeLength];
        int TreeDataIndex = (int)Math.pow(2, k);

        for (int i = 0; i < dataLength; i++)
          {
            tree[TreeDataIndex+i] = Integer.parseInt(n.split(" ")[i]);
          }

        for (int i = treeLength-1; i > 1; i--)
          {
            int parent = i / 2;
            tree[parent] += tree[i];
          }

        for (int i = 0; i < treeLength; i++)
          {
            System.out.print(tree[i]+" ");
          }

        System.out.println();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        s = s - 1 + TreeDataIndex;
        e = e - 1 + TreeDataIndex;

        int ans = 0;

        while (s < e)
          {
            if (s % 2 == 1)
              {
                ans += tree[s];
                s++;
              }
            s/=2;

            if (e % 2 == 0)
              {
                ans += tree[e];
                e--;
              }
            e/=2;
          }

        ans += tree[s];

        System.out.println(ans);
      }
  }
