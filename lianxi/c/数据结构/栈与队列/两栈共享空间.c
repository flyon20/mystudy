//两栈共享空间，顺序栈结构
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
typedef int SElemType;

typedef struct 
{
    SElemType data[MAXSIZE];
    int top1;
    int top2;       /* 栈顶指针 */
}SqDoubleStack;

//构造空栈
Status InitStack(SqDoubleStack *S)
{ 
        S->top1=-1;
        S->top2=MAXSIZE;
        return OK;
}

//设置为空栈
Status ClearStack(SqDoubleStack *S)
{ 
        S->top1=-1;
        S->top2=MAXSIZE;
        return OK;
}

//栈空判断
Status StackEmpty(SqDoubleStack S)
{ 
        if (S.top1==-1 && S.top2==MAXSIZE)
                return TRUE;
        else
                return FALSE;
}

//栈长度
int StackLength(SqDoubleStack S)
{ 
        return (S.top1+1)+(MAXSIZE-S.top2);
}

//入栈
Status Push(SqDoubleStack *S,SElemType e,int stackNumber)
{
        if (S->top1+1==S->top2)	//栈满判断
                return ERROR;	
        if (stackNumber==1)			//栈一进栈
                S->data[++S->top1]=e; //若是栈1先top1+1后给数组元素赋值
        else if (stackNumber==2)	//栈二进栈
                S->data[--S->top2]=e; //若是栈2先top2-1后给数组元素赋值
        return OK;
}

//出栈
Status Pop(SqDoubleStack *S,SElemType *e,int stackNumber)
{ 
        if (stackNumber==1) 
        {
                if (S->top1==-1) 
                        return ERROR; //判断
                *e=S->data[S->top1--]; //出栈
        }
        else if (stackNumber==2)
        { 
                if (S->top2==MAXSIZE) 
                        return ERROR; //判断
                *e=S->data[S->top2++]; //出栈
        }
        return OK;
}
//输出元素
Status visit(SElemType c){
    printf("%d",c);
    return OK;
 }
Status StackTraverse(SqDoubleStack S)
{
        int i=0;
        while(i<=S.top1)
        {
                visit(S.data[i++]);
        }
        i=S.top2;
        while(i<MAXSIZE)
        {
                visit(S.data[i++]);
        }
        printf("\n");
        return OK;
}




int main()
{
        int j;
        SqDoubleStack s;
        int e;
        if(InitStack(&s)==OK)
        {
                for(j=1;j<=5;j++)
                        Push(&s,j,1);
                for(j=MAXSIZE;j>=MAXSIZE-2;j--)
                        Push(&s,j,2);
        }

        printf("栈中元素依次为：");
        StackTraverse(s);

        printf("当前栈中元素有：%d \n",StackLength(s));

        Pop(&s,&e,2);
        printf("弹出的栈顶元素 e=%d\n",e);
        printf("栈空否：%d(1:空 0:否)\n",StackEmpty(s));

        for(j=6;j<=MAXSIZE-2;j++)
                Push(&s,j,1);

        printf("栈中元素依次为：");
        StackTraverse(s);

        printf("栈满否：%d(1:否 0:满)\n",Push(&s,100,1));

        
        ClearStack(&s);
        printf("清空栈后，栈空否：%d(1:空 0:否)\n",StackEmpty(s));
        
        return 0;
}