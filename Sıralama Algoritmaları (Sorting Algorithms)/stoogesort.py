def stooge_sort(arr, l, h):
    if l >= h:
        return h

    if arr[l] > arr[h]:
        arr[h], arr[l] = arr[l], arr[h]

    if h - l + 1 > 2:
        t = (h - l + 1) // 3

        stooge_sort(arr, l, (h - t))
        stooge_sort(arr, l + t, h)
        stooge_sort(arr, l, (h - t))

dizi = [6, 3, 5, 8, 2, 7, 4, 1]

stooge_sort(dizi, 0, len(dizi) - 1)

print(dizi)