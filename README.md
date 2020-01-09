# CoroutineTester by Kotlin

깃헙 아이디 검색, 검색 리스트 가져오기

프로젝트 제목을 코루틴이라고 하고 정작 알맹이는 mvvm이 핵심인 프로젝트..
추후 코루틴에 대해 알아보자!!

MVVM + databinding + livedata + coroutine

Data Binding : EditText(양방향), Button(버튼액션, 단방향), TextView(단방향), RecyclerView(단방향)

retrofit2, glide 사용

Screenshot
--------------------------------
![](https://user-images.githubusercontent.com/8044971/70489708-d8a80100-1b3f-11ea-9a1a-bd05b70adaf4.png)
위 내용의 구조를 띈다.
1. (Fragment)View(이하 V)와 ViewModel(이하 VM)간의 의존성을 제거하기 위해 livedata, databinding을 사용한다.
2. LiveData를 사용하여 화면전환에도 최신데이터를 유지할 수 있게 변경
3. 레트로핏을 사용하여 해당 데이터를 받아온다.
4. Corutine을 활용하여 lifecycle에 안전성을 더해준다(?) - 아직 부족한게 많음.


우리는 왜 이렇게 코드를 짜야 하냐?
1. 테스트 가능한 코드를 만들기 용이하다.
2. 의존성이 제거가 됨으로 관련 이슈가 적어진다.


<img src="https://user-images.githubusercontent.com/8044971/70490305-6506f380-1b41-11ea-8a23-a43eb8ebef10.gif" width="360"></img>
