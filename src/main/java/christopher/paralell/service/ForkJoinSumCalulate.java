package christopher.paralell.service;

import java.util.concurrent.RecursiveTask;

class ForkJoinSumCalulate extends RecursiveTask<Long> {

	private Long start;
	private Long end;

	public static final int threshold = 5;// 临界值

	public ForkJoinSumCalulate(Long start, Long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		Long length = end - start;
		if (length <= threshold) {
			Long sum = 0L;
			for (Long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		} else {
			Long middle = (start + end) / 2;

			ForkJoinSumCalulate left = new ForkJoinSumCalulate(start, middle);
			left.fork();
			ForkJoinSumCalulate right = new ForkJoinSumCalulate(middle + 1, end);
			right.fork();
			return left.join() + right.join();
		}
	}
}