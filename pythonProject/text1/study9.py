#嵌套字典
aliens=[]

for alien_number in range(30):
    new_alien = {'color':'green','points':5,'speed':'slow'}
    aliens.append(new_alien)
#修改其中数据可以用if elif实现
for alien in aliens[:3]:
    if alien['color']=='green':
        alien['color']='yellow'
        alien['speed']='medium'
        alien['points']=10

for alien in aliens[:5]:
    print(alien)
print("...")
print(f"Total number for aliens :{len(aliens)}")
#字典中储存列表
pizza = {
    'crust' : 'thick',
    'toppings':['mushrooms','extra cheese'],
}
print(f"You orderd a {pizza['crust']} crust pizza")
for topping in pizza['toppings']:
    print("\t"+topping)
#字典中储存字典 同上操作
