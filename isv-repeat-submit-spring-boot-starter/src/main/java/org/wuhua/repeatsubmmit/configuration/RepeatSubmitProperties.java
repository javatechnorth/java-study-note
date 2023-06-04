package org.wuhua.repeatsubmmit.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "isv.repeat-submit")
public class RepeatSubmitProperties {

    // 默认3秒内不能重复提交
    private Long expire = 3000L;

    // 是否开启幂等性校验
    private boolean enabled = true;

    // 请求体MD5模式或原请求模式（默认为MD5模式）
    private boolean md5Mode = true;

    // 白名单列表（可选 - 需要实现）
    private List<String> whitelist;

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    // ... 其他属性的get/set方法省略 ...
}
