不知道取啥名好，暂时就叫black_hole吧
（1）demo模块，简单的
（2）逆向工程的类进行查询时候，查询条件在service拼接，而不是controller层
（3）增加模糊匹配，插入user接口，注意模糊匹配的%需要自己加上去
（4）删除接口，返回值好像无法改成对应的javabean，报错，但是由于没有添加事务，所以数据库记录还是删除了
（5）修改接口，date类型变量如何在postman传参？答案：2018/11/11 11:11:11
（6）发现：事务A提交修改记录之后，虽然事务B看不到A的修改，但是事务B能感知得到数据的变化；而且不知道咋回事，
事务隔离级别是可重复读，按理说不能杜绝幻读，事务A已经提交插入的数据，事务B还是看不到。虽然事务B看不到，但是
事务B可以感受到新记录的存在；

详细：事务A，事务B，开始大家查看到的数据都是username='console1',username='张2'两条记录
事务A修改张2为'postman1'，并且提交，可以看到已经持久化到数据库中了
这时候事务B看到的还是之前的username='console1',username='张2'；
但是如果此时事务B执行update set username='hhh' where username='张2'，有趣的是，影响行数是0
也就是虽然事务B读到的username='张2'，但是事务B去update的时候的条件依据并不是自己读取到的数据，
而是数据库中目前真正存在的数据；

事务A插入新记录username='新1'，持久化到数据库中
此时事务B是看不到这条记录的，但是如果事务B执行update username='hhh'，会发现受影响的行是1，
说明事务B是可以看到事务A的已提交事务，这就是幻读！！！！

小结：事务处理数据的时候的依据并不是自己事务开启时候能够读取的数据快照，而是当前已经持久化到数据库中的
数据，也就是最新数据，这样数据一致性就可以得到很好的保证；

我以前一直以为，事务处理数据，比如更新时候，判断的依据是当前事务读取到的数据，这是错误的，其实是持久化到
数据库中的数据

（7）整合thymeleaf
报错：
template might not exist or might not be accessible by any of the configured Template Resolvers
找了半天，原来是资源文件路径默认是src/main/resources，由于逆向工程改成了src/main/java；
虽然后面又添加了src/main/resource，但是有include标签没有包含html吧，估计；导致找不到