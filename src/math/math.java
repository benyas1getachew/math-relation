package math;
import java.util.*;

public class math {

	public static void main(String[] args) {
		
		/*take input for relation which is similar like an array of size 2 arrays
		or something like that(i will start by directly giving values*/
		
		
		Scanner in =new Scanner(System.in);
		System.out.println("how many elements");
		int count=in.nextInt();
		System.out.println("Start");
		
		ArrayList<int[]>  List=new ArrayList<int[]>();
		for(int i=0;i<count;i++) {
			String[] Inlist=new String[2];
			
			try {
				Inlist=in.nextLine().split(",");
				int[] nums=new int[2];
				nums[0]=Integer.parseInt(Inlist[0]);
				nums[1]=Integer.parseInt(Inlist[1]);
				List.add(nums);
			}catch(NumberFormatException e) {
				System.out.println("please enter numbers");
				i--;
				continue;
			}catch(InputMismatchException e) {
				i--;
				System.out.println("please enter correctly");
				//List.remove(i++);
				continue;
			}catch(ArrayIndexOutOfBoundsException e) {
				i--;
				System.out.println("please enter 2 numbers at a time");
				//List.remove(List.size()-1);
				continue;
			}
			if(Inlist.length>2) {
				i--;
				System.out.println("please enter only 2 numbers at a time");
				List.remove(List.size()-1);
				continue;
			}
			
			
		}
		
		
		in.close();
		
		
		//check if reflexive
		int ref=0;
		for(int i=0;i<List.size();i++) {
			int x=0;
			int y=0;
			for(int j=0;j<List.size();j++) {
				if(List.get(i)[0]==List.get(i)[1]) {
					x++;
					x++;
					break;
				}
				if(List.get(i)[0]==List.get(j)[0]&&List.get(j)[0]==List.get(j)[1]) {
					x++;
				}
				if(List.get(i)[1]==List.get(j)[0]&&List.get(j)[0]==List.get(j)[1]) {
					x++;
				}
			}
			if(List.get(i)[0]!=List.get(i)[1]&&(x<2)) {
				ref++;
				break;
			}
		}
		// if ref is 1 it is not reflexive
		
		
		//check if transitive
		int tran=0;
		for(int i=0;i<List.size();i++) {
			int x=0;
			for(int j=0;j<List.size();j++) {
				if(List.get(i)[1]==List.get(j)[0]) {
					x++;
					for(int k=0;k<List.size();k++) {
						if(List.get(i)[0]==List.get(k)[0]) {
							if(List.get(j)[1]==List.get(k)[1]) {
								x--;
							}
						}
					}
				}
				
			}
			if(x>0) {
				tran++;
				break;
			}
		}
		//if tran is 1 that means it is not transitive
		
		
		//check if symmetric
		int sym=0;
		for (int i=0;i<List.size();i++) {
			int x=0;
			for(int j=0;j<List.size();j++) {
				if(List.get(i)[1]==List.get(j)[0]) {
					if(List.get(i)[0]==List.get(j)[1]) {
						x++;
						break;
					}
				}
			}
			if(x==0) {
				sym++;
				break;
			}
		}
		//if sym is then it is not symmetric
		
		
		//check if antisymmetric
		int antiSym=0;
		for (int i=0;i<List.size();i++) {
			int x=0;
			for(int j=0;j<List.size();j++) {
				if(List.get(i)[1]==List.get(j)[0]) {
					
					if(List.get(i)[0]==List.get(j)[1]) {
						if(List.get(i)[0]!=List.get(i)[1]) {
							x++;
						}
					}
				}
			}
			if(x>0) {
				antiSym++;
				break;
			}
		}
		//if antiSym is 1 then it is not asymmetric
		
		
		//print the final answer
		if(ref==0&&tran==0&&sym==0) {
			System.out.println("Equivalence Relation");
		}
		else if(ref==0&&tran==0&&antiSym==0) {
			System.out.println("Partial order set");
		}
		else {
			System.out.println("neither");
		}
	}

}
