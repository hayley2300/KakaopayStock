package com.decoder;
import java.util.Stack;

public class decoder {
	String encoded_str;
	
	public decoder(String encoded_str){
		this.encoded_str = encoded_str;
	}
	
	public String getDecoding_str() {
		return decoding_str(encoded_str);
	}
	
	private String decoding_str(String encoded_str) {
		
		String return_val = encoded_str;
		char[] char_arr =encoded_str.toCharArray();
		Stack<Character> stack = new Stack<>();
		int left_idx=0, right_idx=0;
		String num="";
		String result_str ="";
		boolean flag = false;
		
		for(int j =0; j < char_arr.length; j ++) {
			
			if(char_arr[j]=='[') {
				left_idx = j;
			}else if(char_arr[j]==']') {
				right_idx = j;
				String str="";
				// stack에 aaa31bb 식으로 쌓인 경우 => 31bb만 추출후 break
				while(!stack.empty()) {
					if(!Character.isDigit(stack.peek()) && flag!=true)
					{
						str = stack.peek()+str;
						stack.pop();
					}else if(Character.isDigit(stack.peek())&& flag!=true){
						num = stack.peek()+num;
						stack.pop();
						flag=true;
					}else
						break;
				}
				
				for(int k =0; k < Integer.parseInt(num); k++) {
					result_str = result_str+str;
				}
				
				left_idx = left_idx - num.length();
				return_val = return_val.replace(return_val.substring(left_idx, right_idx+1), result_str);
				
				return decoding_str(return_val);
				
			}else {
				stack.push(char_arr[j]);
			}
			
		}

		
		return return_val;
	}

}
