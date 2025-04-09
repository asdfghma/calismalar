def radix_sort(b):
    max_num = max(b)
    basamak_sayisi = len(str(max_num))

    for i in range(basamak_sayisi):
        c = [[] for m in range(10)]

        for num in b:
            digit = (num // 10**i) % 10
            c[digit].append(num)

            b = []
            for group in c:
                b.extend(group)
    return b

b = [123, 444, 111, 687]
print(radix_sort(b))