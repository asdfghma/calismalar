def interpolation_search(liste, aranan):

    low = 0
    high = len(liste) - 1

    while low <= high and liste[low] <= aranan <= liste[high]:

        position = low + ((aranan - liste[low]) * (high - low)) // (liste[high] - liste[low])

        if liste[position] == aranan:
            return position
        elif liste[position] < aranan:
            low = position + 1
        else:
            high = position + 1

    return -1

liste = [1,2,3,4,5]
aranan_sayi = 4

print(f"Aranan sayının indeksi: {interpolation_search(liste, aranan_sayi)}")