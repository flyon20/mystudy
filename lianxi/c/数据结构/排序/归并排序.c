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

//归并排序
//Mrege用于在归并时对值的交换
void Merge(int SR[],int TR[],int i,int m,int n)
{
	int j,k,l;
	for(j=m+1,k=i;i<=m && j<=n;k++)	/* 将SR中记录由小到大地并入TR */
	{
		if (SR[i]<SR[j])
			TR[k]=SR[i++];
		else
			TR[k]=SR[j++];
	}
	if(i<=m)
	{
		for(l=0;l<=m-i;l++)
			TR[k+l]=SR[i+l];		//将SR数组值赋到TR
	}
	if(j<=n)
	{
		for(l=0;l<=n-j;l++)
			TR[k+l]=SR[j+l];		
	}
}

//递归法归并
void MSort(int SR[],int TR1[],int s, int t)
{
	int m;
	int TR2[MAXSIZE+1];
	if(s==t)
		TR1[s]=SR[s];
	else
	{
		m=(s+t)/2;				//将SR数组在m出断开，分为两部分
		MSort(SR,TR2,s,m);		//将SR的i到m数组值归并为有序的TR数组
		MSort(SR,TR2,m+1,t);	
		Merge(TR2,TR1,s,m,t);	//将TR2[s..m]和TR2[m+1..t]归并到TR1[s..t]
	}
}
void MergeSort(SqList *L)
{ 
 	MSort(L->r,L->r,1,L->length);
}

//顺序法归并排序
void MergePass(int SR[],int TR[],int s,int n)
{
	int i=1;
	int j;
	while(i <= n-2*s+1)
	{
		Merge(SR,TR,i,i+s-1,i+2*s-1);
		i=i+2*s;        
	}
	if(i<n-s+1) //归并最后两个序列
		Merge(SR,TR,i,i+s-1,n);
	else //出现最后的单个子序列也归并进来
		for(j =i;j <= n;j++)
			TR[j] = SR[j];
}
void MergeSort2(SqList *L)
{
	int* TR=(int*)malloc(L->length * sizeof(int));
    int k=1;
	while(k<L->length)
	{
		MergePass(L->r,TR,k,L->length);
		k=2*k;//子序列长度加倍，因为这里是二路归并所以这样
		MergePass(TR,L->r,k,L->length);
		k=2*k;  
	}
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
    printf("归并排序（递归）:\n");
    MergeSort(&l7);
    print(l7);

    printf("归并排序（非递归）:\n");
    MergeSort2(&l8);
    print(l8);
}

