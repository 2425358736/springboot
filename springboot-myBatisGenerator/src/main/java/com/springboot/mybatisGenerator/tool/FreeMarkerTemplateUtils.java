package com.springboot.mybatisGenerator.tool;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;

/**
 * 开发公司：青岛海豚数据技术有限公司
 * 版权：青岛海豚数据技术有限公司
 * <p>
 * FreeMarkerTemplateUtils
 *
 * @author 刘志强
 * @created Create Time: 2019/1/22
 */
public class FreeMarkerTemplateUtils {
    private static final Configuration CONFIGURATION;

    private FreeMarkerTemplateUtils() {
    }

    public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException var2) {
            throw var2;
        }
    }

    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }

    static {
        CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtils.class, "/template"));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }
}