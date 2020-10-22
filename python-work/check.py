import os

filename = input('Python File Name: ')
if os.path.isfile(filename + '.py'):
    os.system(filename + '.py')
else:
    print(filename + " does not exist.")

file1 = filename + '.out'

with open(file1, 'r') as f1:
    with open('answer.out', 'r') as ans:
        diff = set(f1).difference(ans)

lineno = 0
results = []
with open(file1, 'r') as f:
    for line in f:
        lineno += 1
        if line in diff:
            results.append((lineno, line.rstrip()))
    
    if len(results) == 0:
        print('Success!')
    else:
        print(results)