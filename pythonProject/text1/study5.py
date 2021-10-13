#列表
#注意缩进，语法
magicians=['alice','david','carolina']
for magician in magicians:
    print(magician)
    print(f"{magician.title()},that was a great trick!\n")

for value in range(1,5):
    print(value)

squares = []
for value in range(1,11):
    squares.append(value**2)
print(squares)
#简化写法
# squares = [value**2 for value in range(1,11)]
# print(squares)


