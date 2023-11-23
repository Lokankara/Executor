package executor.service.service.executor;

import org.junit.jupiter.api.Test;

class ThreadPoolAndQueueTest {

    @Test
    void testThreadAndQueue()
            throws Exception {
        ThreadPoolAndQueue service = new ThreadPoolAndQueue();
        service.threadAndQueue();
    }
    @Test
    void testPairThread()
            throws Exception {
        MultiThreadPool service = new MultiThreadPool();
        service.threadAndQueue();
    }
}