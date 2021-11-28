#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){
    float x,y,z,f;
    for(y = 1.5f; y > -1.5f; y-=0.1f)
    {
        for(x = -1.5f; x < 1.5f; x += 0.05f)
        {
            // if(x*x+(y-powf(x*x,1.0/3))*(y-powf(x*x,1.0/3))-1<0)
            //     putchar('*');
            // else
            //     putchar(' ');
            // putchar('\n');
        }
    }
    getchar();
    return 0;
}