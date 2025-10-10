package chatGPT.DesignPattern.chain;

/**
 * 책임 연쇄 패턴 - 문서 승인
 */
public class DocumentChain {
	public static void main(String[] args) {
		ApprovalHandler team = new TeamLeader();
		ApprovalHandler depart = new DepartmentHead();
		ApprovalHandler exe = new Executive();

		team.setNextHandler(depart);
		depart.setNextHandler(exe);

		team.requestApproval(50);
		team.requestApproval(500);
		team.requestApproval(1500);
	}
}

abstract class ApprovalHandler {
	protected ApprovalHandler nextHandler;

	public void setNextHandler(ApprovalHandler handler) {
		this.nextHandler = handler;
	}

	protected abstract void requestApproval(int price);
}

class TeamLeader extends ApprovalHandler {
	@Override
	protected void requestApproval(int price) {
		if( 0 < price && price <= 100 ) {
			System.out.println("팀장 승인");
		}else if(nextHandler != null) {
			nextHandler.requestApproval(price);
		}
	}
}

class DepartmentHead extends ApprovalHandler {
	@Override
	protected void requestApproval(int price) {
		if( 100 < price && price <= 1000 ) {
			System.out.println("부사장 승인");
		}else if( nextHandler != null ){
			nextHandler.requestApproval(price);
		}
	}
}

class Executive extends ApprovalHandler {
	@Override
	protected void requestApproval(int price) {
		if( 1000 < price ) {
			System.out.println("임원 승인");
		}else if(nextHandler != null) {
			nextHandler.requestApproval(price);
		}
	}
}