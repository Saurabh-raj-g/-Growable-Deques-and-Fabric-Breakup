//package part_A;  
public class ArrayDeque implements DequeInterface {
    int capacity = 1;
    Object[] array = new Object[capacity];
    int current_size=0;
  public void insertFirst(Object o){
    //you need to implement this
	  if(current_size==0){
		  array[0] = o;
		  current_size++;
	  }else if(current_size != capacity){
		  int j = current_size;
		  while(j>0){
			  array[j] = array[j-1];
			  j--;
		  }
		  array[0]= o;
		  current_size++;
	  }else if(current_size == capacity){
		  Object[] newarray = new Object[capacity*2];
		  for(int i = 0; i<current_size;i++){
			  newarray[i+1]= array[i];
		    }
		    array = newarray;
		    array[0] = o;
		    capacity = capacity*2;
		    current_size++;
	  }
   // throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public void insertLast(Object o){
    //you need to implement this
	  if(current_size != capacity){
		  array[current_size]= o;
		  current_size++;
	  }else if(current_size == capacity){
		  Object[] newarray = new Object[capacity*2];
		  for(int i = 0; i<current_size;i++){
			  newarray[i]= array[i];
		    }
		    array = newarray;
		    array[current_size] = o;
		    capacity = capacity*2;
		    current_size++;
	  }
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public Object removeFirst() throws EmptyDequeException{
    //you need to implement this
	  if(current_size==0){
		  throw new EmptyDequeException("stack is empty") ;
	  }
	  Object data = array[0];
	  for(int i =0; i<current_size-1 ;i++){
		  array[i]= array[i+1];
		}
	  current_size--;
	  if(current_size <= capacity/2 && current_size >=1){
		  capacity = capacity/2;
		  Object[] arra = new Object[capacity];
		  for(int k=0;k<current_size;k++){
			  arra[k]=array[k];
		  }
		  array=arra;

		  
	  }
	 // System.out.println(array.length);
	  return data;
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public Object removeLast() throws EmptyDequeException{
    //you need to implement this
	  if(current_size==0){
		  throw new EmptyDequeException("stack is empty") ;
	  }
	  Object  data= array[current_size-1];
	  array[current_size-1] =null;
	  current_size--;
	  if(current_size <= capacity/2 && current_size >=1){
		  capacity = capacity/2;
		  Object[] arra = new Object[capacity];
		  for(int k=0;k<current_size;k++){
			  arra[k]=array[k];
		  }
		  array=arra;

	  }
	  //System.out.println(array.length);
	  return data;
   // throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }

  public Object first() throws EmptyDequeException{
    //you need to implement this
	  if(current_size==0){
		  throw new EmptyDequeException("stack is empty") ;
	  }
	  return array[0];
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public Object last() throws EmptyDequeException{
    //you need to implement this
	  if(current_size==0){
		  throw new EmptyDequeException("stack is empty") ;
	  }
	  return array[current_size-1];
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public int size(){
    //you need to implement this
	  return current_size;
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }
  
  public boolean isEmpty(){
    //you need to implement this
	  boolean have = (current_size ==0);
	  return have;
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }

  public String toString(){
    //you need to implement this
	  String s = "[";
	  if(current_size==0){
		   s= s +"]";
		 }
	  for(int i =0; i< current_size ; i++){
		  if(i != current_size-1 && current_size>0){
			  s= s +array[i]+", ";
		   }else{
				 s= s +array[i]+"]";
			 }
		     
	  }
	  return s;
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  }  
}