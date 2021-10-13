#字典及应用
alien_0={'color':'green','points':5}
print(alien_0['color'])
alien_0['x_position']=0
alien_0['y_position']=25
print(alien_0)
#正经的开始 创建列表及增删操作
print("分割线")
alien_0={}
alien_0['color']='gree'
alien_0['points']=5
print(alien_0)
alien_0['color']='yellow'
#删除键值对
#del alien_0['color']
#类似对象 字典
print("又是分割线")
favor_languages = {
    'jen':'python',
    'sarah':'c',
    'edward':'rudy',
    'phil':'python',
    }
languages=favor_languages['sarah'].title()
print(f"languages {languages}")
#当字典没有相应数据应该用get（）表示
value=alien_0.get('point','not find')
print(value)
#遍历字典
for key,value in alien_0.items():
    print(f"\nKEY:{key}")
    print(f"VALUE:{value}")
#遍历键
for name in favor_languages.keys():
    print(name.title())
friends = ['phil','sarah']
#key()使用
for name in favor_languages.keys():
    print(f"Hi {name.title()}")
    if name in friends:
        languages = favor_languages[name].title()
        print(f"\t{name.title()},I see you love {languages}")
#对键排序输出
for name in sorted(favor_languages.keys()):
    print(name.title())
#遍历值
print("没错又是分割线")
for language in favor_languages.values():
    print(language.title())
#检索重复元素
print("\n")
for language in set(favor_languages.values()):
    print(language.title())