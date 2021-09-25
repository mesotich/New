import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.HashMap;
import java.util.Map;

public class Solution extends AppenderSkeleton {
    @Override
    protected void append(LoggingEvent loggingEvent) {
    }

    @Override
    public void close() {
        Map<Integer,String> map = new HashMap<>();

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}