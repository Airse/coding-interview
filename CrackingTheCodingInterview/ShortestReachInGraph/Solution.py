t = int(input())

class Graph:
  def __init__(self, n):
    self.adj_list = []
    self.n = n
    for i in range(n):
      self.adj_list.append([])
    
  def connect(self, i, j):
    self.adj_list[i].append(j)
    self.adj_list[j].append(i)

  # Runtime: O(v + e)
  def find_all_distances(self, source):
    q = [{'id': source, 'distance': 0}]
    distances = [0 for i in range(self.n)]
    visited = [False for i in range(self.n)]
    visited[source] = True

    while (len(q) > 0):
      node = q.pop()

      for neighbour in self.adj_list[node['id']]:
        if (visited[neighbour]):
          continue
        q.insert(0, {'id': neighbour, 'distance': node['distance'] + 1})
        distances[neighbour] = node['distance'] + 1
        visited[neighbour] = True

    result = []
    for i in range(self.n):
      if i == source:
        continue
      if distances[i] == 0:
        result.append(str(-1))
      else:
        result.append(str(6 * distances[i]))

    print(' '.join(result))

for i in range(t):
    n,m = [int(value) for value in input().split()]
    graph = Graph(n)

    for i in range(m):
      x,y = [int(x) for x in input().split()]
      graph.connect(x-1, y-1)
    s = int(input())
    graph.find_all_distances(s-1)
    
