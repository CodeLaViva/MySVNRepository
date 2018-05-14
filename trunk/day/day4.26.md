# 4.26 第一天日记

## 前期准备工作

* 下载并安装TortoiseSVN
* 下载并安装git
* 下载并安装vs code
* 下载并安装IDEA
* 下载并安装Jdk

## 安装vs code实用插件

1. Markdown All in One
2. Markdown Preview Enhanced
3. markdownlint
4. evermonkey

## 创建MyRepository SVN库

1. D盘创建文件夹*SVN*用以存放SVN仓库和SVN工作空间
2. *SVN*文件夹中创建文件夹*MyRepository*作为SVN库的载体
3. 右键*MyRepository*文件夹创建repository here
4. 使用TortoiseSVN工具快速创建标准目录格式（trunk、branches、tags）
5. *SVN*文件夹中创建*MyWork*文件夹作为SVN工作空间的载体
6. 右键*MyWork*文件夹，SVN Checkout从库中获取资源
7. SVN初步配置完成

## Markdown各种功能测试

### 代码块测试

```java

import java.util.Scanner

Test{
    public static void main(String[] arg0){
        int a = 0;
        String b = "123";
        b = fucntion(a ,b);
    }

    public static String function1(int x, String y){
        System.out.printf(x + y + " ");
        return x + y + " ";
    }
}

```

### 网址图片测试

[百度](www.baidu.com)

![我的图片](https://raw.githubusercontent.com/chenkang084/notes/master/imgs/blogs/vscode-1.png)

### 强调等测试

1. *标记

    *加斜*  **加粗**  ***加斜加粗***

2. _标记

    _加斜_  __加粗__  ___加斜加粗___
3. 段内代码

    Use the `printf()` function.
4. 段内代码(插入`)

    ``There is a literal backtick (`) here.``

    A single backtick in a code span: `` ` ``

    A backtick-delimited string in a code span: `` `foo` ``