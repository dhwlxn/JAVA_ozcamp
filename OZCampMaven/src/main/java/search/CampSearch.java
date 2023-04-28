package search;

import java.util.ArrayList;
import java.util.Scanner;

public class CampSearch {
	
   public static void search() {
	  
	  String[] campgrounds = {"a", "ab", "abc", "abcd efg"};
	  
	  // 사용자 입력값 받아 조회
      Scanner input = new Scanner(System.in);

      while(true)
      {
    	  System.out.print("찾으시는 캠핑장 이름을 입력하세요. : ");
    	  String searchName = input.nextLine();
    	  boolean find = false;
    	  
    	  // 입력값과 기존 캠핑장 이름 비교
    	  for(String campground : campgrounds)
    	  {
    		  if(campground.contains(searchName))
    		  {
    			  System.out.println(campground);
    			  find = true;    		  
    		  }
    		  
    	  }
    	  if(find)break;
    	  else
    	  {
    		  // 일치하는 캠핑장이 하나도 없을 때 예외처리
    		  System.out.println("일치하는 캠핑장이 없습니다. 다시 입력해주세요:) ");
    	  }
    	  
      }
   }
}
