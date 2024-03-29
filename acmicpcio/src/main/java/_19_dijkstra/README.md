# Dijkestra(다익스트라) 

그래프에서 최단 거리를 구하는 알고리즘
특정 노드에서 다른 노드들의 최단 거리

|         기능         |    특징     | 시간복잡도(노드:V, 에지: E) |
|:------------------:|:---------:|:------------------:|
| 출발노드와 모든 노간의 최단 거리 | 에지는 모두 양수 |      O(ElogV)      |

# 핵심 이론

5단계로 이루어짐

## 1. 인접 리스트로 그래프 구현

N이 클 경우 인접 리스트로 구현하는 것이 효율적
노드와 가중치를 가지는 배열 형태로 구성

## 2. 최단거리 배열 초기화

출발 노드는 0, 이 외 노드는 무한대로 초기화

## 3. 값이 가장 작은 노드 고르기

최단 거리 배열에서 가장 작은 값을 가지는 노드를 찾음

## 4. 최단 거리 배열 업데이트

선택된 노드에 연결된 에지의 값을 바탕으로 다른 노드 값을 업데이트

최단 거리 업데이트 =  Min(선택 노드의 최단 거리 배열의 값 + 에지 가중치, 연결 노드 최단 거리 배열의 값)

## 5. 3, 4단계 반복

4단계 진행 시 선택된 노드가 다시 선택 되지 않도록 방문 배열 만들어 처리

모든 노드가 선택 될 때까지 반복
