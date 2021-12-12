#include <stdio.h>

// int main()
// {
//     char str1[20];
//     char str2[20]="Hello the world";
//     char *pstr1,*pstr2;
//     int i;
//     for(i=0;i<20;i++)
//         str1[i]='A'+i;
//     pstr1 = str1;
//     pstr2 = str2;
//     printf("str2 = %s\n",pstr2);
//     printf("str1 = %s\n",pstr1);
//     printf("str1 = %s\n",str1);

//     return 0;

// }

int main(){
    int a[5][3];
    int i,j,temp,max1,max2,max3;
    float array;
    for(i=0;i<5;i++)
        for(j=0;j<3;j++)
            scanf("%d",&a[i][j]);
    max1=a[0][0];
    for(i=0;i<5;i++){
        if(a[i][0]<a[i+1][0])
            max1=a[i+1][0];
    }
    printf("%d\n",max1);

    max2=a[0][1];
    for(i=0;i<5;i++){
        if(a[i][1]<a[i+1][1])
            max2=a[i+1][1];
    }
    printf("%d\n",max2);
    max3=a[0][2];
    for(i=0;i<5;i++){
        if(a[i][2]<a[i+1][2])
            max3=a[i+1][2];
    }
    printf("%d",max3);
}