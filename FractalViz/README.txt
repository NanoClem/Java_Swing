# Authors : DECOOPMAN Clement, DAMIENS Lucas


# CONTEXT :

- The application calculates a Mandelbrot fractal and allows to view it in a graphic interface which is able to make a zoom.
- The user can choose the number of iterations, zoom in or zoom out, browse the fractal by dragging the mouse and save the result as a picture file.


# PROJECT STRUCTURE :

FractalViz
|
|__class                             : files produced by compilation of the src files (.class files), can be used to make a .jar without src
|
|__libs 	                     : extern librairies used for the project (out of the jdk librairies)
|
|__src 	                             : source code (.java files)
|    |__packages                     : personalized classes used in the project
|        |__component                : classes defined as component in the project, according to the Awt and Swing's heritage hierarchy
|            |__containers           : classes defined as container in the project (like Frames, Panel...), according to the Awt and Swing's heritage hierarchy
|
|__README.txt
