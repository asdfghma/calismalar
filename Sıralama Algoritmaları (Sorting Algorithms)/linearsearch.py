def linear_search(dizi, sayi):
    for i in range(0, len(dizi)):
        if dizi[i] == sayi:
            return i
    return "Aranan sayi dizide bulunamadı."

dizi = [9,5,6,7,8,1,4,2]
aranan_sayi = 2
print(linear_search(dizi, aranan_sayi))