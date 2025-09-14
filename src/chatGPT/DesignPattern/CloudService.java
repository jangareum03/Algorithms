package chatGPT.DesignPattern;

/**
 * 추상 팩토리 문제 - 클라우드 서비스 리소스 관리
 */
public class CloudService {
	public static void main(String[] args) {
		CloudFactory factory = new AWSFactory();

		VMInstance vm = factory.createVM("ap-northeast-2");
		Storage storage = factory.createStorage();

		vm.start();
		storage.upload("data.zip");
	}
}

//--- VM인스턴스 ---
interface VMInstance {
	void start();
}

class AwsVM implements VMInstance {
	@Override
	public void start() {
		System.out.println("VM 실행 시작");
	}
}

class AzureVM implements VMInstance {
	@Override
	public void start() {
		System.out.println("VM 실행 시작");
	}
}

class GcpVM implements VMInstance {
	@Override
	public void start() {
		System.out.println("VM 실행 시작");
	}
}


//--- 저장 ---
interface Storage {
	void upload(String file);
}

abstract class BasicStorage implements Storage{
	@Override
	public void upload(String  file) {
		System.out.println("파일 업로드: " + file);
	}

	protected abstract void create();
}

class AwsStorage extends BasicStorage {
	@Override
	protected void create() {
		System.out.println("AWS 스토리지 생성 완료");
	}
}

class AzureStorage extends BasicStorage {
	@Override
	protected void create() {
		System.out.println("Azure 스토리지 생성 완료");
	}
}

class GcpStorage extends BasicStorage {
	@Override
	protected void create() {
		System.out.println("Gcp 스토리지 생성 완료");
	}
}


//--- 클라우드에 필요한 객체 모음 ---
interface CloudFactory {
	VMInstance createVM(String region);
	Storage createStorage();
}

class AWSFactory implements CloudFactory {
	@Override
	public VMInstance createVM(String region) {
		switch (region.toLowerCase()) {
			case "ap-northeast-2", "us-east-1", "eu-west-1":
				System.out.println("AWS VM 인스턴스(" + region + ") 생성 완료");
				return new AwsVM();
			default :
				throw new IllegalArgumentException("리전(region)을 잘못 입력하였습니다: " + region);
		}
	}

	@Override
	public Storage createStorage() {
		AwsStorage storage = new AwsStorage();
		storage.create();

		return storage;
	}
}

class AzureFactory implements CloudFactory {
	@Override
	public VMInstance createVM(String region) {
		switch (region.toLowerCase()) {
			case "korea central", "east us", "west europe" :
				System.out.println("Azure VM 인스턴스(" + region + ") 생성 완료");
				return new AzureVM();
			default:
				throw new IllegalArgumentException("리전(region)을 잘못 입력하였습니다.: " + region);
		}
	}

	@Override
	public Storage createStorage() {
		AzureStorage storage = new AzureStorage();
		storage.create();

		return storage;
	}
}

class GcpFactory implements CloudFactory {
	@Override
	public VMInstance createVM(String region) {
		switch (region.toLowerCase()) {
			case "asia-northeast3", "us-central1", "europe-west1":
				System.out.println("GCP VM 인스턴스(" + region + ") 생성 완료");
				return  new GcpVM();
			default :
				throw new IllegalArgumentException("리전(region)을 잘못 입력하였습니다: " + region);
		}
	}

	@Override
	public Storage createStorage() {
		GcpStorage storage = new GcpStorage();
		storage.create();

		return storage;
	}
}

