/*
 *@author ShaneHolmes
 *date:2018.5.7
 *@Right Copy.All right reserved.
**/
package zyd.hw1.sum;
public class SumOfArgs {
	public static void main(String [] args){
		int sum = 0;
		for(String s : args){
			int a= 0;
			try{
				if(s!=null&&s.matches("^[0-9]+$"))
					a = Integer.parseInt(s);
			}catch(NumberFormatException e){
				a = 0;
			}finally{
				sum += a;
			}
		}
		System.out.println(sum);
	}
}
