#Implantation test Algo 1

from tkinter import *
from ColorConvert import *
import time


#VARIABLES

xmin          = -2.1
xmax          = 0.6
ymin          = -1.2
ymax          = 1.2

zoom          = 100   #eval(input())
iteration_max = 20

img_x         = int( (xmax - xmin) * zoom )
img_y         = int( (ymax - ymin) * zoom )
dx            = float((xmax - xmin)/img_x)
dy            = float((ymax - ymin)/img_y)


#FENETRE GRAPHIQUE

w = Tk()
cv = Canvas(w, width = img_x, height = img_y)
cv.pack()


#PROGRAMME

begin = time.time()

for x in range(0,img_x) :
    for y in range(0,img_y) :
        c_r = x / zoom + xmin
        c_i = y / zoom + ymin
        z_r = 0
        z_i = 0
        i   = 0

        while z_r**2 + z_i**2 < 4 and i < iteration_max :
          tmp = z_r
          z_r = z_r**2 - z_i**2 + c_r
          z_i = 2*z_i *tmp +c_i
          i   = i+1

        if i == iteration_max :
            cv.create_line(x, y, x, y+1, fill="black")
        else :
            color = (0, i*150/iteration_max, i*255/iteration_max)
            converted_color = ColorRVBHex(color)
            cv.create_line(x, y, x, y+1, fill=converted_color)

    cv.update()

end = time.time()
print("temps d'exécution : ", end-begin, "s")

w.mainloop()
