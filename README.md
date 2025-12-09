# IMAEZIM (이매짐)

<p align="center">
  <img width="500" height="500" alt="이매짐_고해상도(투명)" src="https://github.com/user-attachments/assets/39a7c8d0-77fc-4378-b145-9d7089318593" />
</p>

### 🌍 AR 기반 SNS 플랫폼 — 현실 세계에 메모를 남기고, 길을 찾고, 콘텐츠를 공유하는 새로운 방식

---

## 📌 목차
- [프로젝트 소개]
- [기획 의도]
- [기능 소개]
- [기술 스택]
- [팀 구성(만든 사람들)]

---

## 📘 프로젝트 소개

**IMAEZIM(이매짐)**은 AR 기술을 기반으로,  
사용자가 **현실 공간에 글·사진·영상 형태의 AR 메모를 남기고**,  
다른 사용자가 남긴 콘텐츠를 직접 찾아가며 소통할 수 있는 새로운 형태의 SNS 플랫폼입니다.  
이매짐을 통해 현실 세계를 이동하고 탐색하며 이루어지는 **입체적이고 몰입감 있는 소셜 상호작용**을 경험할 수 있습니다.

---

## 🎯 기획 의도


모바일 폰과 SNS 앱을 통해 전 세계 사람들은 시간과 공간의 제약 없이 교류할 수 있게 되었습니다.  
그러나 이러한 편리함 뒤에는 **대면 소통 감소**, **사회적 고립 증가**, **자기 존중감 저하** 등 SNS의 양면성이 존재합니다.  
특히 SNS 사용 시간이 늘어날수록 사람 간 비교가 심화되고, 현실 세계의 상호작용은 줄어드는 문제가 제기되고 있습니다.

이러한 문제를 최소화하기 위해 우리는 **AR 기술을 활용한 새로운 형태의 SNS 경험**을 제안하고자 했습니다.  
AR 환경은 사용자가 기존의 수동적인 정보 수용 방식에서 벗어나, **직접 움직이고, 탐색하고, 참여하는 능동적인 경험**을 가능하게 합니다.  
이를 통해 현실 세계의 상호작용을 자연스럽게 증가시키고, 사회적 단절을 완화할 수 있다고 보았습니다.


**IMAEZIM(이매짐)은 AR 기술을 통해**


- 현실 세계의 상호작용을 늘리고  
- 참여 중심의 SNS 경험을 제공하며  
- 사회적 단절을 완화  

하는 것을 목표로 합니다.

---

## 🧭 기능 소개

### 🔹 AR SNS (핵심 기능)
- 원하는 위치(실내·실외·물건)에 **AR 메모** 남기기  
- 글 / 사진 / 영상 중 택 1  
- 근처 AR 메모 탐색  
- 다른 유저가 남긴 메모 감상

![IMAEZIM_optimized_smaller](https://github.com/user-attachments/assets/717ee5a7-747e-471f-b773-73ec2f531cf4)





### 🔹 AR 길찾기
- SNS 게시물(AR 메모)까지 가는 AR 내비게이션 제공  
- GPS + AR 방향 안내

### 🔹 AR 게임
- AR 공간에서 즐길 수 있는 미니 게임  
- 유저 참여형 경험 제공

### 🔹 AR 퀴즈
- 위치 기반 AR 퀴즈  
- 퀴즈를 풀며 특정 위치로 이동하게 하는 체험형 기능

---

## 🛠 기술 스택 (Tech Stack)

### 🔹 Backend
- **Django**  
  - 사용자 관리, 게시물 저장, API 제공  
  - REST API 기반 서버 구축

### 🔹 Mobile App (Android)
- **Kotlin**
- Android Studio
  

### 🔹 AR & 3D (Core Feature)
- **Unity**
  - AR 기능 전체 구현
  - AR Scene, Prefab, ShaderGraph 기반 렌더링
- **ARCore**
  - 공간 인식, 평면 탐지, AR 오브젝트 배치
  - 카메라 기반 환경 맵핑 기능

### 🔹 Computer Vision
- **YOLO (Object Detection)**  


---
## 👥 팀 구성(만든 사람들)

<table>
  <tr>
    <td align="center">
      <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png" width="120"><br><br>
      <b>경다은</b><br>
      AR 실외 메모<br>
      AR 게임<br>
      AR 퀴즈<br>
      Server
    </td>
    <td align="center">
      <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png" width="120"><br><br>
      <b>김가윤</b><br>
      AR 실내 메모<br>
      AR 게임<br>
      Android 앱
    </td>
    <td align="center">
      <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png" width="120"><br><br>
      <b>서윤수</b><br>
      AR 실내 메모<br>
      AR 길찾기<br>
      게임 모델링<br>
      Android 앱
    </td>
    <td align="center">
      <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png" width="120"><br><br>
      <b>오다은</b><br>
      AR 실외 메모<br>
      물건 메모<br>
      AR 길찾기<br>
      Server
    </td>
    <td align="center">
      <img src="https://cdn-icons-png.flaticon.com/512/847/847969.png" width="120"><br><br>
      <b>전은채</b><br>
      AR 실내 메모<br>
      물건 메모<br>
      AR 길찾기<br>
      Android 앱
    </td>
  </tr>
</table>
