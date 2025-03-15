def rvrs(lst):
    result = []
    for item in lst[::-1]:
        if isinstance(item, list):
            result.append(item[::-1])
        else:
            result.append(item)
    return result

print(rvrs([[1, 2], [3, 4], [5, 6, 7]]))