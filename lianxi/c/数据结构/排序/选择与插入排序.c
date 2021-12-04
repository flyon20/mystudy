#include <stdio.h>    
#include <stdlib.h> 
#include <string.h>

#include <math.h>  
#include <time.h>

#define MAXSIZE 10000

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
//选择排序
void SelectSort(SqList *L)
{
    int i,j,min;

    for(i=1;i<L->length;i++)
    {
        min=i;
        for(j=i+1;j<=L->length;j++)
        {
            if(L->r[min]>L->r[j])
                min=j;
        }
        if(i!=min)
            swap(L,i,min);
    }

}

//直接插入排序
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

int main()
{
    int i;
   
//    int d[N]={5,3,4,6,2};
   
   int d[N]={9,1,5,8,3,7,4,6,2};

   SqList l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
   
   for(i=0;i<N;i++)
     l0.r[i+1]=d[i];
   l0.length=N;
   l1=l2=l3=l4=l5=l6=l7=l8=l9=l10=l11=l0;
   printf("排序前:\n");
   print(l0);

      printf("选择排序:\n");
   SelectSort(&l3);
   print(l3);
   
   printf("直接插入排序:\n");
   InsertSort(&l4);
   print(l4);

}
