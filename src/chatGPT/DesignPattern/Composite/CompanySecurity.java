package chatGPT.DesignPattern.Composite;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 컴포지트 패턴 - 회사 보안 시스템
 */
public class CompanySecurity {
	public static void main(String[] args) {
		Resource root = new ResourceGroup("Project A");
		FileResource spec = new FileResource("spec.docx");
		FileResource design = new FileResource("design.png");

		root.add(spec);
		root.add(design);
		spec.addAuthority("write");


		ResourceGroup db = new ResourceGroup("DB Tables");
		DBResource users = new DBResource("users");
		DBResource logs = new DBResource("logs");

		db.add(users);
		db.add(logs);
		users.addAuthority("write");
		users.addAuthority("delete");

		root.add(db);
		root.show(0);

		System.out.println(root.checkPermission("delete"));
		System.out.println(root.checkPermission("execute"));
	}
}

abstract class Resource {
	protected Map<String, Boolean> authority;
	protected String name;

	public Resource(String name){
		this.authority = setAuthority();
		this.name = name;
	}

	private Map<String, Boolean> setAuthority() {
		Map<String,Boolean >resultMap = new HashMap<String, Boolean> ();

		resultMap.put("read", true);
		resultMap.put("write", false);
		resultMap.put("delete", false);
		resultMap.put("execute",false);

		return resultMap;
	}

	protected String getAuthority() {
		return authority.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.joining(",", "(권한: ", ")"));
	}

	public void addAuthority(String auth) {
		throw new UnsupportedOperationException(this.getClass().getSimpleName() +"에 addAuthority 기능은 제공하지 않습니다.");
	}

	public void add(Resource resource) {
		throw new UnsupportedOperationException(this.getClass().getSimpleName() +"에 add 기능은 제공하지 않습니다.");
	}

	public boolean checkPermission(String permission) {
		for( Map.Entry<String, Boolean> entry : authority.entrySet() ) {
			if( entry.getKey().equalsIgnoreCase(permission) && entry.getValue() ) {
				return true;
			}
		}

		return false;
	}

	protected void showDepth(int depth) {
		System.out.print(" ".repeat(depth));
	}

	public abstract void show(int depth);
}

class FileResource extends Resource {

	public FileResource(String name) {
		super(name);
	}

	@Override
	public void addAuthority(String auth) {
		if( authority.containsKey(auth) ) {
			authority.put(auth, true);
			return;
		}

		throw new IllegalArgumentException("잘못된 권한입니다: " + auth);
	}

	@Override
	public void show(int depth) {
		showDepth(depth);
		System.out.printf("- File: %s \t%s%n", name, getAuthority());
	}
}

class APIResource extends Resource {

	public APIResource(String name) {
		super(name);
	}

	@Override
	public void addAuthority(String auth) {
		if( authority.containsKey(auth) ) {
			authority.put(auth, true);
			return;
		}

		throw new IllegalArgumentException("잘못된 권한입니다: " + auth);
	}


	@Override
	public void show(int depth) {
		showDepth(depth);
		System.out.printf("- API: %s \t%s%n", name, getAuthority());
	}

}

class DBResource extends Resource {

	public DBResource(String name) {
		super(name);
	}

	@Override
	public void addAuthority(String auth) {
		if( authority.containsKey(auth) ) {
			authority.put(auth, true);
			return;
		}

		throw new IllegalArgumentException("잘못된 권한입니다: " + auth);
	}


	@Override
	public void show(int depth) {
		showDepth(depth);
		System.out.printf("- %s \t%s%n", name, getAuthority());
	}
}

class ResourceGroup extends Resource {
	private List<Resource> resourceList = new ArrayList<>();

	public ResourceGroup(String name) {
		super(name);
	}

	@Override
	public void add(Resource resource) {
		resourceList.add(resource);
	}

	@Override
	public void show(int depth) {
		System.out.println("그룹: " + name);

		for(Resource resource : resourceList ) {
			resource.show(depth+1);
		}
	}


	@Override
	protected String getAuthority() {
		return null;
	}

	@Override
	public boolean checkPermission(String permission) {
		for (Resource resource : resourceList) {
			if (resource.checkPermission(permission)) {
				return true;
			}
		}

		return false;
	}
}