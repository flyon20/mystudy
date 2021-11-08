//单指针循环队列
#include <stdio.h>    
#include <stdlib.h>   

#include <math.h>
#include <time.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXSIZE 20 

typedef int Status; 
typedef int QElemType;

typedef struct Node
{
    QElemType data;/* 数据域 */
    struct Node *next;//指针域
}Node;

typedef struct SqQueue
{
    struct Node *rear;/* 尾指针 */
}SqQueue;
//初始化队列
Status Initiate(SqQueue *queue){
    queue->rear =  (Node*)malloc(sizeof(Node));
    queue->rear->next=queue->rear;
    return OK;
}
//队空判断
Status isNotEmpty(SqQueue queue){
    if(queue.rear->next==queue.rear)
        return TRUE;
    else
        return FALSE;

}
//设置为空
Status ClearStack(SqQueue *queue){
    
    queue->rear->next=queue->rear;
    return OK;

}
//入队
Status queuePush(SqQueue *queue,QElemType x){
    Node *p=queue->rear;//创建一个新的指针
    //让p始终指向尾结点的前一个结点
    while(p->next!=queue->rear){
        p=p->next;
    }
    Node *q;
    q=(Node*)malloc(sizeof(Node));
    q->data=x;
    q->next=queue->rear;
    p->next=q;
    return OK;
}
//出队列
Status queuePop(SqQueue *queue,QElemType *e){
    if (queue->rear->next==queue->rear)//判断
        return ERROR;

    Node *q = queue->rear->next;//队首结点

    queue->rear->next=q->next;//尾结点指向第二个结点
    *e = q->data;
    free(q);
    return OK;
}

//输出元素
Status visit(QElemType c)
{
	printf("%d ",c);
	return OK;
}
Status QueueTraverse(SqQueue queue){
    Node *p = queue.rear;
    if(queue.rear->next==queue.rear)
        return ERROR;
    while(p->next!=queue.rear){
        visit(p->next->data);
        p=p->next;
    }
    printf("\n");

}

int main(){
    SqQueue Q;
    QElemType e;
    Status i;
    int j,k;
    i=Initiate(&Q);
    printf("初始化队列后，队列空否？%d(1:空 0:否)\n",isNotEmpty(Q));
    for(j=1;j<=5;j++)
        queuePush(&Q,j);
    printf("现在队列空否？%d(1:空 0:否)\n",isNotEmpty(Q));
    printf("依次输出Q的元素：");
    QueueTraverse(Q);
    for(j=1;j<=5;j++)
        queuePop(&Q,&j);
    printf("出队列后现在队列空否？%d(1:空 0:否)\n",isNotEmpty(Q));

    ClearStack(&Q);
	printf("清空队列后, 队列空否？%d(1:空 0:否)\n",isNotEmpty(Q));
	return 0;

}


