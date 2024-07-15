import base64
from tkinter import *
import tkinter.messagebox
from PIL import ImageTk, Image
import base64

def encode(key,clear):
    enc = []
    for i in range(len(clear)):
        key_c = key[i % len(key)]
        enc_c = (ord(clear[i]) + ord(key_c)) % 256
        enc.append(enc_c)
    encoded_bytes = bytes(enc)
    encoded_string = base64.urlsafe_b64encode(encoded_bytes).decode()
    return encoded_string

def decode(key,enc):
    dec = []
    enc = base64.urlsafe_b64decode(enc)
    for i in range(len(enc)):
        key_c = key[i % len(key)]
        dec_c = chr((256 + enc[i] - ord(key_c)) % 256)
        dec.append(dec_c)
    return "".join(dec)

def save_title():
    title = title_entry.get()
    secret = text_entry.get("1.0","end")
    key = key_entry.get()

    if len(title) == 0 or len(secret) == 0 or len(key) == 0:
        tkinter.messagebox.showwarning(title="Error", message="Please enter all informations")

    else:
        secret_encode = encode(key,secret)
        try:
            with open("secret.txt", "a") as data_file:
                data_file.write(f"\n{title}\n{secret_encode}")
        except FileNotFoundError:
            with open("secret.txt", "w") as data_file:
                data_file.write(f"\n{title}\n{secret_encode}")

        finally:
            title_entry.delete(0,END)
            text_entry.delete("1.0", "end")
            key_entry.delete(0, END)

def decode_secret():
    secret = text_entry.get("1.0","end")
    key = key_entry.get()

    if len(secret) == 0 or len(key) == 0:
        tkinter.messagebox.showwarning(title="Error", message="Please enter all informations")
    else:
        try:
            dec_secret = decode(key,secret)
            text_entry.delete("1.0","end")
            text_entry.insert("1.0", dec_secret)
        except:
            tkinter.messagebox.showwarning(title="Error", message="Please enter all informations")


window = Tk()
window.title = ("Note Encoder")
window.config(padx=20,pady=20)
window.geometry("400x600")
window.configure(bg='light gray')

image = Image.open("top_secret.png")
resized_image = image.resize((180, 90))
photo = ImageTk.PhotoImage(resized_image)

image_label = Label(window, image=photo, bg="light gray")
image_label.pack()

title_label = Label(text="Enter your title",bg="light gray", font=("Blood", 14))
title_label.pack(pady=5)

title_entry = Entry(width=40)
title_entry.pack()

text_label = Label(text="Enter your secret", bg="light gray" , font=("Blood",14))
text_label.pack(pady=5)

text_entry = Text(window, height=15)
text_entry.pack(pady=5)

key_label = Label(text="Enter master key", bg="light gray", font=("Blood",14))
key_label.pack()

key_entry = Entry(width=40)
key_entry.pack(pady=5)

save_button = Button(text="Save & Encrypt", command=save_title)
save_button.pack(pady=5)

dec_button = Button(text="Decrypt", command=decode_secret)
dec_button.pack(pady=4)

result_label = Label(text="", bg="gray10", fg="white")
result_label.pack(pady=3)

window.mainloop()
