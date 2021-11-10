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
typedef struct 
{
   ElemType data[MAXSIZE];//数组创建
   int length; /* 链表长度*/
}SqList;

//初始化线性表
Status InitList(SqList *L){
    L->length = 0;
    return OK;
}

//判断空表
Status ListEmpty(SqList L){
    if(L.length==0)
        return TRUE;
    else
        return ERROR;
}

//设置为空表
Status ClearList(SqList *L){
    L->length=0;
    return OK;
}

//表的长度
Status ListLength(SqList L){
    return L.length;
}

//取出表中第i个值(第一位置在0处)
Status GetElem(SqList L,int i,ElemType *e){
    if(L.data==0||i<1||i>L.length)
        return ERROR;
    *e = L.data[i-1];
}

//返回与e相等的元素的下标
int LocateElem(SqList L,ElemType e)
{
    int i;
    if (L.length==0)
            return 0;
    for(i=0;i<L.length;i++)
    {
            if (L.data[i]==e)
                    break;
    }
    if(i>=L.length)
            return 0;

    return i+1;
}

//第i个位置插入
Status ListInsert(SqList *L,int i,ElemType e){
    int K;
    if(L->length==MAXSIZE)
        return ERROR;
    if(i<1||i>L->length+1)
        return ERROR;

    if(i<=L->length){
        for(K=L->length-1;K>=i-1;K--){  //元素后移一位
            L->data[K+1]=L->data[K];
        }
    }
    L->data[i-1]=e;
    L->length++;
    return OK;
}

//删除
Status ListDelete(SqList *L,int i,ElemType *e){
    int K;
    if(L->length==0)
        return ERROR;
    if(i<1||i>L->length)
        return ERROR;
    *e = L->data[i-1];
    if(i<L->length){
        for(K=i;K<L->length;K++){
            L->data[K-1]=L->data[K];
        }
    }
    L->length--;
    return OK;
    
}

//输出每一个元素
Status visit(ElemType c)
{
    printf("%d ",c);
    return OK;
}
Status ListTraverse(SqList L){
    int i;
    for(i=0;i<L.length;i++)
        visit(L.data[i]);
    printf("\n");
    return OK;
}

/*将所有的在线性表Lb中但不在La中的数据元素插入到La中*/
void unionL(SqList *La,SqList Lb)
{
	int La_len,Lb_len,i;
	ElemType e;                        /*声明与La和Lb相同的数据元素e*/
	La_len=ListLength(*La);            /*求线性表的长度 */
	Lb_len=ListLength(Lb);
	for (i=1;i<=Lb_len;i++)
	{
		GetElem(Lb,i,&e);              /*取Lb中第i个数据元素赋给e*/
		if (!LocateElem(*La,e))        /*La中不存在和e相同数据元素*/
			ListInsert(La,++La_len,e); /*插入*/
	}
}

int main()
{
        
    SqList L;
	SqList Lb;
    
    ElemType e;
    Status i;
    int j,k;
    i=InitList(&L);
    printf("初始化L后：L.length=%d\n",L.length);
    for(j=1;j<=5;j++)
            i=ListInsert(&L,1,j);
    printf("在L的表头依次插入1～5后：L.data=");
    ListTraverse(L); 

    printf("L.length=%d \n",L.length);
    i=ListEmpty(L);
    printf("L是否空：i=%d(1:是 0:否)\n",i);

    i=ClearList(&L);
    printf("清空L后：L.length=%d\n",L.length);
    i=ListEmpty(L);
    printf("L是否空：i=%d(1:是 0:否)\n",i);

    for(j=1;j<=10;j++)
            ListInsert(&L,j,j);
    printf("在L的表尾依次插入1～10后：L.data=");
    ListTraverse(L); 

    printf("L.length=%d \n",L.length);

    ListInsert(&L,1,0);
    printf("在L的表头插入0后：L.data=");
    ListTraverse(L); 
    printf("L.length=%d \n",L.length);

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

	//构造一个有10个数的Lb
	i=InitList(&Lb);
    for(j=6;j<=15;j++)
            i=ListInsert(&Lb,1,j);

	unionL(&L,Lb);

	printf("依次输出合并了Lb的L的元素：");
    ListTraverse(L); 

    return 0;
}


