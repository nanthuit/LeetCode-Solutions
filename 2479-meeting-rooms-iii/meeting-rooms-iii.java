class Solution {
    public int mostBooked(int n, int[][] meetings) {
      Arrays.sort(meetings,(a,b)->a[0]-b[0]);
      PriorityQueue<int[]>busy=new PriorityQueue<>((a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
      PriorityQueue<Integer>idle=new PriorityQueue<>();
      for(int i=0;i<n;i++)idle.offer(i);
      int[] count=new int[n];
      for(int[]m:meetings){
        int s=m[0],e=m[1];
        while(!busy.isEmpty()&&busy.peek()[0]<=s){
            idle.offer(busy.poll()[1]);
        }
        if(!idle.isEmpty()){
            int room=idle.poll();
            count[room]++;
                busy.offer(new int[]{e, room});
            } else {
                int[] top = busy.poll();
                int room = top[1];
                count[room]++;
                busy.offer(new int[]{top[0] + (e - s), room});
            }
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[res]) res = i;
        }
        return res;
    }
}
        