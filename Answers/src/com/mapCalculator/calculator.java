package com.mapCalculator;

import java.util.ArrayList;
import java.util.List;

public class calculator {
	int x, y;
	int[] map;
	int[][] map_;
	List<String> neo_pathList, prodo_pathList;

	public calculator(int x, int y, int[] map) {
		this.x = x;
		this.y = y;
		this.map = map;
		map_ = new int[y][x];
		neo_pathList = new ArrayList<>();
		prodo_pathList = new ArrayList<>();
		
	}

	public int getResult() {
		int idx = 0;
		for(int i=0; i < y; i++) {
			
			for(int j=0; j < x; j++) {
				map_[i][j] = map[idx];
				idx++;
			}

		}
		
		// Arguments : x, y, person(1=Neo, 2=Prodo), sum, path
		map_cal(0, 0, 1, 0, "");
		map_cal(0, x-1, 2, 0, "");
		
		return compare_cal(); 
	}
	
	
	private int compare_cal() {
		
		String[] neo_results = null; 
		String[] prodo_results = null;
		int max_sum = 0;
		for(int j=0; j < neo_pathList.size(); j++) {
			neo_results = neo_pathList.get(j).split("[\\|]"); 
			
				for (int i = 0; i < prodo_pathList.size(); i++) {
					prodo_results = prodo_pathList.get(i).split("[\\|]");
					for( int k = 0; k < prodo_results.length-1 ;k++) {
						
						if(neo_results[k].equals(prodo_results[k])) {
							String same_str =neo_results[k];
							int idx_1 = Integer.parseInt(same_str.substring(0,same_str.indexOf(",")));
							int idx_2 = Integer.parseInt(same_str.substring(same_str.indexOf(",")+1));
							// 두 말다 같은 칸으로 이동시, prod의 점수를 차감함
							prodo_results[prodo_results.length-1] = ""+(Integer.parseInt(prodo_results[prodo_results.length-1])-map_[idx_1][idx_2]);
						}
					}
					
					if(Integer.parseInt(neo_results[neo_results.length-1])+Integer.parseInt(prodo_results[prodo_results.length-1]) > max_sum)
						max_sum = Integer.parseInt(neo_results[neo_results.length-1])+Integer.parseInt(prodo_results[prodo_results.length-1]);
				}
		}
		
		return max_sum;
	}
	
	
	
	
	private void map_cal(int current_y, int current_x, int person, int sum, String path){
		
		if(current_y >= y || current_x < 0 || current_x > x) {
			return;
			
		}else if(current_y < y && current_y >= 0 && current_x < x) {
			int sum_result = sum+map_[current_y][current_x];
			
			path = path+""+current_y+","+current_x+"|";
			
			
			// 경로와 점수 정보를 구분자 |로 저장
			if(person ==1  && current_y == y-1 )  {
				neo_pathList.add(path+sum_result);
			}else if( person ==2 && current_y == y-1) {
				prodo_pathList.add(path+sum_result);
			}
			
			map_cal(current_y+1, current_x-1 , person, sum_result, path);
			map_cal(current_y+1, current_x , person, sum_result, path);
			map_cal(current_y+1, current_x+1 , person, sum_result, path);
		}
		

	}
	
}
