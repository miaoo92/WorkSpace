sum = 0
x=1
while x<100:
    sum = sum + x
    x = x+1
print(sum)

sum = 0
x = 1
n = 1
while True:
    sum = sum + x
    x = 2*x
    n = n+1
    if n>20:
        break
print(sum)

L = [75,98,59,81,66,43,69,85]
sum = 0.0
n=0
y = 0
for x in L:
    if x<60:
        y+=1
        continue
    sum = sum + x
    n+=1
print (sum/n,'\n',y)
for x in [1,2,3,4,5,6,7,8,9]:
    for y in [0,1,2,3,4,5,6,7,8,9]:
        if x < y:
            print(x*10+y)