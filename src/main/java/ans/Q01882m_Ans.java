class Q01882m_Ans {
    class ServerState {
        int idx;
        int weight;
        int ending;
        public ServerState(int i, int w, int e) {
            idx = i;
            weight = w;
            ending = e;
        }
    }
    
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<ServerState> ready = new PriorityQueue<>((a, b) -> {
            return (a.weight == b.weight) ? a.idx - b.idx : a.weight - b.weight;
        });
        for (int i = 0; i < n; i++) {
            ready.offer(new ServerState(i, servers[i], 0));
        }
        PriorityQueue<ServerState> busy = new PriorityQueue<>((a, b) -> {
            return (a.ending == b.ending) ? ((a.weight == b.weight) ? a.idx - b.idx : a.weight - b.weight) : a.ending - b.ending;
        });
        for (int j = 0; j < m; j++) {
            while (!busy.isEmpty() && busy.peek().ending <= j) {
                ready.offer(busy.poll());
            }
            // 如果暂时没有可用的服务器，就用最先完成服务的那个，也就是busy的堆顶
            // 更新服务结束时间，与下标j无关，因为已经不是从j时刻开始了
            if (ready.isEmpty()) {
                ServerState top = busy.poll();
                top.ending += tasks[j];
                ans[j] = top.idx;
                busy.offer(top);
            } else {
                ServerState serv = ready.poll();
                serv.ending = j + tasks[j];
                ans[j] = serv.idx;
                busy.offer(serv);
            }
        }
        return ans;
    }
}
