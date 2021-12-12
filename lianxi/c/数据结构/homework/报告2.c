#include<stdio.h>
#include<stdlib.h>

#define maxsize 100
typedef struct 
{
	char data[maxsize];
	int top;
}SqStack;
void InitStack(SqStack *s)
{
    s->top=-1;
}
void push(SqStack *S,char e)//向栈里添加数据
{
	if(S->top==maxsize-1)
	{
		printf("栈满");
	}
	S->top++;
	S->data[S->top]=e;
}
void travers(SqStack *S,char e[])//判断是否是回文
{
	if(S->top==-1)
	{
		printf("栈空");
	}
	else
	{
		int flag=0;
	    for(int i=0;e[i]!='\0';i++)
	    {
	    	if(S->data[S->top]!=e[i])
	    	{
	    		flag=1;
	    		printf("不是回文");
	    		break;
			}
			S->top--;
		}
		if(flag==0)
		{
			printf("是回文") ;
		}
	}
}
void travers1(SqStack *S,char e[])
{
	char a;
	if(S->top==-1)
	{
		printf("无");
	}
	else
	{
		while(S->top!=-1)
		{
			a=S->data[S->top];
			printf(" ");
			S->top--;
		}
	}
	
}
int main()
{
	SqStack s;
	InitStack(&s);
	char a[10];
	gets(a);
	for(int i=0;a[i]!='\0';i++)
	{	
		push(&s,a[i]);	
	}
	travers(&s,a);
	//travers1(s,a);

   
 } 

