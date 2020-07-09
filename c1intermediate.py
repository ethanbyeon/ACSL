
with open('c1intermediate.in') as fp:

    for i in range(3):
        letters = []
        line = fp.readline().split()[:-1]

        for c in line:
            if ord(c) in range(0, 5): letters.append(chr(ord(c) * 2))
            
            if ord(c) in range(5, 10): letters.append(chr((ord(c) % 3) * 5))
            
            if ord(c) in range(10, 15): letters.append(chr((ord(c) / 4) * 8))
            
            # if ord(c) in range(15, 20): list.append(chr((ord(len(c) * 10)))
            
            if ord(c) in range(20, 26): break
        