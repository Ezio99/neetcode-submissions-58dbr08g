class MedianFinder {

    PriorityQueue<Integer> rightMinHeap;
    PriorityQueue<Integer> leftMaxHeap;

    public MedianFinder() {
        rightMinHeap = new PriorityQueue<>();
        leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (rightMinHeap.isEmpty() || num >= rightMinHeap.peek()) {
            rightMinHeap.offer(num);
        } else {
            leftMaxHeap.offer(num);
        }
        PriorityQueue<Integer> largeHeap = rightMinHeap.size() >= leftMaxHeap.size() ? rightMinHeap : leftMaxHeap;
        PriorityQueue<Integer> smallerHeap = rightMinHeap.size() <= leftMaxHeap.size() ? rightMinHeap : leftMaxHeap;
        while (largeHeap.size() > smallerHeap.size() + 1) {
            smallerHeap.offer(largeHeap.poll());
        }

    }

    public double findMedian() {
        if ((rightMinHeap.size() + leftMaxHeap.size()) % 2 == 0) {
            return ((double) rightMinHeap.peek() + leftMaxHeap.peek()) / 2.0;
        } else {
            PriorityQueue<Integer> largeHeap = rightMinHeap.size() >= leftMaxHeap.size() ? rightMinHeap : leftMaxHeap;
            return largeHeap.peek();
        }

    }
}
