
def check(n):

    if n != 26:
        while n > 26:
            n -= 26
    
    return n

def main():
    with open('wraparound.in') as f:

        alpha = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        out = open('wraparound.out', 'w')

        for i in range(5):

            letter = f.readline().strip()
            num = alpha.index(letter)

            if 'A' <= letter <= 'E':
                num *= 2
            elif 'F' <= letter <= 'J':
                num = (num % 3) * 5
            elif 'K' <= letter <= 'O':
                num = (num // 4) * 8
            elif 'P' <= letter <= 'T':
                sum = 0
                while(num > 0):
                    left = num % 10
                    sum += left
                    num //= 10
                
                num = sum * 10

            elif 'U' <= letter <= 'Z':
                factor = []
                c = 0

                for i in range(1, num + 1):
                    if num % i == 0:
                        c += 1
                        factor.append(i)
                
                num = factor[-2] * 12

            num = check(num)
            num = alpha.index(alpha[num])
            letter = alpha[num]
            if i != 4:
                out.write(letter + '\n')
            else:
                out.write(letter)
            out.write('K')
            
if __name__ == "__main__":
    main()