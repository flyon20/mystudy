import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 一个五行四列迷宫，起点1,1终点4,3,其地图2表示障碍，地图如下
* 1121
* 1111
* 1121
* 1211
* 1112*/
public class BFS迷宫 {

    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);
        int []xx = new int []{1,0,-1,0};
        int []yy = new int []{0,1,0,-1};
        int n = scan.nextInt();
        int m = scan.nextInt();
        String ss =scan.nextLine();
        int [][]a= new int[n][m];
        for(int i=0;i<n;i++) {

            for (int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(ss.charAt(j) + "");
        }
        int startx = scan.nextInt();
        int starty = scan.nextInt();
        int p = scan.nextInt();
        int q = scan.nextInt();
        int step = 0;
        Queue<node> queue = new LinkedList<>();

        queue.add(new node(startx,starty,step));
        int [][]v = new int[startx][starty];
        v[startx][starty] = 1;

        while (!queue.isEmpty()){
           int x = queue.peek().x;
            int y= queue.peek().y;
            if(x==p&&y==q){
                System.out.println(queue.peek().step);
                break;
            }
            for(int k=0;k<=3;k++){
                int tx,ty;
                tx = x+xx[k];
                ty = y+yy[k];
                if(a[tx][ty]==1&&v[tx][ty]==0){
                    queue.add(new node(tx,ty,step+1));
                }
            }
            queue.poll();

        }

    }
    public static class node{
      int x,y,step;
      node(int x,int y,int step){
          this.x=x;
          this.y=y;
          this.step=step;
      }
    }
}
