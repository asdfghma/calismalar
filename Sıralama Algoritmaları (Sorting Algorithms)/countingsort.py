def counting_sort(arr):
    max_element = max(arr)

    count = [0] * (max_element + 1)

    for num in arr:
        count[num] += 1

    for i in range(1, len(count)):
        count[i] += count[i - 1]

    output = [0] * len(arr)

    for num in arr[::-1]:
        count[num] -= 1
        output[count[num]] = num

    return output

arr = [4, 2, 2, 8, 3, 3, 1]
sorted_arr = counting_sort(arr)
print("Sıralanmamış dizi:", arr)
print("Sıralanmış dizi:", sorted_arr)
