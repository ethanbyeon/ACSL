
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
                count = (x * 2) + count
                letters.append(alpha[count])

            # F - J
            if x in range(6, 11):
                count = (x % 3) * 5
                count = alpha.index(alpha[count]) + count
            
            # K - O
            if x in range(11, 16):
                x = (x // 4) * 8
                count = alpha.index(alpha[x]) + count
            
            # P - T
            if x in range(16, 21):
                sum = 0
                while(x > 0):
                    left = x % 10
                    sum += left
                    x //= 10

                count = (sum * 10) + count
            
            # U - Z
            if x in range(21, 27):

                factor = []
                count = 0

                for i in range(1, x + 1):
                    if x % i == 0:
                        count += 1
                        factor.append(i)

                x = factor[-2] * 12

                while x >= 26:
                    x -= 26
                print(x)
                print(count)
                count = alpha.index(alpha[x]) + count

            while count >= 26:
                count -= 26
        
            print(str(count) + " " + alpha[count])
        