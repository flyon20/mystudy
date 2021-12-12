#include <stdio.h>    
#include <stdlib.h>   

#include <math.h>
#include <time.h>
#define MAXSIZE 20 

typedef int Status; 
typedef int ElemType;

//设计队列类型
typedef struct 
{
	ElemType data[MAXSIZE];
	int front;
	int count;
}SqQueue;
 
 
//队初始化
int InitQueue(SqQueue *qu)
 
{
	qu->front=qu->front=0;
	return 1;
}
 
//销毁队
void DestoryQueue(SqQueue sq)
{
	sq.front=sq.front;
 } 
//入队
 
int EnQueue(SqQueue *sq,ElemType x)
{
	if(sq->count==MAXSIZE)
		return 0;
	sq->data[(sq->count+sq->front)%MAXSIZE]=x;
	sq->count++;
	return 1;
}
 
//出队
int DeQueue(SqQueue *sq,ElemType *x)
{
	if(sq->count==0)
		return 0;
	*x=sq->data[sq->front];
	sq->front=(sq->front+1)%MAXSIZE;
	sq->count--;
	return 1;
}
 
//取队头元素
int GetHead(SqQueue sq,ElemType *x)
{
	if(sq.count==0)
		return 0;
	*x=sq.data[sq.front];
	return 1;
}
 
//判断队空 
int QueueEmpty(SqQueue sq)
{
	return (sq.count==0);
}

//输出元素
void QueueTraverse(SqQueue Q){
	if(QueueEmpty(Q))
		printf("Sorry,thequeueisempty! ");//队列下溢出
	else{
	int p=Q.count;
	int i=0;
	printf("Now,thereare%delementsofqueue:\n",p);
	while(p!=0){
	int place=(Q.front+i)%MAXSIZE;
	printf("%d,",Q.data[place]);
	i++;
	p--;
	}
	printf(" ");
	}
	}
int main(){
    SqQueue Q;
    ElemType e;
    Status i;
    int j,k;
    i=InitQueue(&Q);
    printf("初始化队列后，队列空否？%d(1:空 0:否)\n",QueueEmpty(Q));
    for(j=1;j<=5;j++)
        EnQueue(&Q,j);
    printf("现在队列空否？%d(1:空 0:否)\n",QueueEmpty(Q));
    printf("依次输出Q的元素：");
    QueueTraverse(Q);
    for(j=1;j<=5;j++)
        DeQueue(&Q,&j);
    printf("\n出队列后现在队列空否？%d(1:空 0:否)\n",QueueEmpty(Q));
	return 0;

}
