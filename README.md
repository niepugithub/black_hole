这个远程库汇总了自己平时写的一些小功能型代码。
一个分支一个小项目；master分支合并所有提交。blank分支是空分支，方便给仓库添加新的项目时候，拷贝空分支；做到一个项目一个分支，不耦合，也方便自己查阅

sprigboot-skill分支，记录平时看到的一些手法比较高级的代码，学习别人的手法，开阔视野

增加user的crud接口
其中分页插件不要用springboot自带的，否则出现多个，报错：在系统中发现了多个分页插件，请检查系统配置

mybatis的配置文件不要出现多个configuration

mapper文件复制时候，注意，不能全是select，有update，delete，insert四类
