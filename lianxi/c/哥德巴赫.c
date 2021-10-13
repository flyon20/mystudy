/*¾¡Á¦¶øÎª*/
#include <stdio.h>
#include <stdlib.h>
int main()
{
    int a,k,i,b,countre1,countre2; 
    for (k=4;k<=100;k=k+2)
    {
        for(a=2;a<=k/2;a++)
        {
        countre1=0;
         for (i=2;i<=a-1;i++)
         {
             if(a%i==0)
             {
             countre1++;
             break;
             }
         }
         if (countre1==0)
         {
             b=k-a;
             countre2=0;
             for (i=2;i<=b-1;i++)
             {
                 if (b%i==0)
                 {
                 countre2++;
                 break;
                 }
             }
         }
         if (countre2==0)
         {
             printf("%-2d=%d+%d",k,a,b);
             printf("\n");
             break;
         }
        }
    }
    system ("pause");
    return 0;
}

