package chatGPT.DesignPattern.decorator;

/**
 * 데코레이터 패턴 - 파일 입출력 로깅
 */
public class FileInput {
	public static void main(String[] args) {
		DataWriter writer = new FileWriter();

		writer = new LoggerWriter(writer);
		writer = new EncryptWriter(writer);

		writer.write("Hello World");
	}
}

interface DataWriter {
	void write(String data);
}

class FileWriter implements DataWriter {


	@Override
	public void write(String data) {
		System.out.println("파일 저장: " + data);
	}
}

abstract class WriterDecorator implements DataWriter {
	private final DataWriter writer;

	public WriterDecorator(DataWriter writer) {
		this.writer = writer;
	}

	@Override
	public void write(String data) {
		writer.write(data);
	}

}

class EncryptWriter extends WriterDecorator{
	public EncryptWriter(DataWriter writer) {
		super(writer);
	}

	@Override
	public void write(String data) {
		super.write(String.format("암호화된(%s)",  data));
	}
}

class CompressWriter extends WriterDecorator {
	public CompressWriter(DataWriter writer) {
		super(writer);
	}

	@Override
	public void write(String data) {
		super.write(String.format("압축된(%s)", data));
	}
}

class LoggerWriter extends WriterDecorator {
	public LoggerWriter(DataWriter writer) {
		super(writer);
	}

	@Override
	public void write(String data) {
		System.out.println("[로그] 데이터 쓰기 시작");
		super.write(data);
	}
}