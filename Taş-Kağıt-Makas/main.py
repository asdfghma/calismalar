import random

options = ("taş", "kağıt", "makas")
playing = True

while playing:

    player = None
    computer = random.choice(options)

    while player not in options:
        player = input("Seçiminizi giriniz (taş, kağıt, makas): ")

    print(f"Player: {player}")
    print(f"Computer: {computer}")

    if player == computer:
        print("Berabere!")
    elif player == "taş" and computer == "makas":
        print("Kazandınız!")
    elif player == "kağıt" and computer == "taş":
        print("Kazandınız!")
    elif player == "makas" and computer == "kağıt":
        print("Kazandınız!")
    else:
        print("Kaybettiniz!")

    if not input("Yeniden oynamak ister misiniz? (e/h): ").lower() == "e":
        playing = False


print("Oynadığınız için teşekkürler.")