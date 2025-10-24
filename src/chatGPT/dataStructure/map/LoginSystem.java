package chatGPT.dataStructure.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 맵 - 사용자 로그인
 */
public class LoginSystem {
	public static void main(String[] args) {
		Map<String, String> users = new HashMap<>();
		users.put("user01", "pass123");
		users.put("admin", "root");
		users.put("guest", "guest");

		Scanner scan = new Scanner(System.in);
		System.out.print("아이디 입력: ");
		String id = scan.nextLine();

		System.out.print("비밀번호 입력: ");
		String pwd = scan.nextLine();

		if( !users.containsKey(id) ) {
			System.out.println("존재하지 않은 아이디입니다.");
		}else if( !users.get(id).equals(pwd) ) {
			System.out.println("비밀번호가 틀렸습니다.");
		}else {
			System.out.println("로그인 성공");
		}
	}
}
