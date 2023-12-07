package complex.response.validation;

public class NumEndingWith5 {
	
	public static int[] returnNumEndingWith5(int[] num) {
		int count =0;
		int [] temp=num;
		for(int i=0; i<num.length;i++) {
			if(num[i]%10==5) {
				count++;
			}
		}
			int [] a= new int [count];
			int count1=0;
			for(int j=0; j<temp.length;j++) {
				if(temp[j]%10==5) {
					a[count1]=temp[j];
					count1++;
				}
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		int[] num = {45, 80,70,15,445,70,80,25,60,85,72,65};
		int [] a=returnNumEndingWith5(num);
		
		for(int i:a) {
			System.out.println(i);
		}

	}
}
