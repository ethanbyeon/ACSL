
def check(n):
    
    if n != 26:
        while n > 26:
            n -= 26

    return n


with open('test/c1intermediate.in') as fp:

    alpha = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    letters = []
    for i in range(8):

        line = fp.readline().split()[:-1]
        letters = []
        count = 1

        for c in line:
            x = ord(c.lower()) - 96

            if x in range(1, 6): # A - E
                x = x * 2

            elif x in range(6, 11): # F - J
                x = (x % 3) * 5
            
            elif x in range(11, 16): # K - O
                x = (x // 4) * 8
            
            elif x in range(16, 21): # P - T
                sum = 0
                while(x > 0):
                    left = x % 10
                    sum += left
                    x //= 10

                x = sum * 10
            
            elif x in range(21, 27): # U - Z

                factor = []
                c = 0

                for i in range(1, x + 1):
                    if x % i == 0:
                        c += 1
                        factor.append(i)

                x = factor[-2] * 12

            x = check(x + count)
            count = alpha.index(alpha[x])
            letters.append(alpha[count])

        print(*letters, sep=' ')
        