

import java.util.Scanner;
import java.lang.Math;
public class antcolony {
	public static void main(String[] args) {
		int key[],i,j,k,s,dest,ini,ini1,dest1,rank;
		double grap[][],phero[][],cal[][],wheel[][],alpha,beta,sum[],sum1=0,randno,a,g;
		alpha=0.5;
		beta=0.5;
		Scanner sc=new Scanner(System.in);
			System.out.println("ENTER THE NUMBER OF STATIONS");
			s=sc.nextInt();
			grap=new double[s][s];
			phero=new double[s][s];
			cal=new double[s][s];
			sum=new double[s+1];
			key=new int[s+1];
			wheel=new double[s][s];
			for(i=0;i<s;i++)
			{
				key[i]=0;
				sum[i]=0.0;
				for(j=0;j<s;j++)
				{
					grap[i][j]=0.0;
					phero[i][j]=cal[i][j]=wheel[i][j]=0.0;
				}
			}
			for(i=0;i<s;i++)
			{
				for(j=i;j<s;j++)
				{
					if(i!=j)
					{
						System.out.println("The distance between station "+(i+1)+" and "+(j+1)+" is");
						grap[j][i]=grap[i][j]=sc.nextInt();
					}
				}
			}
			System.out.println("MENTION THE AVAILABLE PHEROMON LEVEL");
			for(i=0;i<s;i++)
			{
				for(j=i;j<s;j++)
				{
					if(i!=j)
					{
						System.out.println("The pheromon level between station "+(i+1)+" and "+(j+1)+" is");
						phero[j][i]=phero[i][j]=sc.nextInt();
					}
				}
			}
			for(i=0;i<s;i++)
			{	
				sum1=0;
				for(j=0;j<s;j++)
				{
					if(i!=j)
					{
						a=(Math.pow(phero[i][j],alpha));
						g=(Math.pow((1/grap[i][j]),beta));
						sum1=sum1+(a*g);
					}
				}
				sum[i]=sum1;
			}
			for(i=0;i<s;i++)
			{
				for(j=0;j<s;j++)
				{
					if(i!=j)
					{
						a=Math.pow(phero[i][j],alpha);
						g=Math.pow((1/grap[i][j]),beta);
						cal[i][j]=(a*g)/sum[i];
					}
				}
			}
			System.out.println(" ");
			for(i=0;i<s;i++)
			{
				for(j=0;j<s;j++)
				{
					sum1=0.0;
					for(k=j;k<s;k++)
					{
							sum1=sum1+cal[i][k];
					}
					wheel[i][j]=sum1;
				}
			}
			System.out.println(" ");
			System.out.println("WHICH IS THE INITIAL STATION");
			ini1=sc.nextInt();
			System.out.println("WHICH IS THE FINAL STATION");
			dest1=sc.nextInt();
			ini=ini1-1;
			dest=dest1-1;
			System.out.println("THE STATIONS TRAVELED BY THE ANT IN ORDER ARE");
			System.out.println(" "+ini1+" ");
			key[ini]=1;
			while(ini!=dest)
			{
				randno=Math.random();
				//System.out.println("random="+randno);
				rank=0;
					for(j=0;j<s-1;j++)
					{
						k=j+1;
						if((wheel[ini][j]>=randno)&&(randno>wheel[ini][k])&&(key[j]==0))
						{
								System.out.println(" "+(j+1)+" ");
								ini=j;
								rank=1;
								key[ini]=1;
								break;
						}
						if((wheel[ini][k]<randno)&&(k==(s-1))&&(key[k]==0)&&(rank==0))
						{
								ini=k;
								key[ini]=1;
								System.out.println(" "+(k+1)+" ");
								break;
						}
					}
			}
			}
		}
	




