#列表切片
players = ['charles','martina','michael','florence','eli']
print(players[0:3])
print(players[:4])
print(players[0:])
#遍历切片
print("遍历")
for player in players[:3]:
    print(player.title())
print("复制")
T_players = players[:]
print(T_players)
print(players)
#元组(确定元组的是括号内的‘，’)元组内的值不可修改
print("\n元组")
dimensions = (200,50)
print(dimensions[0])
print(dimensions[1])

