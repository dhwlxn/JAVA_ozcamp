package search;

import java.util.List;

import java.util.Scanner;

import com.dto.CampDTO;
import com.dto.LocationDTO;
import com.dto.OptionDTO;
import com.service.CampService;
import com.service.CampServiceImpl;
import com.service.LocationService;
import com.service.LocationServiceImpl;
import page.*;


public class CampRecommend {

    public static void campChoice(List<CampDTO> resultList) {
        LocationService service = new LocationServiceImpl();
        CampService serviceCamp = new CampServiceImpl();
        OptionDTO optionList = new OptionDTO();
        CampDTO detail = new CampDTO();
        boolean find = false;

        Menu.spaceForNew();
        Menu.menuTitle("캠핑장 추천");
        while (true) {
            // 출발지 받아 반경 계산 후 최대최소 위경도 저장
            location(optionList);

            // 입력한 환경 저장
            environment(optionList);
            tag(optionList);

            // 결과 캠핑장리스트 조회
            resultList = service.findByOption(optionList);

            if (resultList.size() > 0) {
                find = true;
            }

            // 조회한 캠핑장 출력
            if (find) {
                System.out.println();
                System.out.println("                                  =================================");
                System.out.printf("                                        선택한 옵션을 포함하는 캠핑장\n");
                System.out.println("                                  =================================\n");
                int i = 1;
                for (CampDTO list : resultList) {
                    detail = serviceCamp.printDetailByCID(list.getCID());
                    System.out.println("                                    " + i + ") " + detail.getName() + "\n"
                            + "                                       ▶ " + detail.getAddress() + "\n"
                            + "                                       ▶ 부대시설 ) " + detail.getFeatures() + "\n");
                    i++;
                }
                break;
            } else {
                // 일치하는 캠핑장이 하나도 없을 때 예외처리
                System.out.println("                                  일치하는 캠핑장이 없습니다. 다시 메뉴를 선택해주세요:) ");
                Menu.userMenu(resultList);
                break;
            }
        }


        CampSearch.searchDetail(resultList);

    }


    // 출발지 입력 > 구,동 setter
    public static void location(OptionDTO optionList) {
        LocationService service = new LocationServiceImpl();
        LocationDTO localList = new LocationDTO();


        String Gu;
        String Dong;

        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("                                     출발지를 입력해주세요.");
            System.out.print("                                     ▶  구 (ex. 강남구) : ");
            Gu = input.nextLine();
            System.out.print("                                     ▶  동 (ex. 역삼동) : ");
            Dong = input.nextLine();

            localList.setGu(Gu);
            localList.setDong(Dong);


            // 구, 동 예외처리
            if (localList == null) {
                System.out.println();
                System.out.println("                                     서비스를 제공하지 않는 지역입니다. :(");
                System.out.println("                                      ※현재는 서울 지역만 가능합니다.");
                System.out.println();

            } else {
                //구, 동 받아서 위경도 반환(덮어쓰기)
                localList = service.findByDistrict(localList);
                // 반경 - 위경도 계산 후 optionList에 넣음
                district(localList, optionList);
                break;
            }
        }

    }


    // 반경 선택 후 최대, 최소 위경도 계산
    public static void district(LocationDTO localList, OptionDTO optionList) {


        /* Haversine 공식
         * 	a = sin²(Δlat/2) + cos(lat1) * cos*/

        String selectDistrict;
        int districtNum;

        double radius;
        double maxLat;
        double minLat;
        double maxLong;
        double minLong;

        double latitude = localList.getLatitude();
        double longitude = localList.getLongitude();

        Scanner input = new Scanner(System.in);
        System.out.println("                                     원하는 캠핑장의 거리를 선택해주세요.");
        do {
            System.out.println("                                    [   50km / 100km / 150km  ]");
            System.out.print("                                     ▶   ");
            selectDistrict = input.nextLine();
            districtNum = Integer.parseInt(selectDistrict);

            if (districtNum != 50 && districtNum != 100 && districtNum != 150) {
                System.out.println("                                     잘못된 입력입니다. 다시 입력해주세요.");
            }

        } while (districtNum != 50 && districtNum != 100 && districtNum != 150);

        // 반경별 최대 최소 위경도 계산
        radius = (double) districtNum;
        maxLat = latitude + Math.toDegrees(radius / 6371.0);
        minLat = latitude - Math.toDegrees(radius / 6371.0);
        maxLong = longitude + Math.toDegrees(radius / 6371.0 / Math.cos(Math.toRadians(latitude)));
        minLong = longitude - Math.toDegrees(radius / 6371.0 / Math.cos(Math.toRadians(latitude)));

        // 최대,최소 위도경도 담을 DTO
        LocationService service = new LocationServiceImpl();

        optionList.setMaxLat(maxLat);
        optionList.setMinLat(minLat);
        optionList.setMaxLong(maxLong);
        optionList.setMinLong(minLong);


    }


    // 환경 선택
    public static void environment(OptionDTO optionList) {

        String answer;
        char optionEnv = '0';

        Scanner input = new Scanner(System.in);
        System.out.println("                                     원하시는 환경을 골라주세요 :)");
        do {
            System.out.println("                              [   강 / 계곡 / 산 / 숲 / 바다 / 도심 / 호수  ]");
            System.out.print("                                     ▶   ");
            answer = input.nextLine();

            if (!answer.equals("강") && !answer.equals("계곡")
                    && !answer.equals("산") && !answer.equals("숲")
                    && !answer.equals("바다") && !answer.equals("도심")
                    && !answer.equals("호수")) {
                System.out.println("                                     잘못된 입력입니다. 다시 입력해주세요.");
            }

        } while (!answer.equals("강") && !answer.equals("계곡")
                && !answer.equals("산") && !answer.equals("숲")
                && !answer.equals("바다") && !answer.equals("도심")
                && !answer.equals("호수"));

        if (answer.equals("강")) optionEnv = '1';
        else if (answer.equals("계곡")) optionEnv = '2';
        else if (answer.equals("산")) optionEnv = '3';
        else if (answer.equals("숲")) optionEnv = '4';
        else if (answer.equals("바다")) optionEnv = '5';
        else if (answer.equals("도심")) optionEnv = '6';
        else if (answer.equals("호수")) optionEnv = '7';

        optionList.setEnvironment(optionEnv);

    }


    // tag(물놀이, 놀이터, 전기, wifi)
    public static void tag(OptionDTO optionList) {


        System.out.println("                                     원하시는 캠핑장의 태그를 선택해주세요:)  ");

        CampRecommend myoption = new CampRecommend();
        char optionSwim = myoption.optionCheck("물놀이");
        char optionPlay = myoption.optionCheck("놀이터");
        char optionElec = myoption.optionCheck("전기");
        char optionWifi = myoption.optionCheck("wifi ");


        optionList.setWater_pool(optionSwim);
        optionList.setPlayground(optionPlay);
        optionList.setElectricity(optionElec);
        optionList.setWifi(optionWifi);


    }


    // 옵션 선택 반복 로직 Y/N
    public char optionCheck(String option) {
        Scanner input = new Scanner(System.in);
        String answer;
        char choice = '0';

        do {
            System.out.print("                                     ▶  #Tag. " + String.format("%-4s", option) + " (Y/N) : ");
            answer = input.nextLine();

            if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.println("                                     잘못된 입력입니다. Y 또는 N을 입력해주세요.");
            }

        } while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));

        if (answer.equalsIgnoreCase("y")) {
            choice = '1';
        }

        return choice;
    }

}
