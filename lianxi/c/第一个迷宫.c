#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main()
{
    char a[40][40]={"############",
                    "#o #    #   ",
                    "# ## # ## ##",
                    "#   #  ##  #",
                    "#  # # ## ##",
                    "##   #  # ##",
                    "## #      ##",
                    "############"};
    int i,x,y,p,q;
    char ch;
    x=1; y=1; p=1; q=11;
    for (i=0;i<=7;i++)
        puts (a[i]);
    while (x!=p || y!=q)
    {
        ch=getch();
        if(ch=='s')
        {
           if (a[x+1][y]!='#')
           {
               a[x][y]=' ';
               x++;
               a[x][y]='o';
           }
        }

        if(ch=='w')
        {
            if (a[x-1][y]!='#')
           {
               a[x][y]=' ';
               x--;
               a[x][y]='o';
           }
        }

        if(ch=='a')
        {
            if (a[x][y-1]!='#')
           {
               a[x][y]=' ';
               y--;
               a[x][y]='o';
           }
        }

        if(ch=='d')
        {
            if (a[x][y+1]!='#')
           {
               a[x][y]=' ';
               y++;
               a[x][y]='o';
           }
        }
        system("cls");
        for (i=0;i<=7;i++)
            puts (a[i]);
    }
    system("cls");
    printf("Å£±Æ£¬ÄãÓ®ÁË£¡£¡£¡\n");
    Sleep(5);
    return 0;
}








