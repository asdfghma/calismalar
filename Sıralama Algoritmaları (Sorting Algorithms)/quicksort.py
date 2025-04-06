def quick_sort(liste):
    if len(liste) <= 1:
        return liste

    pivot = liste.pop()
    listeKucuk = []
    listeBuyuk = []

    for i in liste:
        if i < pivot:
            listeKucuk.append(i)
        else:
            listeBuyuk.append(i)
    return quick_sort(listeKucuk) + [pivot] + quick_sort(listeBuyuk)

print(quick_sort([5, 6, 8, 1, 4, 2]))