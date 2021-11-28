#include <stdio.h>    
#include <stdlib.h> 

#include <math.h>  
#include <time.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

#define MAXSIZE 100

typedef int Status;

int F[100];

//顺序查找，无哨兵
int Sequential_Search(int *a,int n,int key)
{
	int i;
	for(i=1;i<=n;i++)
	{
		if (a[i]==key)
			return i;
	}
	return 0;
}

//顺序查找改进版，即加设哨兵
int Sequential_Search_Pro(int *a,int n,int key)
{
	int i;
	a[0]=key;//哨兵，即省略每一次数组越界的判断
	i=n;
	while(a[i]!=key)
	{
		i--;
	}
	return i;
}

//二分查找，即折半查找
int Binary_Search(int *a,int n,int key)
{
	int low,high,mid;
	low=1;	//最低下标
	high=n;	//最高下标
	while(low<=high)
	{
		mid=(low+high)/2;	//折半
		if (key<a[mid])		//与中值的判断
			high=mid-1;		//最高下标调整到中位下标小一位 
		else if (key>a[mid])//若查找值比中值大 
			low=mid+1;		//最低下标调整到中位下标大一位
		else
		{
			return mid;		//若相等则说明mid即为查找到的位置
		}
		
	}
	return 0;
}
//插值查找，即二分查找的另一表现形式
int Interpolation_Search(int *a,int n,int key)
{
	int low,high,mid;
	low=1;	
	high=n;	
	while(low<=high)
	{
		mid=low+ (high-low)*(key-a[low])/(a[high]-a[low]); //插值,注意仅这一处与折半有区别
		if (key<a[mid])		
			high=mid-1;		
		else if (key>a[mid])
			low=mid+1;		
		else
			return mid;		
	}
	return 0;
}

//斐波那契查找
//该斐波那契数列数组为{0，1,1,2,3,5,8,13,21,34,}
int Fibonacci_Search(int *a,int n,int key)
{
	int low,high,mid,i,k=0;
	low=1;						//最小下标
	high=n;						//最高下标
	while(n>F[k]-1)//计算斐波那契位置
		k++;//斐波那契数列下标
	for (i=n;i<F[k]-1;i++)//补全数值，避免查找最大的数值时斐波那契数组在此处没有数值
		a[i]=a[n];
	while(low<=high)
	{
		mid=low+F[k-1]-1;//计算分隔下标
		if (key<a[mid])//查找记录小于分隔记录
		{
			high=mid-1;		
			k=k-1;
		}
		else if (key>a[mid])//查找记录大于分隔记录
		{
			low=mid+1;		
			k=k-2;
		}
		else//相等
		{
			if (mid<=n)
				return mid;		
			else 
				return n;
		}
	}
	return 0;
}

int main(void)
{    

	int a[MAXSIZE+1],i,result;
	int arr[MAXSIZE]={0,1,16,24,35,47,59,62,73,88,99};
		
	for(i=0;i<=MAXSIZE;i++)
	{
		a[i]=i;
	}
	result=Sequential_Search(a,MAXSIZE,MAXSIZE);
	printf("Sequential_Search:%d \n",result);
	result=Sequential_Search_Pro(a,MAXSIZE,1);
	printf("Sequential_Search_Pro:%d \n",result);

	result=Binary_Search(arr,10,62);
	printf("Binary_Search:%d \n",result);

	
	result=Interpolation_Search(arr,10,62);
	printf("Interpolation_Search:%d \n",result);

	
	F[0]=0;
	F[1]=1;
	for(i = 2;i < 100;i++)  
	{ 
		F[i] = F[i-1] + F[i-2];  
	} 
	result=Fibonacci_Search(arr,10,62);
	printf("Fibonacci_Search:%d \n",result);
	
	return 0;
}
