def insertion_sort(liste):
    for i in range(1, len(liste)):
        siralanacak_deger = liste[i]

        while liste[i - 1] > siralanacak_deger and i > 0:
            liste[i], liste[i-1] = liste[i-1], liste[i]
            i -= 1
    return liste

print(insertion_sort([8, 1, 9, 4, 7, 8, 3, 2]))
