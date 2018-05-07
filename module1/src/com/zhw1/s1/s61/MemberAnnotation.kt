package com.zhw1.s1.s61

import kotlin.reflect.KClass

/**
 * Created by sfghjtj on 2018/4/14.
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION,AnnotationTarget.PROPERTY,AnnotationTarget.PROPERTY_GETTER,AnnotationTarget.PROPERTY_SETTER)
annotation class MemberAnnotation(val type: KClass<*> = Unit::class,val description: String)