from PIL import Image

width = 300
height = 300
im1 = Image.new("RGBA", (width,height), (139,0,0))
im2 = Image.new("RGBA", (width,height), (25,25,112))
im3 = Image.new("RGBA", (width,height), (245,245,245))
im4 = Image.new("RGBA", (width,height), (46,139,87))
im1.save("out.gif", save_all=True, append_images=[im2,im3,im4], duration = 100, loop = 0)