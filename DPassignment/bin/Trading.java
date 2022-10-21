import java.util.*;
import java.text.DateFormat;

public class Trading {

  String TraName;
  Date DueDate=new Date();
  Offering SuggestOffering=new Offering();
  OfferingList theOfferingList=new OfferingList();


  public Trading() {
  }

  void AddOffering(Offering theOffering)
  {
    theOfferingList.add(theOffering);
  }

  OfferingIterator GetOfferingIterator()
  {
    return new OfferingIterator(theOfferingList);
  }

  public String toString()
  {
    return TraName;
  }

  String getDueDateString()
  {
    DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
    return  dateFormat.format(DueDate);
  }
  void accept(NodeVisitor visitor)
  {
    visitor.visitTrading(this);
  }
}