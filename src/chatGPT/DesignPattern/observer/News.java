package chatGPT.DesignPattern.observer;

import java.util.*;

/**
 * 옵저버 패턴 - 뉴스 구독
 */
public class News {
	public static void main(String[] args) {
		NewsPublisher publisher = new NewsPublisher();

		Subscriber kim = new Subscriber("Kim");
		Subscriber lee = new Subscriber("Lee");
		Subscriber park = new Subscriber("Park");

		// 구독
		publisher.addSubscriber(NewsCategory.POLITICS, kim);
		publisher.addSubscriber(NewsCategory.ECONOMY, kim);
		publisher.addSubscriber(NewsCategory.SPORT, lee);
		publisher.addSubscriber(NewsCategory.POLITICS, park);

		publisher.publisher(NewsCategory.POLITICS, "정치 뉴스1");
		publisher.publisher(NewsCategory.SPORT, "스포츠 뉴스1");
		publisher.publisher(NewsCategory.ECONOMY, "경제 뉴스1");
	}
}

enum NewsCategory {
	POLITICS("정치"),  ECONOMY("경제"), SPORT("스포츠"), SOCIETY("사회");

	private final String name;

	NewsCategory(String  name) {
		this.name = name;
	}

	public String getName(NewsCategory category) {
		return name;
	}
}

class NewsPublisher {
	private final Map<NewsCategory, List<Subscriber>> subscribersByCategory  = new HashMap<>();

	public void addSubscriber(NewsCategory category, Subscriber subscriber) {
		subscribersByCategory
				.computeIfAbsent( category, k -> new ArrayList<>() )
				.add(subscriber);
	}

	public void removeSubscriber(NewsCategory category, Subscriber subscriber) {
		subscribersByCategory
				.getOrDefault(category, new ArrayList<>())
				.remove(subscriber);
	}

	public void publisher(NewsCategory category, String title) {
		List<Subscriber> subscribers = subscribersByCategory.get(category);

		for( Subscriber s : subscribers ) {
			s.show(category, title);
		}
	}
}

class Subscriber {
	private final String name;

	public Subscriber(String name) {
		this.name = name;
	}

	public void show(NewsCategory category, String title) {
		System.out.printf("[%s] 구독 카테고리 '%s' 새 뉴스: %s%n", name, category.name(), title);
	}
}