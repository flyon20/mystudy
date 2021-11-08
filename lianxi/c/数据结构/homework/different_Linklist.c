/*
已知A和B表是两个集合，其元素的值递增排列；设计一个算法，求A和B的差集，
（即出现在A中但是不在B中） 结果放在A中，同时返回元素的个数。 
*/
#include <stdio.h>    
#include <stdlib.h>   

#include <math.h> 
#include <time.h>
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAX 100
 
typedef struct LNode {
	int data;
	struct LNode *next;
}LNode,*LinkList;
 
int InitList(LinkList *L) 
{ 
    *L=(LinkList)malloc(sizeof(LNode)); /* 产生头结点,并使L指向此头结点 */
    if(!(*L)) /* 存储分配失败 */
            return ERROR;
    (*L)->next=NULL; /* 指针域为空 */

    return OK;
}
 
int ListLength(LinkList L)
{
    int i=0;
    LinkList p=L->next; /* p指向第一个结点 */
    while(p)                        
    {
        i++;
        p=p->next;
    }
    return i;
}

void TraveList(LinkList L){
	struct LNode *p;
	p=L->next;
	while(p){
		printf("%d ",p->data);
		p=p->next;
	}
	printf("\n");
}
 
void CreateList(LinkList *L,int n){
	*L=(LinkList)malloc(sizeof(LNode));
	(*L)->next=NULL;
	struct LNode *r;
	r=L;
	for(int i=0;i<n;i++){
		printf("请输入第%d个元素的值:",i+1);
		
	LinkList s=(LinkList)malloc(sizeof(LNode));
		scanf("%d",&s->data);
		s->next=NULL;
		r->next=s;
		r=s;
	}
}
 
void DiffSet(LinkList *L1,LinkList *L2,LinkList *L3){
	LinkList pa,pb,pc;
	pa=(*L1)->next;
	pb=(*L2)->next;
	pc=L3=L1;
	
	while(pa&&pb){
		if(pa->data<pb->data){
			pc=pa;
			pa=pa->next;
		}else if(pa->data>pb->data){
			//pc=pa;
			pb=pb->next;
		}else if(pa->data==pb->data){
//			pc=pa;
//			pa=pa->next;
//			pb=pb->next;
//			pc=pa;
			pc->next=pa->next;
			pa=pa->next;
		}
	}
}
int main(){
	LinkList L1,L2,L3;
	
	if(InitList(&L1)){
		printf("L1初始化成功!\n");
	}else{
		printf("L1初始化失败!\n");
	}
	
	if(InitList(&L2)){
		printf("L2初始化成功!\n");
	}else{
		printf("L2初始化失败!\n");
	}
	
	if(InitList(&L3)){
		printf("L3初始化成功!\n");
	}else{
		printf("L3初始化失败!\n");
	}
	
	printf("请输入L1的长度:");
	int n1;
	scanf("%d",&n1);
	CreateList(&L1,n1);
	TraveList(L1);
	
	printf("请输入L2的长度:");
	int n2;
	scanf("%d",&n2);
	CreateList(&L2,n2);
	TraveList(L2);
	
	DiffSet(&L1,&L2,&L3);
	TraveList(L3);
	printf("差集的元素个数:%d",ListLength(L3)); 

}