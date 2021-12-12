#include<stdio.h>
#include<stdlib.h>
#define  MaxSize 100

typedef int Status;

typedef char ElemType;
typedef struct{
    ElemType data[MaxSize];
    int top;
}SqStack;
enum Status{ERROR,OK};

//初始化栈
Status InitStack(SqStack *s)
{
    s->top=-1;
	return OK;
}
//入栈
Status Push(SqStack *s)
{
    ElemType x;
    while(x!='\n')
	{
        scanf("%c",&x);
        s->data[++s->top]=x;

    };
	return OK;
}
//判断合法性
int JudgeLegal(SqStack *s)
{
    int i=0;
    int j=0;
    int k=0;
    while(s->data[i]!='\0')
	{
        switch(s->data[i])
		{
            case 'I':j++;break;
            case 'O':k++;if(k>j){return -1;}break;
        }
        i++;
    }
    if(j!=k)
	{
        return -1;
    }
	else
	{
        return 0;
    }
}
int main(int argc,char* argv[])
{
    SqStack S;
    InitStack(&S);

    Push(&S);

    if(JudgeLegal(&S))
	{
        printf("序列不合法\n");
    }
	else
	{
        printf("序列合法!\n");
    }

    return 0;
}

