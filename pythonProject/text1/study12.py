#while对字典列表的使用
#在列表间移动元素
unconfirmed_user =  ['alice','brian','candace']
confirmed_users = []
while unconfirmed_user:
    current_user = unconfirmed_user.pop()

    print(f"Verifying user:{current_user.title()}")
    confirmed_users.append(current_user)

print("\nThe following users have been confirmed:")
for confirmed_user in confirmed_users:
    print(confirmed_user.title())
#remove()为删除列表内的特定值
#用户输入来填充字典
responses = {}
polling_active = True
while polling_active:
    name = input("\nWhat is your name?")
    response = input("Which mountain would you like to climb someday?")
    responses[name] = response

    repeat = input("Would you like to let another person respond?(yes/no)")
    if repeat=='no':
        polling_active =False

print("\n——————Poll Results ——————")
for name,response in responses.items():
    print(f"{name}would like to climb {response}")
