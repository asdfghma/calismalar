import random

def bogo_sort(a):
    for i in range(0, len(a) - 1):
        if a[i] > a[i + 1]:
            return False
    return True

liste = [5, 8, 7, 9, 6, 1, 2]

while not bogo_sort(liste):
    random.shuffle(liste)

print(liste)