public class Best_Matrix {
	public static void main(String[] args) {
		int []p = {12,31,42,43,4,5,23};
		int [][]m = new int[p.length+1][p.length+1];
		int [][]s = new int[p.length+1][p.length+1];
		Matrixchain(p,m,s);
		System.out.println("�˷����Ŵ���");
		TraceBack(s,1,p.length-1);
	}
	public static void Matrixchain(int []p,int [][]m,int[][]s){
		for(int i=0;i<p.length;i++){
			m[i][i]=0;
		}
		for(int r=2;r<=p.length;r++){
			for(int i=1;i<p.length-r;i++){
				int j = i+r-1;
				m[i][j] = m[i+1][j]+p[i-1]*p[i]*p[j];
				s[i][j] = i;
				for(int k = i+1;k<j;k++){
					int t = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(t<m[i][j]){
						m[i][j]=t;
						s[i][j]=k;
					}
				}
			}
		}
	}
	private static void TraceBack(int[][]s,int i,int j)
	{
		if(i==j){
			System.out.println("A"+i);
		}
		else if(i+1==j)
			System.out.print(" (A"+i+" * "+" A"+j+") "); 
		else{     
			System.out.print(" (");   
			//TraceBack(s,i,s[i][j]);   
			//TraceBack(s,s[i][j]+1,j);      
			System.out.print(") ");    
		}		
	}
	
}

