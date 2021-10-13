#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <conio.h>

#define width 8
#define height 8

int map[hight][width]={
    {0,0,1,1,1,0,0,0},
    {0,0,1,4,1,0,0,0},
    {0,0,1,0,1,1,1,1},
    {1,1,1,3,0,3,4,1},
    {1,4,0,3,2,1,1,1},
    {1,1,1,1,3,1,0,0},
    {0,0,0,1,4,1,0,0},
    {0,0,0,1,1,1,0,0},
                        };

int x,y;

int boxs;

int main(int argc,char *argv[])
{
    char ch;
    initDate;
    while(1)
    {
        system("cls");
        drawMap();
        if(!boxs)
        {
          break;
        }
        ch=getch();
        switch(ch)
        {
            case'w':
                moveUp();
                break;
            case's':
                moveDrown();
                break;
            case'a':
                moveLeft();
                break;
            case'd':
                moveRight();
                break;
        }
    }
    printf("通关，还不错！");
    return 0;

}

initDate()
{
    int i,j;

    printf("加载中........");

    for(i=0;i<hight;i++)
    {
        for(j=0;j<width;j++)
        {
            if(map[i][j]==2)
            {
                x=i;
                y=j;
            }
            if(map[i][j]==3)
            {
                boxs++;
            }
        }
    }
}
drawMap()
{
    int i,j;

    for(i=0;i<width;i++)
    {
        for(j=0;j<height;j++)
        {
            switch(map[i][j])
            {
                case 0:
                    printf(" ");
                    break;
                case 1:
                    printf("#");
                     break;
                case 2:
                    printf("$");
                     break;
                case 3:
                    printf("◆");
                     break;
                case 4:
                    printf("●");
                     break;
                case 5:
                    printf("★");
                     break;
            }
        }
        printf("\n");
    }
}
moveUp()
{
    int ux,uy;
    if(y==0)
    {
        return;
    }
    ux=x;
    uy=y-1;
    if(map[uy][ux]==5)
    {
        return;
    }
    if(map[uy][ux]==1)
    {
        return;
    }
    if(map[uy][ux]==3)
    {
        if(map[uy-1][ux]==1)
        {
        return;
        }
    if(map[uy-1][ux]==4)
    {
       map[uy-1][ux]=5;
       map[uy][ux]=0;
       boxs--;
    }
    else
    {
        map[uy-1][ux]=3;
    }
    }
    map[y][x]=0;
    map[uy][ux]=2;
    y=uy;
}
moveDown()
{
    int dx,dy;

    if(y==0)
    {
        return;
    }
    dx=x;
    dy=y+1;
    if(map[dy][dx]==5)
    {
        return;
    }
    if(map[dy][dx]==1)
    {
        return;
    }
    if(map[dy][dx]==3)
    {
        if(map[dy+1][x]==1)
        {
        return;
        }
    if(map[dy+1][dx]==4)
    {
       map[dy+1][dx]=5;
       map[dy][dx]=0;
       boxs--;
    }
    else
    {
        map[dy+1][dx]=3;
    }
    }
    map[y][x]=0;
    map[dy][dx]=2;
    y=dy;
}
moveRight()
{
    int rx,ry;

    if(x==0)
    {
        return;
    }
    rx=x+1;
    ry=y;
    if(map[ry][rx]==5)
    {
        return;
    }
    if(map[ry][rx]==1)
    {
        return;
    }
    if(map[ry][rx]==3)
    {
        if(map[ry][rx+1]==1)
        {
        return;
        }
    if(map[ry][rx+1]==4)
    {
       map[ry][rx+1]=5;
       map[ry][rx]=0;
       boxs--;
    }
    else
    {
        map[ry][rx+1]=3;
    }
    }
    map[y][x]=0;
    map[ry][rx]=2;
    x=rx
}
moveLeft()
{
    int lx,ly;

    if(x==0)
    {
        return;
    }
    lx=x-1;
    ly=y;
    if(map[ly][lx]==5)
    {
        return;
    }
    if(map[ly][lx]==1)
    {
        return;
    }
    if(map[ly][lx]==3)
    {
        if(map[ly][lx-1]==1)
        {
        return;
        }
    if(map[ly][lx-1]==4)
    {
       map[ly][lx-1]=5;
       map[ly][lx]=0;
       boxs--;
    }
    else
    {
        map[ly][lx-1]=3;
    }
    }
    map[y][x]=0;
    map[ly][lx]=2;
    x=lx
}

