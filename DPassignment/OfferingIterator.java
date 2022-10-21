import java.util.Iterator;


public class OfferingIterator implements Iterator
{
  private int CurrentOfferingNumber=-1;  //  CurrentOfferingNumber: point to the location before the first element
  private OfferingList offeringlist;

  OfferingIterator(OfferingList theofferinglist)
  {
    offeringlist=theofferinglist;
    MoveToHead();
  }

  private void MoveToHead()
  {
    CurrentOfferingNumber=-1;
  }

  public boolean hasNext()
  {
    return CurrentOfferingNumber < offeringlist.size() - 1;

  }
  public Object next()
  {
    if (hasNext())
    {
      CurrentOfferingNumber ++;
      return offeringlist.get(CurrentOfferingNumber);
    }
    else
    {
      return null;
    }

  }

  Object next(String UserName)
  {
    Offering theOffering;
    theOffering=(Offering)next();
    while(theOffering!=null)
    {
      if(UserName.compareTo(theOffering.theAuthor)==0)
      {
        return theOffering;
      }
      theOffering=(Offering)next();
    }
    return null;
  }

  public void remove()
  {
    offeringlist.remove(CurrentOfferingNumber);

  }

}