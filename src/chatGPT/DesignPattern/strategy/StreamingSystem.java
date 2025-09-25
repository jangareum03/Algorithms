package chatGPT.DesignPattern.strategy;

/**
 * 전략 패턴 - 추천 시스템
 */
public class StreamingSystem {
	public static void main(String[] args) {
		RecommendationService service = new RecommendationService(new GenreBasedRecommendation());
		service.recommend("user123");

		service.setStrategy(new PopularityBasedRecommendation());
		service.recommend("user123");

		service.setStrategy(new PersonalizedRecommendation());
		service.recommend("user123");
	}
}

interface RecommendationStrategy {
	void recommend(String userId);
}

class GenreBasedRecommendation implements RecommendationStrategy {
	@Override
	public void recommend(String userId) {
		System.out.printf("[장르 기반 추천] %s님을 위한 추천 영화: 액션 영화 Top3%n", userId);
	}
}

class PopularityBasedRecommendation implements RecommendationStrategy {
	@Override
	public void recommend(String userId) {
		System.out.printf("[인기 기반 추천] %s님을 위한 추천 영화: 전체 인기 영화 Top3%n", userId);
	}
}

class PersonalizedRecommendation implements RecommendationStrategy {
	@Override
	public void recommend(String userId) {
		System.out.printf("[개인화 추천] %s님을 위한 추천 영화: AI 맞춤 영화 Top3%n", userId);
	}
}

class RecommendationService {
	private RecommendationStrategy strategy;

	public RecommendationService(RecommendationStrategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(RecommendationStrategy strategy) {
		this.strategy = strategy;
	}

	public void recommend(String userId) {
		strategy.recommend(userId);
	}
}
