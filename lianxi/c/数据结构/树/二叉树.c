//链式存储
#include <stdio.h>    
#include <stdlib.h> 
#include <string.h>

#include <math.h>  
#include <time.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXSIZE 100
#define ClearBiTree DestroyBiTree

typedef int Status; 
typedef char TElemType;

int treeIndex=1;
typedef char String[24]; //0号单元存放串的长度
String str;
//构造二叉树
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

TElemType Nil=' '; //空
typedef struct BiTNode  //结点
{
   TElemType data;		/* 结点数据 */
   struct BiTNode *lchild,*rchild; /* 左右孩子指针 */
}BiTNode,*BiTree;
//构造空二叉树
Status InitBiTree(BiTree *T)
{ 
	*T=NULL;
	return OK;
}

//销毁二叉树
void DestroyBiTree(BiTree *T)
{ 
	if(*T) 
	{
		if((*T)->lchild) 
			DestroyBiTree(&(*T)->lchild); /* 销毁左孩子子树 */
		if((*T)->rchild) 
			DestroyBiTree(&(*T)->rchild); /* 销毁右孩子子树 */
		free(*T); /* 释放根结点 */
		*T=NULL; /* 空指针赋0 */
	}
}
Status visit(TElemType e)
{
	printf("%c ",e);
	return OK;
}

//前序输入结点值
void CreateBiTree(BiTree *T)
{ 
	TElemType ch;
	
	/* scanf("%c",&ch); */
	ch=str[treeIndex++];

	if(ch=='#') 
		*T=NULL;
	else
	{
		*T=(BiTree)malloc(sizeof(BiTNode));
		if(!*T)
			exit(OVERFLOW);
		(*T)->data=ch; /* 生成根结点 */
		CreateBiTree(&(*T)->lchild); /* 构造左子树 */
		CreateBiTree(&(*T)->rchild); /* 构造右子树 */
	}
}
//判断
Status BiTreeEmpty(BiTree T)
{ 
	if(T)
		return FALSE;
	else
		return TRUE;
}

//深度
int BiTreeDepth(BiTree T)
{
	int i,j;
	if(!T)
		return 0;
	if(T->lchild)
		i=BiTreeDepth(T->lchild);
	else
		i=0;
	if(T->rchild)
		j=BiTreeDepth(T->rchild);
	else
		j=0;
	return i>j?i+1:j+1;
}
//根结点
TElemType Root(BiTree T)
{ 
	if(BiTreeEmpty(T))
		return Nil;
	else
		return T->data;
}

//指向的结点
TElemType Value(BiTree p)
{
	return p->data;
}
//指定结点赋值
void Assign(BiTree p,TElemType value)
{
	p->data=value;
}

//前序遍历
void PreOrderTraverse(BiTree T)
{ 
	if(T==NULL)
		return;
	printf("%c",T->data);/* 显示结点数据，可以更改为其它对结点操作 */
	PreOrderTraverse(T->lchild); /* 再先序遍历左子树 */
	PreOrderTraverse(T->rchild); /* 最后先序遍历右子树 */
}

//中序遍历,左根右
void InOrderTraverse(BiTree T){
    if(T==NULL)
        return ;
    InOrderTraverse(T->lchild);
    printf("%c",T->data);
    InOrderTraverse(T->rchild);
}
//后序遍历，左右根
void PostOrderTraverse(BiTree T){
    if(T==NULL)
        return ;
    PostOrderTraverse(T->lchild);
    PostOrderTraverse(T->rchild);
    printf("%c",T->data);
}

int main()
{
	int i;
	BiTree T;
	TElemType e1;
	InitBiTree(&T);

	
	StrAssign(str,"ABDH#K###E##CFI###G#J##");

	CreateBiTree(&T);

	printf("构造空二叉树后,树空否？%d(1:是 0:否) 树的深度=%d\n",BiTreeEmpty(T),BiTreeDepth(T));
	e1=Root(T);
	printf("二叉树的根为: %c\n",e1);

	printf("\n前序遍历二叉树:");
	PreOrderTraverse(T);
	printf("\n中序遍历二叉树:");
	InOrderTraverse(T);
	printf("\n后序遍历二叉树:");
	PostOrderTraverse(T);
	ClearBiTree(&T);
	printf("\n清除二叉树后,树空否？%d(1:是 0:否) 树的深度=%d\n",BiTreeEmpty(T),BiTreeDepth(T));
	i=Root(T);
	if(!i)
		printf("树空，无根\n");
	
	return 0;
}






