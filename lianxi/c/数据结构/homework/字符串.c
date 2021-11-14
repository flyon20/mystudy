#include <stdio.h>    
#include <stdlib.h> 
#include <string.h>

#define ERROR 0
#define TRUE 1

int insert(char *s,char *t,int pos){
        int len1=0,len2=0;
        char p[100];
        int i,j=0;
        len1=strlen(s);//字符串长度
        len2=strlen(t);

        // max=len1>len2?len1:len2;

        for(i=pos-1;i<len1;i++){
            p[j++]=s[i];
        }
        
        p[j]='\0';
        i=pos-1;
        while(*t!='\0'){
            s[i++]=*t++;
        }

        strcat(s,p);
        if(strlen(s)!=(len1+len2))
            return ERROR;
        else 
            return TRUE;
     
}

int main(){
    char s[30]="abbsf";
    char t[20]="o4o4";

    int pos=4;
    printf("插入前s=%s\n",s);
    int tel=0;
    tel=insert(s,t,pos);
    printf("插入后s=%s\n",s);
    printf("成功否:%d (1：成功，0：失败)\n",tel);

}