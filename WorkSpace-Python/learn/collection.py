d = {'Adam':95,'Lisa':85,'Bart':59}
print('Adam:',d['Adam'])
print('Lisa:',d['Lisa'])
print('Bart:',d['Bart'])
print(d)
for key in d:
    print(key,':',d[key])

s = set(['Adam','Lisa','Bart','Paul'])
print(s)
months = set(['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'])
x1 = 'Feb'
x2 = 'Dec'

if x1 in months:
    print ('x1: ok')
else:
    print ('x1: error')

if x2 in months:
    print ('x2: ok')
else:
    print ('x2: error')