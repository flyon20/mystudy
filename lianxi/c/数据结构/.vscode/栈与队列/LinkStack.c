//链栈
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

typedef struct StackNode
{
    SElemType data;      /* data */
    struct StackNode *next;
}StackNode,*LinkStackPtr;

typedef struct 
{
    LinkStackPtr top;/* 设置栈顶指针 ，栈顶指针就是头指针，也就是说没有了头指针，因为不需要*/
    int count;
}LinkStack;
//构造空栈
Status InitStack(LinkStack *S){
    S->top = (LinkStackPtr)malloc(sizeof(StackNode));//进行动态存储分配
    if(!S->count){
        return ERROR;
    }
    S->top=NULL;
    S->count=0;
    return OK;
}
//设置为空栈
Status ClearStack(LinkStack *S){
    LinkStackPtr p,q;
    p=S->top;
    while(p){
        q=p;//把p给q为了方便后续释放内存
        p=p->next;
        free(q);
    }
    S->count=0;
    return OK;

}

//栈的判断
Status StackEmpty(LinkStack S){
    if(S.count==0)
        return TRUE;
    else
        return FALSE;
    
}
//栈的元素个数即栈的长度
Status StackLength(LinkStack S){
    return S.count;
}

//返回栈顶元素
Status GetTop(LinkStack S,SElemType *e){
    if (S.top==0)
        return ERROR;
    else
        *e = S.top->data;
   return OK;

}

//压栈，插入算法
Status Push(LinkStack *S,SElemType e){
    LinkStackPtr s=(LinkStackPtr)malloc(sizeof(StackNode)); //动态分配一个新的节点s
    s->data=e;
    s->next=S->top;//将当前的栈顶元素赋值给新的节点的直接后继元素，意思是就是新节点的指针域指向现在的栈顶元素
    S->top=s;//将栈顶指针指向新的节点s
    S->count++;

    return OK;
}
//出栈，删除,用e返回值
Status Pop(LinkStack *S,SElemType *e){
    LinkStackPtr p;
    if(StackEmpty(*S))
        return ERROR;//判断空否
    *e=S->top->data;//该节点的data域
    p=S->top;//取出来释放
    S->top=S->top->next;//栈顶指针指向下一个元素
    free(p);
    S->count--;

    return OK;
}
 
 //从栈底到栈顶依次显示每一个元素
 Status visit(SElemType c){
    printf("%d",c);
    return OK;
 }
 Status StackTraverse(LinkStack S){
     LinkStackPtr p;
     p=S.top;//p为当前节点
     while(p){
         visit(p->data);
         p=p->next;
     }
     printf("\n");
     return OK;
 }

 int main(){
     int j;
        LinkStack s;
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