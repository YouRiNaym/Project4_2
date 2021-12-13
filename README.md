# 앱개발기초 기말고사 보고서
## 2020661077 서유리
### 개요
 실생활에서 활용이 가능한 어플을 제작하였음. 그림그리는것을 업으로 삼고 싶다는 꿈이 있기 때문에 내가 여태 그려왔던 그림 포트폴리오를 감상할 수 있는 어플리케이션을 제작함. 이때 그림을 감상 할 뿐만 아니라 개인연락처를 열람할 수 있고 유튜브 채널을 연동하여 어플을 사용했을 때 유튜브채널에 들어 갈 수있음.
 
 

### 클래스 설계
 #### [Activity]
 
   ① FirstActivity : 
   
     -시작화면 구현

     -MainActivity로 이동

   ② MainActivity :  
   
    -파일의 이름을 추출해 imagepath에 전달

    -버튼 클릭시 저장된 그림이 순서대로 변화

    -Uri 연결

	-체크박스 클릭시 개인프로필열람 
	
   ③ PictureView : 
   
    -imagepath에 저장된 그림파일을 출력

### 세부기능설명

   ① I want to see버튼 클릭시 다음화면으로 넘어갈 수 있다 -(FirstActivity)
   
    - Onclick()이벤트 사용
    
    - FirstActivity가 먼저 출력되어야 하기 때문에 manifest에서 <intent~ </intent- filter부분을 FirstActivity에 위치함

   ② 출력할 포트폴리오(그림)은 sd카드에 저장해 출력함
   
    - manifest에 퍼미션과 application 관련 속성을 추가
    
    - 레이아웃에 커스텀 위젯 추가

   ③ previous,next버튼 클릭시 저장된 그림이 순서대로 출력됨  –(MainActivity,PictureView)
   
    - curNum의 증가 감소값에 따라 imagepath값이 다르게 저장되어 그림이 순서대로 출력됨
    
    - invalidate()메소드를 활용하여 PictureView클래스의 onDraw()가 호출됨

   ④ 첫 번째 그림에서 previous를 클릭하거나 마지막 그림에서 next버튼을 클릭시 토스트메세지가 출력됨–(MainActivity)

   ③ 체크박스를 클릭시 가려져있던 개인 프로필을 열람할 수 있음–(MainActivity)
   
    - visivility를 사용해 클릭을 해야만 볼수 있게 설정함

   ④ Join버튼 클릭시 유튜브채널(웹브라우저)창이 출력–(MainActivity)
   
    - URI문자형식을 웹주소형식으로 사용, Uri.parse로 액션을 지정

### 레이아웃 디자인

![image](https://user-images.githubusercontent.com/94296298/145874865-71b4ea38-0f2d-4771-acaf-acffee408d44.png)

![image](https://user-images.githubusercontent.com/94296298/145874923-763e2a9f-2648-424f-8730-60360e210b3b.png)



