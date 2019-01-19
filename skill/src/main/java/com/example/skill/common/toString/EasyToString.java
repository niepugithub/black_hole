package com.example.skill.common.toString;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 21:18
 **/
public class EasyToString {

    @Override
    public String toString() {
        Class<?> aClass = this.getClass();
        List<String> stringList = new ArrayList<>(20);
        while (aClass != EasyToString.class && aClass != Object.class) {
            Field[] fields = aClass.getDeclaredFields();
            for (Field f : fields) {
                ToStringHidden hiddenClass = f.getAnnotation(ToStringHidden.class);
                if (hiddenClass != null) {
                    stringList.add(f.getName());
                }
            }
            aClass = aClass.getSuperclass();
        }
        String s1 = new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .setExcludeFieldNames(stringList.toArray(new String[stringList.size()])).toString();
        return s1;
    }

}
