# [Gold V] 카드 섞기 - 21315 

[문제 링크](https://www.acmicpc.net/problem/21315) 

### 성능 요약

메모리: 22408 KB, 시간: 164 ms

### 분류

브루트포스 알고리즘, 구현, 시뮬레이션

### 제출 일자

2025년 1월 29일 20:24:14

### 문제 설명

<p style="user-select: auto !important;">마술사 영재는 카드 더미를 이용한 마술을 개발하였다.</p>

<p style="user-select: auto !important;">카드들에는 1부터 <i style="user-select: auto !important;">N</i>까지의 숫자가 적혀있으며 초기 상태에는 1이 맨 위에 있으며 <em style="user-select: auto !important;">N</em>개의 카드가 번호 순서대로 쌓여있다.</p>

<p style="user-select: auto !important;">영재는 마술을 위해 (2, <em style="user-select: auto !important;">K</em>) - 섞기를 만들었다.</p>

<p style="user-select: auto !important;">(2, <em style="user-select: auto !important;">K</em>) - 섞기는 총 <em style="user-select: auto !important;">K </em>+ 1개의 단계로 이루어져있다.</p>

<p style="user-select: auto !important;">첫 번째 단계는 카드 더미 중 밑에서 2<em style="user-select: auto !important;"><sup style="user-select: auto !important;">K</sup></em>개의 카드를 더미의 맨 위로 올린다.</p>

<p style="user-select: auto !important;">이후 <em style="user-select: auto !important;">i</em>(2 ≤ <em style="user-select: auto !important;">i </em>≤ <em style="user-select: auto !important;">K </em>+ 1)번째 단계는 직전에 맨 위로 올린 카드 중 밑에서 2<em style="user-select: auto !important;"><sup style="user-select: auto !important;">K </sup></em><sup style="user-select: auto !important;">- <em style="user-select: auto !important;">i </em>+ 1</sup>개의 카드를 더미의 맨 위로 올린다.</p>

<p style="user-select: auto !important;">예를 들어, 카드의 개수가 5개 일 때 초기 상태에서 (2, 2) - 섞기를 하는 과정은 다음과 같다.(괄호 내에서 왼쪽에 있을수록 위에 있는 카드이다.)</p>

<ul style="user-select: auto !important;">
	<li style="user-select: auto !important;">(1, 2, 3, 4, 5) → (2, 3, 4, 5, 1) → (4, 5, 2, 3, 1) → (5, 4, 2, 3, 1)</li>
</ul>

<p style="user-select: auto !important;">영재의 마술은 상대방이 초기 상태에서 (2, <em style="user-select: auto !important;">K</em>) - 섞기를 2번 한 결과를 보고 2번의 (2, <em style="user-select: auto !important;">K</em>) - 섞기에서 <em style="user-select: auto !important;">K</em>가 각각 무엇인지 맞추는 마술이다.</p>

<p style="user-select: auto !important;">마술 아이디어는 생각했지만, <em style="user-select: auto !important;">K</em>를 알아내는 방법을 모르는 영재를 위해 <em style="user-select: auto !important;">K</em>를 알아내는 프로그램을 만들자.</p>

<p style="user-select: auto !important;">2번의 (2, <em style="user-select: auto !important;">K</em>) - 섞기 후의 카드 더미 결과를 만드는 각각의 <em style="user-select: auto !important;">K</em>는 유일함이 보장된다.</p>

### 입력 

 <p style="user-select: auto !important;">첫 줄에 <em style="user-select: auto !important;">N</em>이 주어진다.</p>

<p style="user-select: auto !important;">둘째 줄에 2번의 (2, <em style="user-select: auto !important;">K</em>) - 섞기 후의 카드 더미가 위에 있는 카드부터 공백으로 구분하여 주어진다.</p>

### 출력 

 <p style="user-select: auto !important;">첫 번째 <em style="user-select: auto !important;">K</em>와 두 번째 <em style="user-select: auto !important;">K</em>를 출력한다.</p>

