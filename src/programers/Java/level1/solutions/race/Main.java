package programers.Java.level1.solutions.race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 프로그래머스 1단계 문제
/*
얀에서는 매년 달리기 경주가 열립니다.
해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다.
즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.

선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와
해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때,
경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.

제한사항
5 ≤ players의 길이 ≤ 50,000
players[i]는 i번째 선수의 이름을 의미합니다.
players의 원소들은 알파벳 소문자로만 이루어져 있습니다.
players에는 중복된 값이 들어가 있지 않습니다.
3 ≤ players[i]의 길이 ≤ 10
2 ≤ callings의 길이 ≤ 1,000,000
callings는 players의 원소들로만 이루어져 있습니다.
경주 진행중 1등인 선수의 이름은 불리지 않습니다.
 */


// 정답은 낼 수 있으나, Callings와 Players의 길이가 수만 단위로 길어지는 경우 시간 초과,
// 원인은 List에서 index를 탐색하는 시간이 매우 길어지기 때문,
// 따라서 HashMap 사용하여 주소값 접근방식으로 시간 단축 해야 할듯
class ListSolution {
  public String[] listSolution(String[] players, String[] callings) {
    String[] answer = {};
    answer = changeRank(players, callings);
    return answer;
  }

  public String[] changeRank(String[] ranking, String[] callings) {
    for (int i=0;i<callings.length;i++){
      String name = callings[i];
      int index = findIndex(name, ranking);
      String temp = ranking[index-1];
      ranking[index-1] = ranking[index];
      ranking[index] = temp;
    }
    return ranking;

  }

  public int findIndex(String name, String[] ranking) {
    for (int i=0;i<ranking.length;i++) {
      if (ranking[i].equals(name)) {
        return i;
      }
    }
    return -1;
  }

  // 해시맵을 사용하여  1.순위(key), 이름(value) 해시맵,
  //                 2. 이름(key), 순위(value) 해시맵을 만들어
  //                 현재 불린 이름의 순위와 그 앞 선수의 이름과 순위를 계산
  //                 해싱을 통한 주소값 조회 방식으로 인덱스 탐색 시간이 들지 않음 .
}
class HashMapSolution{
  public String[] hashMapSolution(String[] players, String[] callings) {
    HashMap<String, Integer> playerNameMap = new HashMap();
    HashMap<Integer, String> playerRankMap = new HashMap();
    List<String> result = new ArrayList<String>();
    for (int i = 1; i <= players.length; i++) {
      playerNameMap.put(players[i - 1], i);
      playerRankMap.put(i, players[i - 1]);
    }
    for (int i = 0; i < callings.length; i++) {
      String callingName = callings[i];
      int callingRank = playerNameMap.get(callingName);
      int frontRank = callingRank - 1;
      String frontName = playerRankMap.get(callingRank - 1);

      // 순위 교체
      playerRankMap.replace(frontRank, callingName);
      playerRankMap.replace(callingRank, frontName);
      playerNameMap.replace(callingName, frontRank);
      playerNameMap.replace(frontName, callingRank);
    }

    for (int i = 1; i <= playerRankMap.size(); i++) {
      result.add(playerRankMap.get(i));
    }
    return result.toArray(new String[0]);
  }
}


public class Main {
  public static void main(String args[]) {
    String[] players1 ={"mumu", "soe", "poe", "kai", "mine"} ;
    String[] callings1 ={"kai", "kai", "mine", "mine"};
    ListSolution ls = new ListSolution();
    System.out.println(Arrays.toString(ls.listSolution(players1, callings1)));
    String[] players2 ={"mumu", "soe", "poe", "kai", "mine"} ;
    String[] callings2 ={"kai", "kai", "mine", "mine"};
    HashMapSolution hs = new HashMapSolution();
    System.out.println(Arrays.toString(hs.hashMapSolution(players2, callings2)));

  }
}
