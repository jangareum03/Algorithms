package chatGPT.DesignPattern.proxy;

import java.util.*;

// 클라이언트
public class InSystem {
	public static void main(String[] args) {
		// 클라이언트에서 사용자 권한을 부여
		List<String> permissions = Arrays.asList("HR", "Finance");
		Report reportProxy = new ReportProxy(permissions);

		// 1. 권한 있는 부서 최초 요청
		System.out.println(reportProxy.getReport("HR"));

		// 2. 같은 부서 반복 요청 (캐싱됨)
		System.out.println(reportProxy.getReport("HR"));

		// 3. 권한 없는 부서 요청
		System.out.println(reportProxy.getReport("IT"));
	}
}

// 공통 인터페이스
interface Report {
	String getReport(String department);
}

// 실제 객체 (비용이 큰 작업)
class ReportService implements Report {
	@Override
	public String getReport(String department) {
		System.out.println("보고서 생성 중...");
		return "부서 보고서: " + department;
	}
}

// 프록시 객체 (보안 + 캐싱)
class ReportProxy implements Report {
	private ReportService reportService = new ReportService();
	private Map<String, String> cache = new HashMap<>();
	private List<String> permissions; // 접근 가능한 부서 권한 목록

	public ReportProxy(List<String> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String getReport(String department) {
		// 1. 권한 확인
		if (!permissions.contains(department)) {
			return "접근 권한 없음";
		}

		// 2. 캐싱 확인
		if (cache.containsKey(department)) {
			return cache.get(department);
		}

		// 3. 실제 객체 호출 후 캐싱
		String report = reportService.getReport(department);
		cache.put(department, report);
		return report;
	}
}
