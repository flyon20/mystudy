﻿#include <iostream>
#include "Sales_item.h"
int main()
{
    Sales_item total;
    if (std::cin >> total)
    {
        Sales_item trans;
        while (std::cin >> trans)
        {
            if (total.isbn() == trans.isbn())
                total += trans;
            else
            {
                std::cout << total << std::endl;
                total = trsans;
            }
        }
        std::cout << total << std::endl;
    }
    else {
        std::cerr << "ÊäÈë´íÎó" << std::endl;
        return -1;
    }
    return 0;
}
