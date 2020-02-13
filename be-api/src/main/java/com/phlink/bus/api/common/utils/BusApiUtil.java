package com.phlink.bus.api.common.utils;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.phlink.bus.api.common.authentication.JWTUtil;
import com.phlink.bus.api.common.domain.BusApiConstant;
import com.phlink.bus.api.common.function.CacheSelector;
import com.phlink.bus.api.common.service.CacheService;
import com.phlink.bus.api.route.domain.enums.TripRedirectEnum;
import com.phlink.bus.api.system.domain.User;
import com.phlink.bus.api.system.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * BusApi工具类
 */
@Slf4j
public class BusApiUtil {

    /**
     * 缓存查询模板
     *
     * @param cacheSelector    查询缓存的方法
     * @param databaseSelector 数据库查询方法
     * @return T
     */
    public static <T> T selectCacheByTemplate(CacheSelector<T> cacheSelector, Supplier<T> databaseSelector) {
        try {
            log.debug("query data from redis ······");
            // 先查 Redis缓存
            T t = cacheSelector.select();
            if (t == null) {
                // 没有记录再查询数据库
                return databaseSelector.get();
            } else {
                return t;
            }
        } catch (Exception e) {
            // 缓存查询出错，则去数据库查询
            log.error("redis error：", e);
            log.debug("query data from database ······");
            return databaseSelector.get();
        }
    }

    /**
     * 获取当前操作用户
     *
     * @return 用户信息
     */
    public static User getCurrentUser() {
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String username = JWTUtil.getUsername(token);
        UserService userService = SpringContextUtil.getBean(UserService.class);
        CacheService cacheService = SpringContextUtil.getBean(CacheService.class);

        return selectCacheByTemplate(() -> cacheService.getUser(username), () -> userService.findByName(username));
    }

    /**
     * token 加密
     *
     * @param token token
     * @return 加密后的 token
     */
    public static String encryptToken(String token) {
        try {
            EncryptUtil encryptUtil = new EncryptUtil(BusApiConstant.TOKEN_CACHE_PREFIX);
            return encryptUtil.encrypt(token);
        } catch (Exception e) {
            log.info("token加密失败：", e);
            return null;
        }
    }

    /**
     * token 解密
     *
     * @param encryptToken 加密后的 token
     * @return 解密后的 token
     */
    public static String decryptToken(String encryptToken) {
        try {
            EncryptUtil encryptUtil = new EncryptUtil(BusApiConstant.TOKEN_CACHE_PREFIX);
            return encryptUtil.decrypt(encryptToken);
        } catch (Exception e) {
            log.info("token解密失败：", e);
            return null;
        }
    }

    /**
     * 驼峰转下划线
     *
     * @param value 待转换值
     * @return 结果
     */
    public static String camelToUnderscore(String value) {
        if (StringUtils.isBlank(value))
            return value;
        String[] arr = StringUtils.splitByCharacterTypeCamelCase(value);
        if (arr.length == 0){
            return value;
        }
        StringBuilder result = new StringBuilder();
        IntStream.range(0, arr.length).forEach(i -> {
            if (i != arr.length - 1){
                result.append(arr[i]).append(StringPool.UNDERSCORE);
            } else {
                result.append(arr[i]);
            }
        });
        return StringUtils.lowerCase(result.toString());
    }


    public static String getRandom(){
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(10);
            code.append(r);
        }
        return code.toString();

    }

    public static <E extends Enum<?> & IEnum> Optional<E> valueOf(Class<E> enumClass, String value) {
        return Arrays.stream(enumClass.getEnumConstants()).filter(e -> e.getValue().equals(value)).findAny();
    }
}
