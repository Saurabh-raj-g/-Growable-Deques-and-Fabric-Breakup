//package part_B;

//import part_A.ArrayDeque;
//import part_A.DequeInterface;
//import part_A.EmptyDequeException;

//package col106A1_partA; 
// You should utilise your implementation of ArrayDeque methods to implement this
public class Stack implements StackInterface {
	  DequeInterface myArrayDeque = new ArrayDeque();
	  /*  int capacity = 1;
	    Object[] array = new Object[capacity];
	    int current_size=0;*/
	public void push(Object o){
		
    	//you need to implement this
		myArrayDeque.insertLast(o);
		 /*if(current_size != capacity){
			  array[current_size]= o;
			  current_size++;
		  }else if(current_size == capacity){
			  Object[] newarray = new Object[capacity*2];
			  for(int i = 0; i<current_size;i++){
				  newarray[i]= array[i];
			    }
			    array = newarray;
			    capacity = capacity*2;
			    array[current_size] = o;
			    
			    current_size++;
		  }*/
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  	}

	public Object pop() throws EmptyStackException{
    	//you need to implement this
		if(myArrayDeque.isEmpty()){
			throw new EmptyStackException("stack is empty");
		}
		  Object data = null;
		try {
			data = myArrayDeque.removeLast();
		} catch (EmptyDequeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return data;
		 /* Object  data= array[current_size-1];
		  array[current_size-1] =0;
		  current_size--;
		  if(current_size <= capacity/2 && current_size >1){
			  capacity = capacity/2;
		  }
		  return data; */
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	public Object top() throws EmptyStackException{
    	//you need to implement this
		if(myArrayDeque.isEmpty()){
			throw new EmptyStackException("stack is empty");
		}
		  Object data = null;
		try {
			data = myArrayDeque.last();
		} catch (EmptyDequeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return data;
		//return array[current_size-1];
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	public boolean isEmpty(){
    	//you need to implement this
		//boolean have = (current_size ==0);
		return myArrayDeque.isEmpty();
		 // return have;
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

    public int size(){
    	//you need to implement this
    	return myArrayDeque.size();
    	//return current_size;
    	//throw new java.lang.UnsupportedOperationException("Not implemented yet.");
    }
}