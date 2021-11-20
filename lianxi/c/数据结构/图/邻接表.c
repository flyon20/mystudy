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

typedef int Status;	
typedef char VertexType; 
typedef int EdgeType; 

typedef struct EdgeNode//边表结点
{
    int adjvex;
    EdgeType info;
    struct EdgeNode *next;
}EdgeNode;

typedef struct VertexNode//顶点表结点
{
    VertexType data;
    EdgeNode *firstedge;
}VertexNode,AdjList[MAXSIZE];

typedef struct 
{
    AdjList adjList;
    int numNodes,numEdges;
}GraphAdjList;

void CreateALGraph(GraphAdjList *G){
    int i,j,k;
	EdgeNode *e;
	printf("输入顶点数和边数:\n");
	scanf("%d %d",&G->numNodes,&G->numEdges); /* 输入顶点数和边数 */
	for(i = 0;i < G->numNodes;i++) /* 读入顶点信息,建立顶点表 */
	{
		scanf(&G->adjList[i].data); 	/* 输入顶点信息 */
		G->adjList[i].firstedge=NULL; 	/* 将边表置为空表 */
	}
	
	
	for(k = 0;k < G->numEdges;k++)/* 建立边表 */
	{
		printf("输入边(vi,vj)上的顶点序号:\n");
		scanf("%d %d",&i,&j); /* 输入边(vi,vj)上的顶点序号 */
		e=(EdgeNode *)malloc(sizeof(EdgeNode)); //边表结点
		e->adjvex=j;					/* 邻接序号为j */                         
		e->next=G->adjList[i].firstedge;	/* 将e的指针指向当前顶点上指向的结点 */
		G->adjList[i].firstedge=e;		/* 将当前顶点的指针指向e */               
		
		e=(EdgeNode *)malloc(sizeof(EdgeNode)); 
		e->adjvex=i;					/* 邻接序号为i */                         
		e->next=G->adjList[j].firstedge;	/* 将e的指针指向当前顶点上指向的结点 */
		G->adjList[j].firstedge=e;		/* 将当前顶点的指针指向e */               
	}
}

int main()
{    
	GraphAdjList G;    
	CreateALGraph(&G);
	
	return 0;
}


