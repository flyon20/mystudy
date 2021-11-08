//同问题，不同表述
#include <stdio.h>    
#include <stdlib.h>   

#include <math.h> 
#include <time.h>
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAX 100

//定义存储
typedef struct LNode
{
    int date;
    struct LNode *next;
} Lnode, *Linklist;

//链表初始化 
void init(Linklist *L)
{
    *L=(Linklist)malloc(sizeof(Lnode)); // 开辟空间
    (*L)->next = NULL; //头节点置为空
}
//输出数据
void output(Linklist T)
{
    Linklist p = T;
    p = p->next;
    while (p)
    {
        printf("%d",p->date);
        p = p->next;
    }
}
//后插法构建链表
void CreateLiklist(Linklist *L, int n)
{
    Linklist r = *L;
    for (int i = 0; i < n; i++)
    {
        Linklist p = (Linklist)malloc(sizeof(Lnode)); //开辟空间，p为节点
        printf("\n请输入%d个数据\n", i + 1);
        printf("%d",p->date);
        p->next = NULL;
        r->next = p; //将新节点插入r之后
        r = p;       //r指向新的尾节点
    }
}
void Difference(Linklist *La, Linklist *Lb, int *n)
{
    Linklist pa = (*La)->next;
    Linklist pb = (*Lb)->next;
    Linklist pre = *La;
    while (pa && pb)
    {
        if (pa->date < pb->date)
        {
            pre = pa;
            pa = pa->next;
            n++;
        }
        else if (pa->date > pb->date)
        {
            pb = pb->next;
        }
        else
        {
            pre->next = pa->next;
            Linklist u = pre;
            pa = pa->next;
            free(u);
        }
    }
}
int main()
{
    Linklist La, Lb, Lc;
    //初始化
    init(&La);
    init(&Lb);
    int n1, n2;
    printf("请输入请输入每条链表的个数");
    scanf("%d %d", &n1, &n2);
    int n;

    //构建链表
    CreateLiklist(&La, n1);
    CreateLiklist(&Lb, n2);
    Difference(&La, &Lb, &n);
    output(La);
}

