#用户输入
name = input("Please enter your name:")
print(f"\nHello,{name}")
#输入长字符串的方法
prompt = "IF you tell us who you are , we can personalize the message you see"
prompt += "\nWhat is your first name?"
name = input(prompt)
print(f"\nHello,{name}")
#int()进行输入比较 类似强制转换为同一类型让字符串进行比较
height = input("How tall are you,in inches?")
height = int(height)
if height >=48:
    print("\nYou are tall enough to ride!")
else:
    print("\nYou well be able to ride when you are a little older.")