#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){
    // float x,y,z,f;
    // for(y = 1.5f; y > -1.5f; y-=0.1f)
    // {
    //     for(x = -1.5f; x < 1.5f; x += 0.05f)
    //     {
    //         // if(x*x+(y-powf(x*x,1.0/3))*(y-powf(x*x,1.0/3))-1<0)
    //         //     putchar('*');
    //         // else
    //         //     putchar(' ');
    //         // putchar('\n');
    //     }
    // }
    // getchar();
    int i,a[10];
    printf("输入");
    for(i=0;i<=9;i++)
        scanf("%d",&a[i]);
    for(i=9;i>=0;i--){
        printf("%d",a[i]);
        printf("\n");
    }
    return 0;
}

// #include <stdio.h>
// #define N 14
// void main()
// {
//     int i, j, k, n=0, a[N][N];  /*定义二维数组a[14][14]*/
//     while(n<=0||n>=13){  /*控制打印的行数不要太大，过大会造成显示不规范*/
//         printf("请输入要打印的行数：");
//         scanf("%d",&n);
//     }
//     printf("%d行杨辉三角如下：\n",n);
//     for(i=1;i<=n;i++)
//         a[i][1] = a[i][i] = 1;  /*两边的数令它为1，因为现在循环从1开始，就认为a[i][1]为第一个数*/
//     for(i=3;i<=n;i++)
//         for(j=2;j<=i-1;j++)
//             a[i][j]=a[i-1][j-1]+a[i-1][j];  /*除两边的数外都等于上两顶数之和*/ 
//     for(i=1;i<=n;i++){
//         for(k=1;k<=n-i;k++)
//             printf("   ");  /*这一行主要是在输出数之前打上空格占位，让输出的数更美观*/
//         for(j=1;j<=i;j++)  /*j<=i的原因是不输出其它的数，只输出我们想要的数*/
//             printf("%6d",a[i][j]);
        
//         printf("\n");  /*当一行输出完以后换行继续下一行的输出*/
//     }
//     printf("\n");
// }