#include <stdio.h>    
#include <string.h>
#include <ctype.h>      
#include <stdlib.h>   
#include <io.h>  
#include <math.h>  
#include <time.h>


#define MAXSIZE 10000
#define MAX_LENGTH_INSERT_SORT 7

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define N 9

typedef int Status;

typedef struct
{
	int r[MAXSIZE+1];	//用于存储要排序数组，r[0]用作哨兵或临时变量
	int length;			//用于记录顺序表的长度 
}SqList;
//交换下标值
void swap(SqList *L,int i,int j) 
{ 
	int temp=L->r[i]; 
	L->r[i]=L->r[j]; 
	L->r[j]=temp; 
}
//输出
void print(SqList L)
{
	int i;
	for(i=1;i<L.length;i++)
		printf("%d,",L.r[i]);
	printf("%d",L.r[i]);
	printf("\n");
}

//快排
int Partition(SqList *L,int low,int high)
{ 
	int pivotkey;

	pivotkey=L->r[low]; //用子表的第一个记录作枢轴记录
	while(low<high) //从表的两端交替地向中间扫描
	{ 
		 while(low<high&&L->r[high]>=pivotkey)
			high--;
		 swap(L,low,high);//将比枢轴记录小的记录交换到低端
		 while(low<high&&L->r[low]<=pivotkey)
			low++;
		 swap(L,low,high);//将比枢轴记录大的记录交换到高端
	}
	return low; //返回枢轴所在位置
}

//对顺序表L中的子序列L->r[low..high]作快速排序
void QSort(SqList *L,int low,int high)
{ 
	int pivot;
	if(low<high)
	{
			pivot=Partition(L,low,high); //将L->r[low..high]一分为二，算出枢轴值pivot
			QSort(L,low,pivot-1);		
			QSort(L,pivot+1,high);		
	}
}

void QuickSort(SqList *L)
{ 
	QSort(L,1,L->length);
}

//快排改进
int Partition1(SqList *L,int low,int high)
{ 
	int pivotkey;

	int m = low + (high - low) / 2; /* 计算数组中间的元素的下标 */  
	if (L->r[low]>L->r[high])			
		swap(L,low,high);	/* 交换左端与右端数据，保证左端较小 */
	if (L->r[m]>L->r[high])
		swap(L,high,m);		/* 交换中间与右端数据，保证中间较小 */
	if (L->r[m]>L->r[low])
		swap(L,m,low);		/* 交换中间与左端数据，保证左端较小 */
	
	pivotkey=L->r[low]; /* 用子表的第一个记录作枢轴记录 */
	L->r[0]=pivotkey;  /* 将枢轴关键字备份到L->r[0] */
	while(low<high) /*  从表的两端交替地向中间扫描 */
	{ 
		 while(low<high&&L->r[high]>=pivotkey)
			high--;
		 L->r[low]=L->r[high];
		 while(low<high&&L->r[low]<=pivotkey)
			low++;
		 L->r[high]=L->r[low];
	}
	L->r[low]=L->r[0];
	return low; /* 返回枢轴所在位置 */
}

void QSort1(SqList *L,int low,int high)
{ 
	int pivot;
	if((high-low)>MAX_LENGTH_INSERT_SORT)
	{
		pivot=Partition1(L,low,high); /*  将L->r[low..high]一分为二，算出枢轴值pivot */
		QSort1(L,low,pivot-1);		/*  对低子表递归排序 */
		QSort1(L,pivot+1,high);		/*  对高子表递归排序 */
	}
	else
		InsertSort(L);
}

/* 对顺序表L作快速排序 */
void QuickSort1(SqList *L)
{ 
	QSort1(L,1,L->length);
}

/* 尾递归 */
void QSort2(SqList *L,int low,int high)
{ 
	int pivot;
	if((high-low)>MAX_LENGTH_INSERT_SORT)
	{
		while(low<high)
		{
			pivot=Partition1(L,low,high); /*  将L->r[low..high]一分为二，算出枢轴值pivot */
			QSort2(L,low,pivot-1);		/*  对低子表递归排序 */
			low=pivot+1;	/* 尾递归 */
		}
	}
	else
		InsertSort(L);
}
void InsertSort(SqList *L)
{
    int i,j;
    for(i=2;i<=L->length;i++)
    {
        if(L->r[i]<L->r[i-1])
        {
        L->r[0]=L->r[i];
        for(j=i-1;L->r[j]>L->r[0];j--)
            L->r[j+1]=L->r[j];
        L->r[j+1]=L->r[0];
        }
    }
}


/* 对顺序表L作快速排序(尾递归) */
void QuickSort2(SqList *L)
{ 
	QSort2(L,1,L->length);
}

int main()
{
    int i;
   
   /* int d[N]={9,1,5,8,3,7,4,6,2}; */
    int d[N]={50,10,90,30,70,40,80,60,20};
    /* int d[N]={9,8,7,6,5,4,3,2,1}; */

    SqList l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
   
    for(i=0;i<N;i++)
        l0.r[i+1]=d[i];
    l0.length=N;
    l1=l2=l3=l4=l5=l6=l7=l8=l9=l10=l11=l0;
    printf("排序前:\n");
    print(l0);
    printf("快速排序:\n");
    QuickSort(&l9);
    print(l9);

    printf("改进快速排序:\n");
    QuickSort1(&l10);
    print(l10);

    printf("改进快速排序(尾递归):\n");
    QuickSort2(&l11);
    print(l11);
	
}
