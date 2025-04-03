def selection_sort(liste):
    for i in range(len(liste)):
        min_index = i
        for j in range(i + 1, len(liste)):
            if liste[j] < liste[min_index]:
                min_index = j
        liste[i], liste[min_index] = liste[min_index], liste[i]

    return liste

print(selection_sort([8, 9, 1, 3, 5, 4]))