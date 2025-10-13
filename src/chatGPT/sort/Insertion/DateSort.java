package chatGPT.sort.Insertion;

import java.time.LocalDate;

/**
 * 삽입 정렬 - 날짜 오름차순
 */
public class DateSort {
	public static void main(String[] args) {
		Log[] logs = {
				new Log("2025-03-12", "System restart"),
				new Log("2025-01-28", "User login"),
				new Log("2025-02-05", "Server update")
		};

		for( int i=1; i<logs.length; i++ ) {
			Log key = logs[i];
			int j = i-1;

			LocalDate keyDate = LocalDate.parse(key.date);

			while ( j >= 0 && LocalDate.parse(logs[j].date).isAfter(keyDate)) {
				logs[j+1] = logs[j];
				j--;
			}

			logs[j+1] = key;
		}

		for(Log l : logs) {
			System.out.println(l.date + " : " + l.message);
		}
	}
}

class Log {
	String date;
	String message;

	public Log(String date, String message) {
		this.date = date;
		this.message = message;
	}
}