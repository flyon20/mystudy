//Prim
#include <stdio.h>    
#include <stdlib.h> 
#include <string.h>

#include <math.h>  
#include <time.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

#define MAXEDGE 20
#define MAXVEX 20
#define GRAPH_INFINITY 65535

typedef int Status;	
typedef struct 
{
    int arc[MAXVEX][MAXVEX];
    int numEdges,numVertexes;
}MGraph;

void CreateMGraph(MGraph *G)/* 构件图 */
{
	int i, j;

	/* printf("请输入边数和顶点数:"); */
	G->numEdges=15;
	G->numVertexes=9;

	for (i = 0; i < G->numVertexes; i++)/* 初始化图 */
	{
		for ( j = 0; j < G->numVertexes; j++)
		{
			if (i==j)
				G->arc[i][j]=0;
			else
				G->arc[i][j] = G->arc[j][i] = GRAPH_INFINITY;
		}
	}

	G->arc[0][1]=10;
	G->arc[0][5]=11; 
	G->arc[1][2]=18; 
	G->arc[1][8]=12; 
	G->arc[1][6]=16; 
	G->arc[2][8]=8; 
	G->arc[2][3]=22; 
	G->arc[3][8]=21; 
	G->arc[3][6]=24; 
	G->arc[3][7]=16;
	G->arc[3][4]=20;
	G->arc[4][7]=7; 
	G->arc[4][5]=26; 
	G->arc[5][6]=17; 
	G->arc[6][7]=19; 

	for(i = 0; i < G->numVertexes; i++)
	{
		for(j = i; j < G->numVertexes; j++)
		{
			G->arc[j][i] =G->arc[i][j];
		}
	}

}

void MiniSpanTree_Prim(MGraph G)
{
    int min,i,j,k;
    int adjvex[MAXVEX];
    int lowcost[MAXVEX];
    adjvex[0]=0;//V0加入生成树
    lowcost[0]=0;//第一个顶点下标值
    for(i=1;i<G.numVertexes;i++)
    {
        lowcost[i]=G.arc[0][i];//将V0顶点的邻边权值信息存入
        adjvex[i]=0;//都为顶点的下标
    }
    for(i=1;i<G.numVertexes;i++)
    {
        min=GRAPH_INFINITY;
        j=1,k=0;//j作为下标循环变量，k作为记录下标值
        while(j<G.numVertexes)
        {
            if(lowcost[j]!=0&&lowcost[j]<min)
            {
                min=lowcost[i];//让当前权值成为最小值
                k=j;//存入下标
            }
            j++;
        }
        printf("%d,%d\n",adjvex[k],k);
        lowcost[k]=0;//将该顶点权值设置为0
        for(j=1;j<G.numVertexes;j++)
        {
            if(lowcost[j]!=0&&G.arc[k][j]<lowcost[j])
            {
                lowcost[j]=G.arc[k][j];
                adjvex[j]=k;
            }
        }

    }

}
int main(void)
{
	MGraph G;
	CreateMGraph(&G);
	MiniSpanTree_Prim(G);
  
	return 0;
 
}
