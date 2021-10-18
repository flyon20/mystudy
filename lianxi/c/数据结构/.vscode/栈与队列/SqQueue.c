//循环队列,常规队列容易假溢出
#include "stdio.h"    
#include "stdlib.h"   

#include "math.h"  
#include "time.h"

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXSIZE 20 

typedef int Status; 
typedef int QElemType;

//循环队列结构
typedef struct 
{
    QElemType data[MAXSIZE];
    int rear;//尾指针
    int front;//头指针
}SqQueue;

//空队列
Status InitQueue(SqQueue *Q){
    Q->front=0;
    Q->rear=0;
    return OK;
}

//返回元素个数,队列长度
Status QueueLength(SqQueue Q){
    return (Q.rear-Q.front+MAXSIZE)%MAXSIZE;

}

//设置为空队列
Status CleatQueue(SqQueue *Q){
    Q->front=Q->rear=0;
    return OK;
}

//队列的判断
Status QueueEmpty(SqQueue Q){
    if(Q.front==Q.rear)
        return TRUE;
    else
        return FALSE;

}

//返回队列元素
Status  GetHead(SqQueue Q,QElemType *e){
    if(Q.rear==Q.front)
        return ERROR;
    *e = Q.data[Q.front];
    return OK;
}

//插入算法，入队列
Status DeQueue(SqQueue *Q,QElemType e){
    if((Q->rear+1)%MAXSIZE==Q->front)//队列满判断
        return ERROR;
    Q->data[Q->rear]=e;
    Q->rear=(Q->rear+1)%MAXSIZE;

    return OK;
}

//出队列
Status DeQueue(SqQueue *Q,QElemType *e)
{
	if (Q->front == Q->rear)			//队列空的判断
		return ERROR;
	*e=Q->data[Q->front];				//将队头元素赋值给e 
	Q->front=(Q->front+1)%MAXSIZE;	/* front指针向后移一位置， */
									/* 若到最后则转到数组头部 */
	return  OK;
}

//队列依次显示每一个元素
Status visit(QElemType c)
{
	printf("%d ",c);
	return OK;
}
Status QueueTraverse(SqQueue Q)
{ 
	int i;
	i=Q.front;
	while((i+Q.front)!=Q.rear)
	{
		visit(Q.data[i]);
		i=(i+1)%MAXSIZE;
	}
	printf("\n");
	return OK;
}

int main(){
    Status j;
	int i=0,l;
	QElemType d;
	SqQueue Q;
	InitQueue(&Q);
	printf("初始化队列后，队列空否？%u(1:空 0:否)\n",QueueEmpty(Q));

	printf("请输入整型队列元素(不超过%d个),-1为提前结束符: ",MAXSIZE-1);
	do
	{
		/* scanf("%d",&d); */
		d=i+100;
		if(d==-1)
			break;
		i++;
		EnQueue(&Q,d);
	}while(i<MAXSIZE-1);

	printf("队列长度为: %d\n",QueueLength(Q));
	printf("现在队列空否？%u(1:空 0:否)\n",QueueEmpty(Q));
	printf("连续%d次由队头删除元素,队尾插入元素:\n",MAXSIZE);
	for(l=1;l<=MAXSIZE;l++)
	{
		DeQueue(&Q,&d);
		printf("删除的元素是%d,插入的元素:%d \n",d,l+1000);
		/* scanf("%d",&d); */
		d=l+1000;
		EnQueue(&Q,d);
	}
	l=QueueLength(Q);

	printf("现在队列中的元素为: \n");
	QueueTraverse(Q);
	printf("共向队尾插入了%d个元素\n",i+MAXSIZE);
	if(l-2>0)
		printf("现在由队头删除%d个元素:\n",l-2);
	while(QueueLength(Q)>2)
	{
		DeQueue(&Q,&d);
		printf("删除的元素值为%d\n",d);
	}

	j=GetHead(Q,&d);
	if(j)
		printf("现在队头元素为: %d\n",d);
	ClearQueue(&Q);
	printf("清空队列后, 队列空否？%u(1:空 0:否)\n",QueueEmpty(Q));
	return 0;
}