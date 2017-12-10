# FRACTALVIZ : ensemble de Mandelbrot



from tkinter import *



#VARIABLES

n = 50
zoom = 100	# pour une distance de 1 sur le plan, on a 100 pixels sur l'image

xmin = -2.1	# intervalle de l'ensemble de Mandelbrot
xmax = 0.6	# -2.1 < x < 0.6   pour les abscisses
ymin = -1.2	# -1.2 < y < 1.2   pour les ordonnées (ou les complexes)
ymax = 1.2

# Calcul de la taille de l'imgage de la fractale
taille_x = int((xmax - xmin)*zoom)	# dimension en x
taille_y = int((ymax - ymin)*zoom)	# dimension en y

dx = float((xmax - xmin)/taille_x)
dy = float((ymax - ymin)/taille_y)



#FENETRE ET ZONE DE DESSIN

w = Tk()
cv = Canvas(w, width = taille_x, height = taille_y)
cv.pack()



#PROGRAMME

y = ymax
    
for j in range(0, taille_y):
    x = xmin
    
    for i in range(0, taille_x + 1):
        c = complex(x,y)
        c0 = c
            
        for k in range(0,n):
            c = c**2 + c0

            if abs(c) > 2:
                break
                
            if k == (n-1):
                cv.create_line(i, j, i, j+1)
                    
        x = x+dx
    y = y-dy
    cv.update()


w.mainloop()

    
