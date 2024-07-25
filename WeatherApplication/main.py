import requests
import tkinter as tk
from tkinter import messagebox
#from PIL import  Image, ImageTK


root = tk.Tk()
root.title("Weather App")
root.geometry("400x300")
root.config( bg="lightblue")
try:
    img = Image.open("Indigo blue weather.jpg")
    logo = ImageTK.PhotoImage(img)
    logo_label = tk.Label(root, image=logo)
    logo_label.pack(pady=10)
except Exception as e:
    print(f"Fotoğraf yükelenirken bir hata oluştu: {e}")

city_label = tk.Label(root, text="City: ", font=("Helvetica", 12, "bold"), bg="lightblue")
city_label.pack()

city_entry = tk.Entry(root, font=("Helvetica", 12))
city_entry.pack(pady=5)

fetch_button = tk.Button(root, text="Fetch Weather", font=("Helvetica", 12, "bold"))
fetch_button.pack()

weather_label = tk.Label(root, text="", bg="lightblue", fg="white")
weather_label.pack()

def fetch_weather():
    city = city_entry.get()
    api_key = "YOUR_API_KEY"
    url = f"https://api.openweathermap.org/data/2.5/weather?q={city}&appid={api_key}"

    try:
        response = requests.get(url)
        data = response.json()
        temperature = data["main"]["temp"]
        weather = data["weather"][0]["description"]
        weather_label.config(text=f"Temperature: {temperature}°C\nWeather: {weather}")
    except Exception as e:
        messagebox.showerror("Error", "Unable to fetch weather data")

fetch_button.config(command=fetch_weather)

root.mainloop()