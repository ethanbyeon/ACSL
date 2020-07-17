
def check(n):

    while n >= 26:
        n -= 26

    return n


with open('c1intermediate.in') as fp:

    alpha = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    for i in range(3):

        line = fp.readline().split()[:-1]
        letters = []
        count = 1

        for c in line:
            x = ord(c.lower()) - 96

            # A - E
            if x in range(1, 6): 
                x = x * 2
                x = check(x)
                count = alpha.index(alpha[x]) + count

            # F - J
            if x in range(6, 11):
                x = (x % 3) * 5
                x = check(x)
                count = alpha.index(alpha[x]) + count
            
            # K - O
            if x in range(11, 16):
                x = (x // 4) * 8
                x = check(x)
                count = alpha.index(alpha[x]) + count
            
            # P - T
            if x in range(16, 21):
                sum = 0
                while(x > 0):
                    left = x % 10
                    sum += left
                    x //= 10

                x = sum * 10

                x = check(x)
                count = alpha.index(alpha[x]) + count
            
            # U - Z
            if x in range(21, 27):

                factor = []
                c = 0

                for i in range(1, x + 1):
                    if x % i == 0:
                        c += 1
                        factor.append(i)

                x = factor[-2] * 12

                x = check(x)
                count = alpha.index(alpha[x]) + count

            count = check(count)
        
            print(str(count) + " " + alpha[count])
        