#include <stdio.h>    
#include <stdlib.h> 
#include <string.h>

#include <math.h>  
#include <time.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXSIZE 20

typedef int Status;
typedef int ElemType;

typedef char String[MAXSIZE+1];

// 生成一个其值等于chars的串T
Status StrAssign(String T,char *chars)
{ 
	int i;
	if(strlen(chars)>MAXSIZE)
		return ERROR;
	else
	{
		T[0]=strlen(chars);
		for(i=1;i<=T[0];i++)
			T[i]=*(chars+i-1);
		return OK;
	}
}
//设置为零
Status ClearString(String s){
	s[0]=0;
	return OK;
}

//输出字符串
void StrPrint(String T)
{ 
	int i;
	for(i=1;i<=T[0];i++)
		printf("%c",T[i]);
	printf("\n");
}
//输出next函数的数组值
void NextPrint(int next[],int length)
{ 
	int i;
	for(i=1;i<=length;i++)
		printf("%d",next[i]);
	printf("\n");
}

//串的元素个数
int StrLength(String S)
{ 
	return S[0];
}

//模式匹配
int Index(String S,String T,int pos){
	int i = pos;
	int j = 1;//子串的位置
	while(i<=S[0]&&j<=T[0])
	{
		if(S[i]==T[j])//相等则继续
		{
			i++;
			j++;
		}
		else//不相等则返回首位的下一位
		{
			i=i-j+2;
			j=1;
		}
	}
	if(j>T[0])
			return i-T[0];
		else
		    return OK;

}

//next函数实现
Status get_next(String T,int *next){
	int j=1,k=0;//k为前缀，j为后缀
	next[1]=0;//j==1时
	while (j<T[0])
	{
		if(k==0 || T[j]== T[k]) 
		{
      		j++;  
			k++;  
			next[j] = k;//记录匹配长度
    	} 
		else 
			k= next[k];	//字符串不同回溯
	}
}

//KMP
int Index_KMP(String S, String T, int pos) 
{
	int i = pos;		//i是主串下标值
	int j = 1;			//j是子串下标值
	int next[255];		
	get_next(T, next);	//next数组
	while (i <= S[0] && j <= T[0]) 
	{
		if (j==0 || S[i] == T[j])	
      	{
         	++i;
         	++j; 
      	} 
      	else 			
      	 	j = next[j];/* j退回合适的位置，i值不变 */
	}
	if (j > T[0]) 
		return i-T[0];
	else 
		return 0;
}

void get_nextval(String T, int *nextval) 
{
  	int i,k;
  	i=1;
  	k=0;
  	nextval[1]=0;
  	while (i<T[0])  /* 此处T[0]表示串T的长度 */
 	{
    	if(k==0 || T[i]== T[k]) 	/* T[i]表示后缀的单个字符，T[k]表示前缀的单个字符 */
		{
      		++i;  
			++k;  
			if (T[i]!=T[k])      /* 若当前字符与前缀字符不同 */
				nextval[i] = k;	/* 则当前的j为nextval在i位置的值 */
      		else 
				nextval[i] = nextval[k];	/* 如果与前缀字符相同，则将前缀字符的
				                               nextval值赋值给nextval在i位置的值 */
    	}  
											
		else 
			k= nextval[k];			/* 若字符不相同，则k值回溯 */
  	}
}

int Index_KMP1(String S, String T, int pos) 
{
	int i = pos;		/* i用于主串S中当前位置下标值，若pos不为1，则从pos位置开始匹配 */
	int j = 1;			/* j用于子串T中当前位置下标值 */
	int next[255];		/* 定义一next数组 */
	get_nextval(T, next);	/* 对串T作分析，得到next数组 */
	while (i <= S[0] && j <= T[0]) /* 若i小于S的长度并且j小于T的长度时，循环继续 */
	{
		if (j==0 || S[i] == T[j]) 	/* 两字母相等则继续，与朴素算法增加了j=0判断 */
      	{
         	++i;
         	++j; 
      	} 
      	else 			/* 指针后退重新开始匹配 */
      	 	j = next[j];/* j退回合适的位置，i值不变 */
	}
	if (j > T[0]) 
		return i-T[0];
	else 
		return 0;
}

int main()
{
	int i,*p;
	String s1,s2;
	
	StrAssign(s1,"000000000200000000020000000002000000000200000000020000000001");
	printf("主串为: ");
	StrPrint(s1);
	StrAssign(s2,"0000000001");
	printf("子串为: ");
	StrPrint(s2);
	printf("\n");
	
	printf("\n");
	printf("主串和子串在第%d个字符处首次匹配（朴素模式匹配算法）\n",Index(s1,s2,1));
	printf("主串和子串在第%d个字符处首次匹配（KMP算法） \n",Index_KMP(s1,s2,1));
	printf("主串和子串在第%d个字符处首次匹配（KMP改良算法） \n",Index_KMP1(s1,s2,1));

	return 0;
}



