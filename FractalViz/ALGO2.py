#Implantation test Algo 1

from tkinter import *



#VARIABLES

xmin          = -2.1
xmax          = 0.6
ymin          = -1.2
ymax          = 1.2

img_x         = 270
img_y         = 240
iteration_max = 50

zoom_x          = img_x / (xmax-xmin)
zoom_y          = img_y / (ymax-ymin)



#FENETRE GRAPHIQUE

w = Tk()
cv = Canvas(w, width = img_x, height = img_y)
cv.pack()




#PROGRAMME

for x in range(0,img_x) :
    for y in range(0,img_y) :
        c_r = x / zoom_x + xmin
        c_i = y / zoom_y + ymin
        z_r = 0
        z_i = 0
        i   = 0

        while z_r**2 + z_i**2 < 4 and i < iteration_max :
          tmp = z_r
          z_r = z_r**2 - z_i**2 + c_r
          z_i = 2*z_i *tmp +c_i
          i   = i+1

        if i == iteration_max :
            cv.create_line(x, y, x, y+1)
      
    cv.update()


w.mainloop()

    

        
        
