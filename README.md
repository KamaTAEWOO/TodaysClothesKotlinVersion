# Today's Clothes

- **개발 기간**: 2024.02.24 ~ 2024.06.22
- **개발 언어**: Kotlin
- **개발 프로그램**: Android Studio
- **설명: 기능 구현을 목표로 하였으며, UI는 추후 디자인팀과 협의 후 진행 예정

## 소개
프로젝트는 과거에 만든 프로젝트를 다른 언어를 사용하고 사이에 배운 기술을 복습하기 위해 진행하였습니다. 공공데이터를 활용해 날씨 데이터를 보여주고, 현재 날씨에 따라 추천하는 옷차림을 제공합니다. 또한 사용자가 선호하는 코디와 가지고 있는 옷을 기록할 수 있는 기능도 포함되어 있습니다.

## 1. 첫 화면

<img src="https://github.com/KamaTAEWOO/Todays_clothes/assets/48404941/50397bcb-6be1-452d-9ccd-7a94230cd274" alt="첫 화면" style="width: 200px;"/>

- 앱 실행 시, 앱의 이름과 이미지를 보여주며 3초 후 다음 화면으로 넘어감

## 2. 날씨 화면

<img src="https://github.com/KamaTAEWOO/Todays_clothes/assets/48404941/41033368-e276-4d58-bc5c-5c97b2857289" alt="날씨 화면" style="width: 200px;"/>

- 사용자의 현재 위치를 보여줌
- 현재 기온, 강수량, 바람세기를 표시
- 3시간마다 날씨 이미지와 기온을 업데이트
- 내일, 모레의 최저 기온, 최고 기온, 날씨 이미지 표시
- 하단에는 추천 별 옷차림, 내 옷장, My Cody 페이지로 이동하는 버튼 제공

## 3. 추천 별 옷차림 화면

<img src="https://github.com/KamaTAEWOO/Todays_clothes/assets/48404941/d413ecef-d86d-439a-8a2e-b629f2e7b238" alt="추천 별 옷차림 화면" style="width: 200px;"/>

- 오늘의 최저 기온, 최고 기온을 표시
- 사용자의 성별과 옷 스타일에 맞춰 추천 옷차림 제공

## 4. 개인 맞춤 설정

<img src="https://github.com/KamaTAEWOO/Todays_clothes/assets/48404941/142e56b3-7acb-4103-be3d-85feb5dec30e" alt="개인 맞춤 설정" style="width: 200px;"/>

- 추천 옷차림 화면 이전에 설정하는 페이지
- 성별, 기온에 대한 선호도, 옷 스타일 설정 가능

## 5. 내 옷장 화면

<img src="https://github.com/KamaTAEWOO/Todays_clothes/assets/48404941/7b349f8e-dc60-4d91-bc55-f11423bf7290" alt="내 옷장 화면" style="width: 200px;"/>

- 등록한 옷의 이미지를 큰 이미지로 보여줌
- 상의, 하의, 아우터 카테고리 선택 가능

## 6. 나의 코디 화면

<img src="https://github.com/KamaTAEWOO/Todays_clothes/assets/48404941/3f02569b-3f5d-41f0-8419-c5cea93d9e8e" alt="나의 코디 화면" style="width: 200px;"/>

- 상의, 하의, 아우터, 악세서리 등 나만의 룩 설정 가능
- 저장한 코디 이미지를 클릭 시 상세 화면으로 확대

