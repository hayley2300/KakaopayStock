package com;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.decoder.decoder;
import com.mapCalculator.calculator;

public class main_class {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		
		// 문제 1, decoding
		String encoded_str = scanner.next();
		if(!Pattern.matches("^[a-zA-Z0-9\\[\\]]*$",encoded_str)
				&&(encoded_str.length() < 0 || encoded_str.length() >= 128 )) {
			System.out.println("괄호 이외 특수문자 사용 불가능, 문자열 길이가 범위를 벗어났습니다.");
			scanner.close();
			return;
		}else if(!Pattern.matches("^[a-zA-Z0-9\\[\\]]*$",encoded_str)){
			System.out.println("괄호 이외 특수문자 사용 불가능합니다.");
			scanner.close();
			return;
		}else if(encoded_str.length() < 0 || encoded_str.length() >= 128) {
			System.out.println("문자열 길이가 범위를 벗어났습니다.");
			scanner.close();
			return;
		}else {
			decoder dc = new decoder(encoded_str);
			System.out.println(dc.getDecoding_str());
			System.out.println("");
		}
		
		
		
		
		// 문제 2, 점수 구하기
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		String value = scanner.next();
		String[] result = value.split("[\\,]");
		int[] map = new int[result.length];
		for(int i = 0; i < result.length; i ++) {
			if(-100 >= map[i] || map[i] > 99)
			{
				System.out.println("각 점수 범위는 -100 < 점수 < 100 입니다.");
				scanner.close();
				return;
			}
			map[i] = Integer.parseInt(result[i]);
		}
		if( (x > 3 && x < 50 && y > 3 && y < 50)) {
			calculator cl = new calculator(x,y,map);
			System.out.println(cl.getResult());
			scanner.close();
			return;
		
		}else {
			System.out.println("말판의 가로 x, 세로 y의 범위는 3 < x, y < 50 입니다.");
			scanner.close();
			return;
		}
	}
}
