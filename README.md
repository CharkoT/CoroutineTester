# CoroutineTester by Kotlin

깃헙 아이디 검색, 검색 리스트 가져오기

MVVM + databinding + livedata + coroutine
retrofit2, glide 
사용

Screenshot
--------------------------------
![](https://user-images.githubusercontent.com/8044971/70489708-d8a80100-1b3f-11ea-9a1a-bd05b70adaf4.png)
위 내용의 구조를 띈다.
1. (Fragment)View(이하 V)와 ViewModel(이하 VM)간의 의존성을 제거하기 위해 livdata, databinding을 사용한다.
2. VM내부 Repository를 이용하여 데이터를 가져오고, 관련된 부분을 인터페이스를 사용하여 델리게이트 패턴을 만들고, 활용한다.
3. 레트로핏을 사용하여 해당 데이터를 받아온다.
4. Corutine을 활용하여 lifecycle에 안전성을 더해준다(?) - 아직 부족한게 많음.

우리는 왜 이렇게 코드를 짜야 하냐?
1. 테스트 가능한 코드를 만들기 용이하다.
2. 의존성이 제거가 됨으로 관련 이슈가 적어진다.


<img src="https://user-images.githubusercontent.com/8044971/70490305-6506f380-1b41-11ea-8a23-a43eb8ebef10.gif" width="360"></img>
