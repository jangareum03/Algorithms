package chatGPT.DesignPattern.prototype;

/**
 * 프로토타입 패턴 - 문서 템플릿
 */
public class DocumentTemplate {
	public static void main(String[] args) {
		Contract contract = new Contract();
		contract.createFile();

		Report report = new Report();
		report.createFile();

		//복제
		Contract copyContract = contract.clone();
		copyContract.setWriter("홍길동");
		System.out.println("복제된 계약서: " + copyContract);

		Report copyReport = report.clone();
		copyReport.setWriter("이순신");
		System.out.println("복제된 보고서: " + copyReport);
	}
}


abstract class Document implements Cloneable {
	private String title;
	private String content;
	private String writer;

	protected Document(String title, String content) {
		this.title = title;
		this.content = content;
		this.writer = "작성자";
	}

	@Override
	public Document clone() {
		try {
			return (Document) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "제목=" + title + ", 작성자=" + writer;
	}

	protected abstract void createFile();
}

//-- 계약서 ---
class Contract extends Document {
	public Contract() {
		super("계약서", "기본 내용");
	}

	@Override
	public void createFile() {
		System.out.println("계약서 탬플릿 생성됨");
	}

	@Override
	public Contract clone() {
		return (Contract) super.clone();
	}
}

//--- 보고서 ---
class Report extends Document {
	protected Report() {
		super("보고서", "기본 내용");
	}

	@Override
	public void createFile() {
		System.out.println("보고서 템플릿 생성됨");
	}

	@Override
	public Report clone() {
		return (Report) super.clone();
	}
}
