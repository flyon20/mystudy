#include <stdio.h>    
#include <stdlib.h> 
#include <string.h>

#include <math.h>  
#include <time.h>

#define MAXSIZE 100
#define errno 0
#define true 1
#define flase 0
#define OK 1

typedef int Status; 
typedef char SElemType;

typedef struct 
{
    char data[MAXSIZE];/* data */
    int top;
}HW;
Status InitStack(HW *S){
    S->top=-1;
    return OK;
}
Status Push(HW *S,SElemType e){
    if(S->top == MAXSIZE-1){
        return errno;//判断栈满
    }
    S->data[++S->top]=e;
}
Status Pop(HW *S,SElemType *e){
    *e=S->data[S->top--];
}
Status StackEmpty(HW S){
    if(S.top==-1){
        return true;
    }
    else{
        return flase;

    }
}
int main(){
    char a[MAXSIZE],e[MAXSIZE];
    HW s;
    int i,len,mid,next,top=0;
    gets(a);
    len=strlen(a);
    mid=len/2-1;
    //将mid下标之前字符的入栈
    if(InitStack(&s)==OK)
        for(i=0;i<=mid;i++)
            e[i]=a[i];
            Push(&s,e[i]);
    //判断字符串长度为奇数还是偶数，寻找合适下标
    if(len%2==0)
        next=mid+1;
    else
        next=mid+2;
    for(i=next;i<=len-1;i++){
        e[i]=a[i];
        if(a[i]!=Pop(&s,e[i]))
            break;
        Pop(&s,e[i]);
    }
    if(StackEmpty(s))
        printf("是回文\n");
    else
        printf("不是回文\n");

    }



