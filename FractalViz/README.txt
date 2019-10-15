## Authors : 
DECOOPMAN Clement, DAMIENS Lucas


## CONTEXT :

- The application display a Mandelbrot fractal and allows to view it in a graphic interface.
- The user is able to :
	- draw a fractal in white and black or in color
	- choose the number of iterations for each fractal,
	- choose the color for the colored fractal, 
	- zoom in or zoom out,
	- save the result as a png and load a picture in the area


## PROJECT STRUCTURE :

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
|	     |__calculation	     : classes which are related to all the mathematic calculation in the project (like Mandelbrot.java) 
|
|__README.txt
