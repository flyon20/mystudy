#while使用
promit = "\nTell me something.and I will repeat it back to you:"
promit = "\nEbter 'quit' to end the progam"
message = ''
while message != 'quit':
    message = input(promit)
    print(message)
    if message != 'quit':
        print(message)
#使用标志
active = True
while active:
    message = input(promit)

    if message == 'quit':
        active = False
    else:
        print(message)
#类似其他语言 break continue 对循环的控制
