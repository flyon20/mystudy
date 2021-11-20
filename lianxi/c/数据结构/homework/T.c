#include <stdio.h>
int j(int n){
    if(n==1)
        return 1;
    else
        return (j(n-1)*n);

}
int main(){
    int m,s=1;
    char i;
    
    do
    {
    printf("输入\n");
    scanf("%d",&m);
    getchar();
    j(m);
    printf("%d",j(m));

    printf("\n判断");
    scanf("%c",&i);
    getchar();

    
    }while(i=='Y');
    
    return 0;

}