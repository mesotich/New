import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

//добавил комментарий
//еще добавил коментарий
//+ еще один комментарий

public class Solution extends AppenderSkeleton {
    @Override
    protected void append(LoggingEvent loggingEvent) {
    }

    @Override
    public void close() {
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}