import java.util.*;
import java.lang.Math;


public class Complex
{
  private double real   = 0;   //partie réelle
  private double imagin = 0;   //partie imaginaire


  public Complex()    //constructeur par défaut
  {}                  //avec les valeurs par défaut : 0 + i0


  public Complex(double real, double imagin)
  {
    this.real   = real;
    this.imagin = imagin;
  }


  public double getReal()
  {return real;}

  public double getImagin()
  {return imagin;}

  public void setReal(double real)
  {this.real = real;}

  public void setImagin(double imagin)
  {this.imagin = imagin;}


  public void getConjugate()   //conjugué du nombre complexe
  {imagin = -imagin;}


  public Complex sum(Complex c)
  {
    Complex result = new Complex();
    result.real    = real + c.real;
    result.imagin  = imagin + c.imagin;
    return result;
  }


  public Complex multiply(Complex c)
  {
    Complex result = new Complex();
    result.real    = (real * c.real)   - (imagin * c.imagin);
    result.imagin  = (real * c.imagin) + (imagin * c.imagin);
    return result;
  }


  public void printComplex()
  {
    if(imagin >= 0)
      System.out.println( real + "+i" + Math.abs(imagin) );
    else
      System.out.println( real + "-i" + Math.abs(imagin) );
  }
}
