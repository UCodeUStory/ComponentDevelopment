# 组件化框架

## 1. 为什么要组件化？
   接触大项目时，页面逻辑过于复杂,便将页面分为很多个业务组件模块分而治之,这样的话维护人员每次只需要改动对对应组件即可
## 2. Android组件化需要解决的一些问题
**1.  页面跳转,不能写死了**


    1.  可以通过ARouter解决，有时间可以分析分里面原理
    android {
    defaultConfig {
        //arouter
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [moduleName: project.getName()]
            }
        }
    }

    dependencies {
          compile 'com.alibaba:arouter-api:1.2.1'
          annotationProcessor 'com.alibaba:arouter-compiler:1.1.2'
    }
**2. 资源名冲突**

   每个 module app_name，为了不让资源名重名，可以在每个组件的 build.gradle 中增加 resourcePrefix "xxx_"，固定每个组件的资源前缀。但是 resourcePrefix 这个值只能限定 xml 里面的资源，并不能限定图片资源，所有图片资源仍然需要你手动去修改资源名。不过我更建议把图片、 strings、 colors、dimens 等资源放到 common 去，可以防止不同的资源名字却对应了同一资源值。
 
**3.组件单独调试**

    在gradle.properties 中添加isDebug开关，需要点击 "Sync Project"
    if (isDebug.toBoolean()) {
        apply plugin: 'com.android.application'
     } else {
        apply plugin: 'com.android.library'
    }
 **4.开发阶段，module1 还必须有个 applicationId**
 
     android {
         //……
        defaultConfig {
            // 作为library时不能有applicationId,只有作为一个独立应用时才能够如下设置
            if (isDebug.toBoolean()){
                applicationId "com.wuxiaolong.module1"
            }
            //……
            }
    }
**5. AndroidManifest切换**


    android {
        //……  
        sourceSets {
            main {
                if (isDebug.toBoolean()) {
                    manifest.srcFile 'src/main/debug/AndroidManifest.xml'
                } else {
                    manifest.srcFile 'src/main/release/AndroidManifest.xml'
                    java {
                        //release 时 debug 目录下文件不需要合并到主工程
                        exclude 'debug/**'
                    }
                }
            }
        }
    }
**6.Butterknife**


Attribute value must be constant

在 Android Studio 的 library 的 module 中无法使用 ButterKnife。
网上说用 R2 替代（为什么能用 R2？），但都没有说 R2 怎么生成的？这篇《butterknife在library中使用问题处理》文章说使用 android-apt，确实可行，但是带来一个新坑，发现 apply plugin: 'android-apt' 与 arouter 冲突，这时候 arouter 失效了。正确姿势，用 Android ButterKnife Zelezny 插件生成，手动改成 R2，clean 下就 OK，感谢群里的小伙伴提示。

**7.switch 语句不能用，替换成if**

