from tkinter import *
from tkinter import messagebox

window = Tk()
window.title("BMI Calculator")

# BMI Calculator başlığı
my_label = Label(window, text="BMI Calculator", bg="black", fg="white")
my_label.pack()

# BMI hesaplama fonksiyonu
def calculate_bmi():
    try:
        weight = float(my_entry.get())
        height = float(my_entry2.get())
        bmi = weight / (height ** 2)
        print(f"BMI: {bmi:.2f}")

        if bmi < 18.5:
            result_label.config(text=f"BMI: {bmi:.2f} - Underweight")
        elif 18.5 <= bmi < 25:
            result_label.config(text=f"BMI: {bmi:.2f} - Normal")
        elif 25 <= bmi < 30:
            result_label.config(text=f"BMI: {bmi:.2f} - Pre-obesity")
        elif 30 <= bmi < 35:
            result_label.config(text=f"BMI: {bmi:.2f} - Obesity Class 1")
        elif 35 <= bmi < 40:
            result_label.config(text=f"BMI: {bmi:.2f} - Obesity Class 2")
        else:
            result_label.config(text=f"BMI: {bmi:.2f} - Obese")

    except ValueError:
        messagebox.showwarning("Hata", "Lütfen sayı giriniz.")

# Hesapla butonu
my_button = Button(window, text="Calculate", command=calculate_bmi)
my_button.pack()

# Kilo etiketi ve giriş alanı
my_label2 = Label(window, text="Weight (kg):")
my_label2.pack()
my_entry = Entry(window)
my_entry.pack()

# Boy etiketi ve giriş alanı
my_label3 = Label(window, text="Height (m):")
my_label3.pack()
my_entry2 = Entry(window)
my_entry2.pack()

# Sonuç etiketi

result_label = Label(window, text="", fg="blue")
result_label.pack()

window.mainloop()
