package chatGPT.dataStructure.set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 셋 - 최근 접속한 유저
 */
public class RecentLoginUsers {
	public static void main(String[] args) {
		Set<String> recentUsers = new LinkedHashSet<>();


		String[] logins = {"anna", "mike", "john", "mike", "sara", "anna"};
		for( String login : logins ) {
			recentUsers.add(login);
		}

		System.out.println(recentUsers);
	}
}