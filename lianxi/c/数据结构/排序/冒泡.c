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
//冒泡阉割版
void BubbleSort_(SqList *L)
{
    int i,j;
    for(i=1;i<L->length;i++){
        for(j=i+1;j<=L->length;j++)
        {
            if(L->r[i]<L->r[j])
                swap(L,i,j);
        }
    }
}
//冒泡排序
void BubbleSort(SqList *L)
{
    int i,j;
    for(i=1;i<L->length;i++)
    {
        for(j=L->length-1;j>=i;j--)
        {
            if(L->r[j]<L->r[j+1])
                swap(L,j,j+1);
        }
    }
}
//冒泡排序升级版，建议DeBug查看过程更为清晰
void BubbleSort_Pro(SqList *L)
{
    int i,j;
    Status flag=TRUE;
    for(i=1;i<L->length&&flag;i++)//flag为TRUE可以循环，否则终止循环
    {
        flag=FALSE;
        for (j=L->length-1;j>=i;j--)
        {
            if(L->r[j]<L->r[j+1])
            {
                swap(L,j,j+1);
                flag=TRUE;//有数据交换
            }
        }
        
    }

}

int main(){
       int i;
   
   //int d[N]={9,1,5,8,3,7,4,6,2};
   
   int d[N]={9,8,7,6,5,4,2,1,3};

   SqList l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
   
   for(i=0;i<N;i++)
     l0.r[i+1]=d[i];
   l0.length=N;
   l1=l2=l3=l4=l5=l6=l7=l8=l9=l10=l11=l0;
   printf("排序前:\n");
   print(l0);

   printf("低配冒泡排序:\n");
   BubbleSort_(&l0);
   print(l0);
   
   printf("冒泡排序:\n");
   BubbleSort(&l1);
   print(l1);
   
   printf("改进冒泡排序:\n");
   BubbleSort_Pro(&l2);
   print(l2);
}

