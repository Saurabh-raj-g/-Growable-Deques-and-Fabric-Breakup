//package part_B;
import java.io.File;  // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FabricBreakup {	
	public static void main(String args[])  {
		// Implement FabricBreakup puzzle using Stack interface
		Stack score_stack = new Stack();
		
		Stack max_score_stack = new Stack();
		int data = 0 ;
		//int m = 0;
		int result = 0;
		 File myObj = new File(args[0]);
				Scanner myReader = null;
				try {
					myReader = new Scanner(myObj);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     
		      if(myReader.hasNextLine()){
		    	   data = Integer.parseInt(myReader.nextLine());
			        //System.out.println(data);
			  }
		      for(int i=0; i< data; i++) {
		        String[] queriesRowItems = myReader.nextLine().split(" ");
		      
		      
		       if(queriesRowItems.length == 3||queriesRowItems.length == 2){
		        	  
				        if(Integer.parseInt(queriesRowItems[1])==1){
				        	score_stack.push(Integer.parseInt(queriesRowItems[2]));
				        
				        	if(max_score_stack.isEmpty())
				        	{
				        		max_score_stack.push(Integer.parseInt(queriesRowItems[2]));
				        	} else
								try {
									if((int)score_stack.top()-(int)max_score_stack.top()>=0){
										max_score_stack.push(Integer.parseInt(queriesRowItems[2]));
									}
								} catch (NumberFormatException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (EmptyStackException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				        	
				        }
				        if(Integer.parseInt(queriesRowItems[1])==2){
				        	if(max_score_stack.isEmpty()){
				        		//print -1;
				        		System.out.println(i+1 +" "+-1);
				        	}
				        	else{
				        		int top=0;
								try {
									top = (int)(max_score_stack.pop());
								} catch (EmptyStackException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
				        		int  count=0;
				        		
				        		try {
									while(top!=(int)score_stack.top()){				        	
										try {
											score_stack.pop();
										} catch (EmptyStackException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										count++;
									}
								} catch (EmptyStackException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				        		//print count;
				        		System.out.println(i+1 +" "+ count);
				        		try {
									score_stack.pop();
								} catch (EmptyStackException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}//for top shirt removal
				        	 }	
				        }
		       }
				        	
				        							        
		        
		       
		      
	}
}
}
	/*
	 /*	Stack score_stack = new Stack();
		//Stack id_stack = new Stack();
		Stack max_score_stack = new Stack();
		Stack not_max_score_index_stack = new Stack();
		int data = 0 ;
		int max_score_index = 0;
		int not_max_score_index = 0;
		int m = 0;
		try {
			
		     File myObj = new File("D:\\MyJavaDataStructure\\col106A1\\src\\part_B\\sampleInputFile.txt");
			//File myObj = new File("D:\\MyJavaDataStructure\\col106A1\\src\\part_B\\in.txt");
		    
			Scanner myReader = new Scanner(myObj);
		      //while (myReader.hasNextLine()) {
		      if(myReader.hasNextLine()){
		    	   data = Integer.parseInt(myReader.nextLine());
			        //System.out.println(data);
			  }
		         for(int i=0; i< 46; i++) {
		        String[] queriesRowItems = myReader.nextLine().split(" ");
		        //System.out.println(Integer.parseInt(queriesRowItems[1]));
		       //System.out.println(queriesRowItems[0]);
		        if(queriesRowItems.length != 3){
		          }else if(queriesRowItems.length == 3){
		        	  score_stack.push(Integer.parseInt(queriesRowItems[2]));
		        	      m++;
		        	//System.out.println(Integer.parseInt(queriesRowItems[2]));
		        }
		        
		        //id_stack.push(Integer.parseInt(queriesRowItems[1]));
		        
		        if(Integer.parseInt(queriesRowItems[1])==1 && max_score_stack.isEmpty() ){
		        	max_score_stack.push(Integer.parseInt(queriesRowItems[2]));
		        	//System.out.println(max_score_stack.top());
		        	max_score_index = m;
		        	//System.out.println(i+1+" "+max_score_index);
		        } else
					try {
						if(Integer.parseInt(queriesRowItems[1])==1 &&!max_score_stack.isEmpty()&& Integer.parseInt(queriesRowItems[2])>=(Integer)max_score_stack.top()){
							max_score_stack.push(Integer.parseInt(queriesRowItems[2]));
							//System.out.println(max_score_stack.top());
							//not_max_score_index = (m - max_score_index);
							//not_max_score_index_stack.push(not_max_score_index);
							//System.out.println(not_max_score_index_stack.top());
							max_score_index = m;
						   // System.out.println(i+1+" "+	max_score_index);
						}else if(Integer.parseInt(queriesRowItems[1])==1 &&!max_score_stack.isEmpty()&& Integer.parseInt(queriesRowItems[2])<(Integer)max_score_stack.top()){
							not_max_score_index = (m - max_score_index);
							not_max_score_index_stack.push(not_max_score_index);
						    //System.out.println(	i+1+" "+max_score_index);
						}
						else if(Integer.parseInt(queriesRowItems[1])==2 && score_stack.isEmpty() ){
							System.out.println(i+1 + " "+ -1);
							//System.out.println(score_stack.isEmpty());
							//System.out.println(i+1+" "+max_score_index);
						}
						else if(Integer.parseInt(queriesRowItems[1])==2 && !score_stack.isEmpty()){
							System.out.println(i+1+ " "+ (score_stack.size()- max_score_index));
							System.out.println(not_max_score_index_stack.size());
							//System.out.println(max_score_index);
							int h= score_stack.size()- max_score_index+1;
							for(int k=0 ; k< h ;k++){
								score_stack.pop();
								m--;
							}
							//System.out.println(score_stack.isEmpty());
							if(not_max_score_index_stack.isEmpty()){
								max_score_index --;
								//System.out.println(i+1+" "+max_score_index);
							}
							else if(!not_max_score_index_stack.isEmpty()){
								//int l = max_score_index- (Integer)not_max_score_index_stack.top()-1;
								int l = score_stack.size()- (Integer)not_max_score_index_stack.top();
								max_score_index = l== -1 ? 0:l;
								not_max_score_index=(Integer)not_max_score_index_stack.top();
								
								
								//not_max_score_index=(Integer)not_max_score_index_stack.top();
								//System.out.println(not_max_score_index_stack.isEmpty());
								//System.out.println(i+1+" "+max_score_index);
							}
							 
							if(!max_score_stack.isEmpty()){
								max_score_stack.pop();
							}
								//System.out.println(max_score_stack.isEmpty());
							//}else if(max_score_stack.isEmpty()){
								//throw new EmptyStackException("stack is empty");
							//}
							if((Integer)max_score_stack.top()<(Integer)score_stack.top()){
								for(int b=0; b< not_max_score_index; b++){
									not_max_score_index_stack.pop();
								}
							}
							
						
						//System.out.println(Integer.parseInt(queriesRowItems[1]));
						//int d =Integer.parseInt((queriesRowItems.length == 3 ? queriesRowItems[2] :"0" )) ;
						}
						 
					} /*catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} *//*catch (EmptyStackException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		        
		        //}
		        /* try {
					System.out.println(score_stack.top());
				} catch (EmptyStackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		        //System.out.println(data[1]);
		     // }
		    /*  myReader.close();
		    } catch (FileNotFoundException  e) {
		      System.out.println("File not found ");
		      e.printStackTrace();
		    } */
		//System.out.println(score_stack.isEmpty());
	 

		

