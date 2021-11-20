#include <stdio.h>    
#include <stdlib.h> 
#include <string.h>

#include <math.h>  
#include <time.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXSIZE 100

#define GRAPH_INFINITY 65535 /* 用65535来代表∞ */

typedef char VertexType; /* 顶点类型应由用户定义  */
typedef int EdgeType; /* 边上的权值类型应由用户定义 */
typedef struct
{
    VertexType vexs[MAXSIZE];//顶点表
    EdgeType arc[MAXSIZE][MAXSIZE];
    int numNodes,numEdges;//顶点数和边数
}MGraph;
//无向图的邻接表示
void  CreateMGraph(MGraph *G){
    int i,j,k,w;
    printf("请输入顶点和边数：\n");
    scanf("%d %d",&G->numNodes,&G->numNodes);
    for(i = 0;i <G->numNodes;i++) /* 读入顶点信息,建立顶点表 */
		scanf(&G->vexs[i]);
    for(i=0;i<G->numNodes;i++)
        for(j=0;j<G->numNodes;j++)
            G->arc[i][j]=GRAPH_INFINITY;
    	for(k = 0;k <G->numEdges;k++) /* 读入numEdges条边，建立邻接矩阵 */
	{
		printf("请输入边(vi,vj)上的下标i，下标j和权w:\n");
		scanf("%d,%d,%d",&i,&j,&w); /* 输入边(vi,vj)上的权w */
		G->arc[i][j]=w; 
		G->arc[j][i]= G->arc[i][j]; /* 因为是无向图，矩阵对称 */
	}

}
int main(){
        MGraph G;
        CreateMGraph(&G);
        
    }