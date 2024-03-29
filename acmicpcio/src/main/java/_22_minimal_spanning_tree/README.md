# Minimal Spanning Tree

그래프의 모든 노드를 연결할 때 사용된 에지들의 가중의 합을 최소로하는 트리

## 특징

사이클이 포함되면 가중치의 합이 최소가 될 수 없으므로 사이클을 포함하지 않음
N개의 노드가 있으면 최소 신장 트리를 구성하는 에지의 개수는 항상 N-1개

## Kruskal(크루스칼)

### 핵심 이론

1. 에지 리스트로 그래프 구현하고 유니온 파인드 리스트 초기화

최소 신장 트리는 데이터를 노드가 아닌 에지 중심으로 저장하므로 인접 리스트가 아닌 에지 리스트로 저장

일반적으로 노드 변수 2개와 가중치 변수 1개로 구성

사이클 처리를 위한 유니온 파인드 리스트 초기화(리스트의 인덱스를 해당 자리의 값으로 초기화)

2. 그래프를 가중치 기준으로 정렬

가중치 기준으로 오름차순 정렬

3. 가장 가중치가 낮은 노드부터 연결 시도

가중치가 낮은 노드부터 연결 시도 

바로 연결하지 않고 이 에지를 연결했을 때 그래프에 사이클 형성 유무를 find 연산을 이용해 확인 후 사이클이 형성되지 않는다면 union 연산을 이용해 두 노드를 연결

4. 3번의 단계 반복

노드의 개수가 N개라면 N-1번 반복하면 최소 신장 트리가 완성

## Prim(프림)



