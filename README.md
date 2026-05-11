# IMAEZIM
> 이어짐 맺어짐 그려짐, 이매짐

<p align="center">
  <img width="500" height="500" alt="이매짐_고해상도(흰색)" src="https://github.com/user-attachments/assets/8bd4ee3d-5a67-4d0a-a076-5486d63f5a8d" /><br>

</p>

## 📌 목차
- [프로젝트 소개](#intro)
- [기획 의도](#purpose)
- [주요 기능](#features)
- [시연 영상 (Youtube)](#demo)
- [기술 스택](#stack)
- [팀원 및 역할](#team)

---
<div id="intro"></div>

## 💻 프로젝트 소개
### 🗓️ 개발 기간 ( 𖦹 _ 𖦹 )
- 2023.12 ~ 2025.1 (1년)<br><br>

<b>IMAEZIM(이매짐)</b>은 AR 기술을 기반으로, 사용자가 **현실 공간에 글·사진·영상 형태의 AR 메모를 남기고**,  
다른 사용자가 남긴 콘텐츠를 직접 찾아가며 소통할 수 있는 새로운 형태의 SNS 플랫폼입니다.  
IMAEZIM으로 입체적인 소셜 상호작용을 경험해보세요!

---
<div id="purpose"></div>

## 🪄 기획 의도


모바일 폰과 SNS 앱을 통해 전 세계 사람들은 시간과 공간의 제약 없이 교류할 수 있게 되었습니다.  
그러나 이러한 편리함 뒤에는 **대면 소통 감소**, **사회적 고립 증가**, **자기 존중감 저하** 등 SNS의 양면성이 존재합니다.  
특히 SNS 사용 시간이 늘어날수록 사람 간 비교가 심화되고, 현실 세계의 상호작용은 줄어드는 문제가 제기되고 있습니다.

이러한 문제를 최소화하기 위해 우리는 **AR 기술**을 활용한 새로운 형태의 SNS 경험을 제안하고자 했습니다.  
AR 환경은 사용자가 기존의 수동적인 정보 수용 방식에서 벗어나, **직접 움직이고, 탐색하고, 참여하는 능동적인 경험**을 가능하게 합니다.  
이를 통해 현실 세계의 상호작용을 자연스럽게 증가시키고, 사회적 단절을 완화할 수 있다고 보았습니다.

따라서 <b>IMAEZIM(이매짐)</b>은 
- 현실 세계의 상호작용을 늘리고  
- 참여 중심의 SNS 경험을 제공하며  
- 사회적 단절을 완화하는 것을 목표로 기획되었습니다.

---
<div id="features"></div>

## ⚙️ 주요 기능

### ◽ AR SNS🌐
- 다른 유저가 남긴 AR 메모 감상
- 공유된 AR 메모 GPS 위치 확인
  
![IMAEZIM_optimized_smaller](https://github.com/user-attachments/assets/717ee5a7-747e-471f-b773-73ec2f531cf4)
<br><br>


### ◽ AR 메모(실내·실외·물건)📄🖼️🎦
- 원하는 위치를 지정해 실내·실외·물건에 **AR 메모** 남기기
- 메모 형식은 글 / 사진 / 영상 중 택 1<br>
### ◽ AR 길찾기👣
- SNS 게시물(AR 메모)까지 가는 AR 내비게이션 제공  
- GPS + AR 방향 안내<br>
### ◽ AR 게임🕹️
- AR 공간에서 즐길 수 있는 미니 게임  
- 유저 참여형 경험 제공<br>
### ◽ AR 퀴즈🔡→🎁
- 위치 기반 AR 퀴즈  
- 퀴즈를 풀며 특정 위치로 이동하게 하는 체험형 기능<br><br>
  
---
<div id="demo"></div>

## 🎞️ [IMAEZIM 시연 영상 (Youtube 바로가기)](https://youtu.be/tUaR9V3uTP4)
> 본 영상은 **IMAEZIM**의 전체 기능과 각 기능이 유기적으로 연결되는 흐름을 한눈에 확인할 수 있는 통합 시연 영상입니다.<br>IMAEZIM이 제안하는 새로운 경험을 지금 확인해 보세요! 🎬<br><br>(※ 영상 클릭 시 유튜브로 이동합니다.)

[![전체 기능 시연 영상](https://img.youtube.com/vi/tUaR9V3uTP4/0.jpg)](https://youtu.be/tUaR9V3uTP4)
<br><br>

---
<div id="stack"></div>

## 🛠 기술 스택

### 🔹 Frontend (Mobile App, for Android)
- **![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=kotlin&logoColor=white)**&nbsp;&nbsp;—&nbsp;&nbsp;사용 언어<br>
- **![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=flat-square&logo=android-studio&logoColor=white)**&nbsp;&nbsp;—&nbsp;&nbsp;통합 개발 환경 (IDE)<br><br>

### 🔹 Backend
&nbsp;&nbsp;&nbsp;&nbsp;**![Django](https://img.shields.io/badge/Django-092E20?style=flat-square&logo=django&logoColor=white)**&nbsp;&nbsp;—&nbsp;&nbsp;사용자 관리, 게시물 저장, API 제공, REST API 기반 서버 구축<br><br>
  

### 🔹 AR & 3D (Core Feature)
- **![Unity](https://img.shields.io/badge/Unity-000000?style=flat-square&logo=unity&logoColor=white)**
    - AR 기능 전체 구현
    - AR Scene, Prefab, ShaderGraph 기반 렌더링<br><br>
- **![ARCore](https://img.shields.io/badge/ARCore-4285F4?style=flat-square&logo=google&logoColor=white)**
  - 공간 인식, 평면 탐지, AR 오브젝트 배치
  - 카메라 기반 환경 맵핑 기능<br><br>  
- **![Blender](https://img.shields.io/badge/Blender-E87D0D?style=flat-square&logo=blender&logoColor=white)**
  - AR 게임 출입문, 캐릭터, 경기장 3D 모델링<br><br>

### 🔹 Computer Vision
&nbsp;&nbsp;&nbsp;&nbsp;**![YOLO](https://img.shields.io/badge/YOLO-00FFFF?style=flat-square&logo=yolo&logoColor=black)**&nbsp;&nbsp;—&nbsp;&nbsp;Object Detection<br><br> 

### 🔹 Design & Collaboration
&nbsp;&nbsp;&nbsp;&nbsp;**![Figma](https://img.shields.io/badge/Figma-F24E1E?style=flat-square&logo=figma&logoColor=white)**&nbsp;&nbsp;**![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=github&logoColor=white)**&nbsp;&nbsp;**![Notion](https://img.shields.io/badge/Notion-000000?style=flat-square&logo=notion&logoColor=white)**<br><br> 

---
<div id="team"></div>

## 👥 팀원 및 역할

<table>
  <tr>
    <td align="center" width="150px">
      <a href="https://github.com/literallyme1">
        <img src="https://github.com/literallyme1.png" width="120px" style="border-radius:50%"/>
      </a>
      <br/>
      <b>경다은</b>
      <br/> 
      <sub>AR 실외 메모<br/>AR 게임<br/>AR 퀴즈<br/>Server</sub>
    </td>
    <td align="center" width="150px">
      <a href="https://github.com/JCTA0125">
        <img src="https://github.com/JCTA0125.png" width="120px" style="border-radius:50%"/>
      </a>
      <br/>
      <b>김가윤</b>
      <br/>
      <sub>AR 실내 메모<br/>AR 게임<br/>Android 앱</sub>
    </td>
    <td align="center" width="150px">
      <a href="https://github.com/imyoonsoo">
        <img src="https://github.com/imyoonsoo.png" width="120px" style="border-radius:50%"/>
      </a>
      <br/>
      <b>서윤수</b>
      <br/>
      <sub>AR 실내 메모<br/>AR 게임 3D 모델링<br/>Android 앱</sub>
    </td>
    <td align="center" width="150px">
      <a href="https://github.com/daeun408">
        <img src="https://github.com/daeun408.png" width="120px" style="border-radius:50%"/>
      </a>
      <br/>
      <b>오다은</b>
      <br/>
      <sub>AR 실외 메모<br/>물건 메모<br/>AR 길찾기<br/>Server</sub>
    </td>
    <td align="center" width="150px">
      <a href="https://github.com/AJ04K">
        <img src="https://github.com/AJ04K.png" width="120px" style="border-radius:50%"/>
      </a>
      <br/>
      <b>전은채</b>
      <br/>
      <sub>AR 실내 메모<br/>물건 메모<br/>AR 길찾기<br/>Android 앱</sub>
    </td>
  </tr>
</table>
