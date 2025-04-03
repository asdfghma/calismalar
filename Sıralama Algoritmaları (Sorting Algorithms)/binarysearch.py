def binarysearch(liste, sayi):
    liste.sort()

    baslangic_indexi = 0
    bitis_indexi = len(liste) - 1

    while bitis_indexi >= baslangic_indexi:
        orta_index = baslangic_indexi + ((bitis_indexi - baslangic_indexi) // 2)
        ortanca_eleman = liste[orta_index]

        if sayi == ortanca_eleman:
            return orta_index
        elif sayi < ortanca_eleman:
            bitis_indexi = orta_index - 1
        else:
            baslangic_indexi = orta_index + 1
    return None

liste = [1, 2, 3, 4, 5, 6, 7]
sayi = 4
sonuc = binarysearch(liste, sayi)

if sonuc != None:
    print(f"Sayının dizideki indexi = {sonuc}")
else:
    print("Aranan sayı dizide mevcut değil.")