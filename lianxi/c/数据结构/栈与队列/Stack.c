//顺序栈
# include <stdio.h>
# include <stdlib.h>
# include <time.h>
# include <math.h>

#define OK 1
#define errno 0
#define true 1
#define flase 0
#define MAXSIZE 20
//将以下数据类型规定好
typedef int Status;
typedef int SElemType;

typedef struct{
    SElemType date[MAXSIZE];//存储空间
    int top;//栈顶指针
}SqStack;

Status visit(SElemType c){
    printf("%d",c);
    return OK;
}

//构造空栈
Status InitStack(SqStack *S){
    S->top=-1;
    return OK;
}

//将栈清空
Status ClearStack(SqStack *S){
    S->top=-1;
    return OK;
}
//返回栈长度
Status StackLength(SqStack S){
    return S.top+1;
}
//栈的判断,为空返回值
Status StackEmpty(SqStack S){
    if(S.top==-1){
        return true;
    }
    else{
        return flase;

    }
}

//栈非空返回元素值
Status GetTop(SqStack S,SElemType *e){
    if(S.top == -1)/*使用S.top是因为这里的S不是指针，所以不能用指针S->top*/
        return errno;
    else 
        return *e=S.date[S.top];//返回元素值

    return OK;
}


//压栈（进栈），插入算法，插入e为栈顶元素
Status Push(SqStack *S,SElemType e){
    if(S->top == MAXSIZE-1){
        return errno;//判断栈满
    }
    S->top++;//栈顶指针加一
    S->date[S->top]=e;//将元素给栈顶指针，即成功插入
    return OK;
}
//出栈，删除栈算法，用e返回值
Status Pop (SqStack *S,SElemType *e){
    if(S->top == -1){
        return errno;//判断
    }
    *e = S->date[S->top];//将值赋给e
    S->top--;//栈顶指针减一
    return OK;
}

//从栈底到栈顶依次显示每一个元素

Status StackTraverse(SqStack S){
    int i=0;
    while (i<=S.top){
        visit(S.date[i++]);
    }
    printf("\n");
    return OK;
}

int main(){
    int j;
    SqStack s;
    int e;
        if(InitStack(&s)==OK)
                for(j=1;j<=10;j++)
                        Push(&s,j);

        printf("栈中元素依次为：");
        StackTraverse(s);

        Pop(&s,&e);
        printf("弹出的栈顶元素 e=%d\n",e);
        printf("栈空否：%d(1:空 0:否)\n",StackEmpty(s));

        GetTop(s,&e);
        printf("栈顶元素 e=%d 栈的长度为%d\n",e,StackLength(s));
        
        ClearStack(&s);
        printf("清空栈后，栈空否：%d(1:空 0:否)\n",StackEmpty(s));
        
        return 0;
}








