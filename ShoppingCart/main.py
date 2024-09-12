

foods = []
prices = []
total = 0

while True:
    food = input("Almak istediğiniz yiyeceği girin (çıkmak için q): ")
    if food.lower() == "q":
        break
    else:
        price = float(input(f"Yiyeceğin fiyatını giriniz {food}: $"))
        foods.append(food)
        prices.append(price)

print("----- SEPETİNİZ -----")
for food in foods:
    print(food, end=" ")

for price in prices:
    total += price

print()
print(f"Toplam Ücret: ${total}")
