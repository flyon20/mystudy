#if(用and和or可检测多个条件)
age=19
if age >=18:
    print("You are old")
age=12
if age<4:
    pice=0
elif age <18:
    pice=25
else:
    pice=40
print(f"Your admission coat is ${pice}")
#用于检查特殊元素 检查列表是否空