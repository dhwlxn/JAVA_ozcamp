package search;

import java.util.Scanner;

public class CampRecommend{
	
	public static void thema() {
		Scanner input = new Scanner(System.in);
		System.out.println("==== 원하시는 테마를 골라주세요 :) ====");
		String answer;
		int optionThema;
		
		do {
			System.out.println(" 강 / 계곡 / 산 / 숲 / 바다 / 도심 / 호수");
			answer = input.nextLine();
			
			if (!answer.equals("강") && !answer.equals("계곡")
					&& !answer.equals("산") && !answer.equals("숲")
					&& !answer.equals("바다") && !answer.equals("도심")
					&& !answer.equals("호수")) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
			
		}while(!answer.equals("강") && !answer.equals("계곡")
				&& !answer.equals("산") && !answer.equals("숲")
				&& !answer.equals("바다") && !answer.equals("도심")
				&& !answer.equals("호수"));
		
		if(answer.equals("강")) optionThema = 1;
		else if(answer.equals("계곡")) optionThema = 2;
		else if(answer.equals("산")) optionThema = 3;
		else if(answer.equals("숲")) optionThema = 4;
		else if(answer.equals("바다")) optionThema = 5;
		else if(answer.equals("도심")) optionThema = 6;
		else if(answer.equals("호수")) optionThema = 7;
		
	}
	
	// tag(물놀이, 놀이터, 전기, wifi)
	public static void tag() {
		
	
	System.out.println("=====   원하시는 캠핑장의 태그를 선택해주세요:)   ====");
	
	CampRecommend myoption = new CampRecommend();
	boolean optionSwim = myoption.optionCheck("물놀이");
	boolean optionPlay = myoption.optionCheck("놀이터");
	boolean optionElec = myoption.optionCheck("전기");
	boolean optionWifi = myoption.optionCheck("wifi");

		
	}
	
	public boolean optionCheck(String option)
	{
		Scanner input = new Scanner(System.in);
		String answer;
		boolean choice = false;
		
		do {
			System.out.print("#Tag. " + option +  " (Y/N) : ");	
			answer = input.nextLine();
			
			if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
				System.out.println("잘못된 입력입니다. Y 또는 N을 입력해주세요.");
			}
			
		}while(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
		
		if(answer.equalsIgnoreCase("y"))
		{
			choice = true;
		}
		
		return choice;
	}
	
}
