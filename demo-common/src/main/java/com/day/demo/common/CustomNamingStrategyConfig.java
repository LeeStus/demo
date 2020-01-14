package com.day.demo.common;


import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

/**
 * @author leewebi-n
 */
@Configuration
public class CustomNamingStrategyConfig extends SpringPhysicalNamingStrategy{

    /**
     * 配置映射的数据表名
     *
     * @param name
     * @param jdbcEnvironment
     * @return
     */
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (null == name) {
            return null;
        }
        // 实体名 or 自定义的@Tabel name属性值
        String nameStr = name.getText();

        // 首字母大写(类名)，实体未定义@Table, 为表名加上tb_前缀
        if (Character.isUpperCase(nameStr.charAt(0))) {
            final String tablePrefix = "tb_";
            if (!nameStr.contains(tablePrefix)) {
                nameStr = tablePrefix + nameStr;
            }

            StringBuilder builder = new StringBuilder(nameStr.replace(".",""));
            for (int i = 1, maxLength = builder.length() - 1; i < maxLength; i++) {
                if (this.isUnderscoreRequired(builder.charAt(i - 1), builder.charAt(i), builder.charAt(i + 1))) {
                    builder.insert(i++, '_');
                }
            }
            return super.getIdentifier(builder.toString(), name.isQuoted(), jdbcEnvironment);
        }else {
            // 实体定义了@Table(name="xxx")，以name属性值为表名
            return super.getIdentifier(nameStr, name.isQuoted(), jdbcEnvironment);
        }
    }

    /**
     * 判断是否前一个字符为小写字母，当前字符为大写字母，下一个字符为小写字母
     *
     * @param before
     * @param current
     * @param after
     * @return
     */
    private boolean isUnderscoreRequired(char before, char current, char after) {
        return Character.isLowerCase(before) && Character.isUpperCase(current) && Character.isLowerCase(after);
    }
}
