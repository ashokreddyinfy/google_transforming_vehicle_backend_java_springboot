
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import io.micrometer.common.util.StringUtils;

@Component
public class CacheRepo {

    Logger logger = LoggerFactory.getLogger(CacheRepo.class);

    @Autowired
    private RedisTemplate template;

    public void deleteCache(String key) {
        boolean deleted = template.delete(key);
        if (deleted)
            logger.info("Data Deleted from cache for " + key);
        else
            logger.info("Data Not Deleted");
    }

    public void setCache(String key, String value) {
        template.opsForValue().set(key, value);
        logger.info("Data Added To cache");
    }

    public String getCache(String key) {
        logger.info("Getting cache for - " + key);
        String value = template.opsForValue().get(key);
        logger.info("Cache We got for " + key + " - " + value);
        if (StringUtils.isBlank(value))
            return null;
        else
            return value;
    }
}
