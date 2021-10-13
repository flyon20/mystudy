#列表
bicycles = ['trek','cannondale','resline','specialized']
print(bicycles[0])
print(bicycles[0].title())
message=f"My first bicycle was a {bicycles[0].title()}"
print(message)
#增删改
print('\n',bicycles)
bicycles[0]='ducati'
print(bicycles)

bicycles.append('diucati')
print('\n',bicycles)
bicycles.insert(0,'test')
print(bicycles)

del bicycles[0]
print(bicycles)

print('\n',bicycles)
p_bicycles=bicycles.pop()
print(bicycles)
print(p_bicycles)
p_bicycles1=bicycles.pop(2)
print(p_bicycles1)

bicycles.remove('cannondale')
print('\n',bicycles)
