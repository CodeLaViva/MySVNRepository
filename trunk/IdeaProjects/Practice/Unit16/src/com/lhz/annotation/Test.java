package com.lhz.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

public class Test {

    public static void main(String[] args){
        Record record = new Record();
        Class recordC = record.getClass();
        Constructor[] declaredConstructors = recordC.getDeclaredConstructors();
        for(int i = 0; i < declaredConstructors.length; i++){
            Constructor constructor = declaredConstructors[i];
            if(constructor.isAnnotationPresent(Constructor_Annotation.class)){
                Constructor_Annotation ca = (Constructor_Annotation) constructor.getAnnotation(Constructor_Annotation.class);
                System.out.println(ca.value());
            }
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            for(int j = 0; j < parameterAnnotations.length; j++){
                int length = parameterAnnotations[j].length;
                if(length == 0){
                    System.out.println("   未添加Annotation的参数");
                }else{
                    for(int k = 0; k < length; k++){
                        Field_Method_Parameter_Annotation pa = (Field_Method_Parameter_Annotation) parameterAnnotations[j][k];
                        System.out.println(" " + pa.describe());
                        System.out.println(" " + pa.type());
                    }
                }
            }
        }
        System.out.println();
    }
}
