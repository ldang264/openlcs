# -*- coding: UTF-8 -*-
 
# Filename : test.py
# author by : www.runoob.com
 
# 获取用户输入十进制数
dec = int(input("输入数字："))
 
print("十进制数为：", dec)
print("转换为二进制为：", bin(dec))
print("转换为八进制为：", oct(dec))
print("转换为十六进制为：", hex(dec))

test_dict = {"Runoob" : 1, "Google" : 2, "Taobao" : 3, "Zhihu" : 4} 
  
# 输出原始的字典
print ("字典移除前 : " + str(test_dict)) 
  
# 使用 del 移除 Zhihu
del test_dict['Zhihu'] 
  
# 输出移除后的字典
print ("字典移除后 : " + str(test_dict)) 
  
# 移除没有的 key 会报错
#del test_dict['Baidu']

test_dict = {"Runoob" : 1, "Google" : 2, "Taobao" : 3, "Zhihu" : 4} 
  
# 输出原始的字典
print ("字典移除前 : " + str(test_dict)) 
  
# 使用 pop 移除 Zhihu
removed_value = test_dict.pop('Zhihu') 
  
# 输出移除后的字典
print ("字典移除后 : " + str(test_dict)) 
  
print ("移除的 key 对应的 value 为 : " + str(removed_value)) 
  
print ('\r') 
  
# 使用 pop() 移除没有的 key 不会发生异常，我们可以自定义提示信息
removed_value = test_dict.pop('Baidu', '没有该键(key)') 
  
# 输出移除后的字典
print ("字典移除后 : " + str(test_dict)) 
print ("移除的值为 : " + str(removed_value))
