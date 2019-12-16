
import java.util.Scanner;
public class Dijkstra__Single_Source_Shortest_Path {

    private static int N;
    private static int M;
    private static int max;
    private static int[] visit;
    private static int[][] distance;
    private static int[] bestmin;
    private static String[] path;
    
    public static void Dijkstra() {
        visit[1] = 1;
        bestmin[1] = 0;
        
        //��ѭ�����㶨�������㶨���㷨�ˣ���������ʲô�Ŀ��Բ�����
        for(int l = 2; l <= N; l++) {
            int Dtemp = max;
            int k = -1;
            
            //�����
            for(int i = 2; i <= N; i++) {
                if(visit[i] == 0 && distance[1][i] < Dtemp) {
                    Dtemp = distance[1][i];
                    k = i;
                }
            }
            visit[k] = 1;
            bestmin[k] = Dtemp;
            
            //�����
            for(int i = 2; i <= N; i++) {
                if(visit[i] == 0 && (distance[1][k] + distance[k][i]) < distance[1][i]) {
                    distance[1][i] = distance[1][k] + distance[k][i];
                    path[i] = path[k] + "-->" + i;
                }
            }
        }
        
        //���·��
        for(int i=1;i<=N;i++) {
             System.out.println("��"+1+"������"+i+"�����·��Ϊ��"+path[i]);   
        }
        System.out.println("=====================================");
        for(int i = 1; i <= N; i++) {
            System.out.println("��1������" + i + "�����̾���Ϊ��" + bestmin[i]);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner input = new Scanner(System.in);
        System.out.print("������ڵ����N��·������M�� ");
        N = input.nextInt();
        M = input.nextInt();
        max = 10000;
        bestmin = new int[N+1];
        distance = new int [N+1][N+1];
        visit = new int[N+1];
        path=new String[N+1];
        
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                }else {
                    distance[i][j] = max;
                }
            }
            bestmin[i] = max;
            path[i] = new String("1-->" + i);
        }
        
        System.out.println("������" + M +"������x��y��z����ʾx�㵽y��ľ���Ϊz����");
        for(int i = 1; i <= M; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int z = input.nextInt();
            distance[x][y] = z;
        }
        input.close();
        
        Dijkstra();
    }

}