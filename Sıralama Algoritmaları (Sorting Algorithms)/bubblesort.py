def bubble_sort(liste):
    index = len(liste) - 1
    siralama = False

    while not siralama:
        siralama = True
        for i in range(0, index):
            if liste[i] > liste[i + 1]:
                siralama = False
                liste[i], liste[i + 1] = liste[i + 1], liste[i]
        index -= 1

    return liste

print(bubble_sort([4,7,8,9,5,1]))