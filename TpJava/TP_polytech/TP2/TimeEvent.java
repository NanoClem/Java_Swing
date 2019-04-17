import java.util.EventObject;
import java.lang.System;


public class TimeEvent extends EventObject {
  //ATTRIBUTS
  private Object source;        //objet source
  private long creationTime;    //date de creation

  //CONSTRUCTEUR
  public TimeEvent(Object _source) {
    super();
    this.creationTime = currentTimeMillis();
  }


  //GETTER
  public Object getSource() {
    return this.source;
  }

  //GETTER
  public long getCreationTime() {
    return this.creationTime;
  }
}
