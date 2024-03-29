# Combination

조합은 $n_C_r$ 로, 이는 n개의 숫자에서 r개를 뽑는 경우의 수를 뜻합니다.
조합과 비교되는 순열은 $n_P_r$로 표현되고, n개의 숫자 중 r개를 뽑는 순서를 고려해 나열할 경우의 수를 이야기 합니다.
순열과 조합의 차이는 순서의 고려 유무입니다.
즉, 조합에서는 데이터 1, 2, 3과 3, 2, 1을 같은 경우로 판단하고, 순열은 다른 경우로 판단합니다.

## 순열과 조합의 핵심 이론

$n_P_r = n! / (n - r)!$

순열의 수학적 공식은 위와 같습니다.
예를 들어 5개 중 2개를 순서대로 선택하는 경우의 수를 구한다고 가정해 보겠습니다.
1번째 선택은 5개 데이터를 선택할 수 있으므로 5가지를 선택할 수 있고, 2번째 선택은 1번째에서 선택한 데이터를 제외한 4가지를 선택할 수 있습니다.
따라서 5개중 2개를 고르는 경우의 수는 5 * 4 = 20가지가 됩니다.
위 수식은 이 내용을 공식화한 것 입니다.

## 조합의 수학적 공식

$n_C_r = n! / (n - r)!r!$

순열과 비슷하며 분모에 r!가 추가 되었습니다.
r!은 순서가 다른 경우의 수를 제거하는 역할을 합니다.
예를 들어 5개 중 2개를 선택하는 경우의 수를 구한다고 가정하면 기존 순열의 경우의 수에 2!로 나눠 5 * 4 / 2 = 10 가지 경우의 수를 도출합니다.
즉, 1과 2를 선택할 때와 2와 1을 선택할 때를 1가지 경우의 수로 만들기 위해 2로 나누는 것입니다.

그렇다면 수학 공식이 아닌 점화식은 어떻게 될까요?
다음 3가지 단계로 점화식을 세워 보겠습니다.

## 1. 특정 문제 가정하기

5개의 데이터에서 3개를 선택하는 조합의 경우의 수를 푸는 문제를 가정하겠습니다.

|1|2|3|4|5|
|:--:|:--:|:--:|:--:|:--:|

> 데이터 5개 중 3개를 선택

## 2. 모든 부분 문제가 해결된 상황이라고 가정하고 지금 문제 생각하기

모든 부분 문제가 해결된 상황이라고 가정해 보겠습니다.
먼저 5개의 데이터 중 4개를 이미 선택이 완료된 데이터라고 가정합니다.
그리고 마지막 데이터의 선택 여부에 따른 경우의 수를 계산합니다.
만약 마지막 데이터를 포함해 총 3개의 데이터를 선택하려면 선택이 완료됐다고 가정한 4개의 데이터에서 2개를 선택해야 합니다.
마지막 데이터를 포함하지 않고 총 3개의 데이터를 선택하려면 이전 데이터 4개 중 3개를 선택해야 합니다.
2가지 경우의 수를 합치면 5개 중 3개를 선택하는 경우의 수가 나옵니다.

> $5_C_3 = 4_C_3 + 4_C_2

5개 중 3개를 선택하는 경우의 수 점화식

> D[5][3] = D[4][2] + D[4][3]

이 내용을 도출할 때 고민하는 부분이 '4개 중 2개를 선택하는 경우의 수와 4개 중 3개를 선택하는 경우의 수를 구해야 하는 거 아닌가?'입니다.
하지만 앞에서도 언급했듯이 모든 부분의 문제가 해결됐다고 가정해야 합니다.
지금은 5개 중 3개의 경우의 수를 구하는 것이 아니라 궁극적으로 조합과 관련된 점화식을 도출하는 것이기 때문입니다.
점화식을 정확하게 도출하면 부분 문제는 프로그램 로직을 이용해 자연스럽게 구해집니다.

## 3. 특정 문제를 해결한 내용을 바탕으로 일반 점화식 도출하기

> 조합 점화식
> 
> D[i][j] = D[i - 1][j] + D[i - 1][j - 1]


