def merge_sort(liste):
    if len(liste) <= 1:
        return liste

    mid = len(liste) // 2
    right_half = liste[mid:]
    left_half = liste[:mid]

    right = merge_sort(right_half)
    left = merge_sort(left_half)

    result = []
    i = 0
    j = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])

    return result

print(merge_sort([2, 5, 8, 6, 7, 1, 3, 4]))
