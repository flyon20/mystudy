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
typedef int ElemType;

typedef struct Node
{
    ElemType data;/* 数据域 */
    struct Node *next;//指针域
    
}Node,*LinkList;
//构造空表
Status InitList(LinkList *L){
    *L=(LinkList)malloc(sizeof(Node)); /* 产生头结点,并使L指向此头结点 */
    if(!(*L)) /* 存储分配失败 */
            return ERROR;
    (*L)->next=NULL; /* 指针域为空 */

    return OK;
}
//判断
Status ListEmpty(LinkList L){
    if(L->next)
        return TRUE;
    else
        return ERROR;

}

//
Status ClearList(LinkList *L){
    LinkList p,q;
    p=(*L)->next;//p为替换指针，p指向第一个节点
    while (p)
    {
        q=p->next;/* code */
        free(p);
        p=q;
    }
    (*L)->next=NULL;
    return OK;

}

//长度
Status ListLength(LinkList L){
    int i=0;
    LinkList p=L->next;
    while (p)
    {
        i++;
        p=p->next;
    }
    return i;
    
}
//取值
Status GetElem(LinkList L,int i,ElemType *e){
    int j=1;
    LinkList p;
    p=L->next;
    while (p&&j<i)
    {
        p=p->next;
        ++j;
    }
    if(!p||i>j)//不存在第i个元素
        return ERROR;
    *e=p->data;
    return OK;
}

/* 返回L中第1个与e满足关系的数据元素的位序。 */
int LocateElem(LinkList L,ElemType e)
{
    int i=0;
    LinkList p=L->next;
    while(p)
    {
        i++;
        if(p->data==e) /* 找到这样的数据元素 */
                return i;
        p=p->next;
    }

    return 0;
}
//插入
Status ListInsert(LinkList *L,int i,ElemType e){
    int j=1;
    LinkList p,q;

    p=*L;
    while (p&&i>j)
    {
        p=p->next;
        j++;
    }
    if(!q||i<j)
        return ERROR;
    q= (LinkList)malloc(sizeof(Node));

    q->data=e;
    q->next=p->next;
    p->next=q;

    return OK;
}

//删除
Status ListDelete(LinkList *L,int i,ElemType *e){
    int j=1;
    LinkList p,q;
    p=*L;
    while (p->next && j < i)	/* 遍历寻找第i个元素 */
	{
        p = p->next;
        ++j;
	}
	if (!(p->next) || j > i) 
	    return ERROR; 

    q=p->next;
    p->next=q->next;
    *e=q->data;
    free(q);

    return OK;
}

//输出元素
Status visit(ElemType c)
{
    printf("%d ",c);
    return OK;
}
Status ListTraverse(LinkList L)
{
    LinkList p=L->next;
    while(p)
    {
        visit(p->data);
        p=p->next;
    }
    printf("\n");
    return OK;
}

//随机产生n个元素的值，建立带表头结点的单链线性表L（头插法）
void CreateListHead(LinkList *L, int n) 
{
	LinkList p;
	int i;
	srand(time(0));                         /* 初始化随机数种子 */
	*L = (LinkList)malloc(sizeof(Node));
	(*L)->next = NULL;                      /*  先建立一个带头结点的单链表 */
	for (i=0; i<n; i++) 
	{
		p = (LinkList)malloc(sizeof(Node)); /*  生成新结点 */
		p->data = rand()%100+1;             /*  随机生成100以内的数字 */
		p->next = (*L)->next;    
		(*L)->next = p;						/*  插入到表头 */
	}
}

/*  随机产生n个元素的值，建立带表头结点的单链线性表L（尾插法） */
void CreateListTail(LinkList *L, int n) 
{
	LinkList p,r;
	int i;
	srand(time(0));                      /* 初始化随机数种子 */
	*L = (LinkList)malloc(sizeof(Node)); /* L为整个线性表 */
	r=*L;                                /* r为指向尾部的结点 */
	for (i=0; i<n; i++) 
	{
		p = (Node *)malloc(sizeof(Node)); /*  生成新结点 */
		p->data = rand()%100+1;           /*  随机生成100以内的数字 */
		r->next=p;                        /* 将表尾终端结点的指针指向新结点 */
		r = p;                            /* 将当前的新结点定义为表尾终端结点 */
	}
	r->next = NULL;                       /* 表示当前链表结束 */
}


int main()
{        
    LinkList L;
    ElemType e;
    Status i;
    int j,k;
    i=InitList(&L);
    printf("初始化L后：ListLength(L)=%d\n",ListLength(L));
    for(j=1;j<=5;j++)
            i=ListInsert(&L,1,j);
    printf("在L的表头依次插入1～5后：L.data=");
    ListTraverse(L); 

    printf("ListLength(L)=%d \n",ListLength(L));
    i=ListEmpty(L);
    printf("L是否空：i=%d(1:是 0:否)\n",i);

    i=ClearList(&L);
    printf("清空L后：ListLength(L)=%d\n",ListLength(L));
    i=ListEmpty(L);
    printf("L是否空：i=%d(1:是 0:否)\n",i);

    for(j=1;j<=10;j++)
            ListInsert(&L,j,j);
    printf("在L的表尾依次插入1～10后：L.data=");
    ListTraverse(L); 

    printf("ListLength(L)=%d \n",ListLength(L));

    ListInsert(&L,1,0);
    printf("在L的表头插入0后：L.data=");
    ListTraverse(L); 
    printf("ListLength(L)=%d \n",ListLength(L));

    GetElem(L,5,&e);
    printf("第5个元素的值为：%d\n",e);
    for(j=3;j<=4;j++)
    {
            k=LocateElem(L,j);
            if(k)
                    printf("第%d个元素的值为%d\n",k,j);
            else
                    printf("没有值为%d的元素\n",j);
    }
    

    k=ListLength(L); /* k为表长 */
    for(j=k+1;j>=k;j--)
    {
            i=ListDelete(&L,j,&e); /* 删除第j个数据 */
            if(i==ERROR)
                    printf("删除第%d个数据失败\n",j);
            else
                    printf("删除第%d个的元素值为：%d\n",j,e);
    }
    printf("依次输出L的元素：");
    ListTraverse(L); 

    j=5;
    ListDelete(&L,j,&e); /* 删除第5个数据 */
    printf("删除第%d个的元素值为：%d\n",j,e);

    printf("依次输出L的元素：");
    ListTraverse(L); 

    i=ClearList(&L);
    printf("\n清空L后：ListLength(L)=%d\n",ListLength(L));
    CreateListHead(&L,20);
    printf("整体创建L的元素(头插法)：");
    ListTraverse(L); 
    
    i=ClearList(&L);
    printf("\n删除L后：ListLength(L)=%d\n",ListLength(L));
    CreateListTail(&L,20);
    printf("整体创建L的元素(尾插法)：");
    ListTraverse(L); 


    return 0;
}



