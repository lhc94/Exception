package exception0303;

//예외처리는 2가지로나뉜다
//시작전, 시작도중
//시작전 : 컴파일
//시작도중 : 런타임

class 총 {
	void shoot() {
		System.out.println("총을 발사했습니다.");
	}
}

public class ExceptoinEx01 {
	public static void main(String[] args) {
		try {
			System.out.println("잠자기 시작");
			Thread.sleep(3000);
			System.out.println("잠자기 끝");
		} catch (InterruptedException e) { // 방해할 경우!
			e.printStackTrace();
		}
		
		// 런타임 예외 (계발자가 알 수 있다)
		int[] nums = {1,2,3};
		try {
			System.out.println(nums[3]); // 강제 종료!!
		} catch (RuntimeException e) { 
			// 이 오류가 발생하면 안에 코드를 실행하고 계속 진행한다
			// catch의 역할은 try(시도)하다가 예외가 발생하면 
			System.out.println("괜찮아 그냥 진행해");
			System.out.println(e.getMessage()); // 로그 파일 남겨 나야한다. 에러 이유를 출력함
			e.printStackTrace(); // 오류를 추적함
		}
		
//		총 s = null;
//		s.shoot(); 이렇게만 하면 nullPointException이 뜸 값이 없으니까
		
		총 s = null;
		try {
			s.shoot();
		} catch (RuntimeException e) { //RuntimeException 이 수퍼클래스라서 
			//NullPointException을 작성안했음
			System.out.println("총이 없어서 발사하지 못했습니다.");
			s = new 총();
			s.shoot();
		}
		
		System.out.println("메인 스레드 종료");
	}
}
