@echo off
chcp 65001 >nul
title Java 运行脚本 - UTF-8编码

:menu
cls
echo.
echo ==================== Java 程序运行菜单 ====================
echo.
echo 请选择要运行的程序:
echo.
echo 【基础语法】
echo   1. Variables          - 变量与数据类型
echo   2. ControlFlow        - 控制流程
echo   3. OperatorsDemo      - 运算符详解
echo   4. StringOperations   - 字符串操作
echo   5. TypeConversion     - 类型转换
echo.
echo 【面向对象】
echo   6. Person             - 类与封装（含克隆）
echo   7. Student            - 继承与多态
echo   8. InnerClassesDemo   - 内部类和匿名类
echo   9. InterfaceDetailsDemo - 接口详解
echo.
echo 【数据结构】
echo  10. ArraysDemo         - 数组操作
echo  11. CollectionDemo     - 集合框架
echo  12. QueueStackDemo     - 队列和栈
echo  13. MapDetailsDemo     - Map详解
echo.
echo 【异常处理】
echo  14. ExceptionDemo      - 异常处理基础
echo  15. ExceptionDetailsDemo - 自定义异常
echo.
echo 【IO操作】
echo  16. FileDemo           - 文件操作
echo  17. NioSerializationDemo - NIO和序列化
echo.
echo 【高级语法】
echo  18. GenericsDemo       - 泛型
echo  19. LambdaDemo         - Lambda表达式
echo  20. StreamDemo         - Stream API
echo  21. EnumDemo           - 枚举
echo.
echo 【并发编程】
echo  22. ThreadDemo         - 多线程基础
echo  23. ThreadPoolDemo     - 线程池
echo  24. SynchronizationDemo - 同步机制
echo  25. CallableFutureDemo - Callable和Future
echo  26. CompletableFutureDemo - CompletableFuture
echo.
echo 【JVM原理】
echo  27. JVMMemoryDemo      - JVM内存模型
echo  28. GarbageCollectionDemo - 垃圾回收
echo  29. ClassLoaderDemo    - 类加载机制
echo.
echo 【网络编程】
echo  30. SocketServer       - Socket服务器
echo  31. SocketClient       - Socket客户端
echo.
echo 【其他】
echo  32. 编译所有代码
echo  33. 退出
echo.
set /p choice=请输入选项编号: 

if "%choice%"=="1" goto run_Variables
if "%choice%"=="2" goto run_ControlFlow
if "%choice%"=="3" goto run_OperatorsDemo
if "%choice%"=="4" goto run_StringOperations
if "%choice%"=="5" goto run_TypeConversion
if "%choice%"=="6" goto run_Person
if "%choice%"=="7" goto run_Student
if "%choice%"=="8" goto run_InnerClassesDemo
if "%choice%"=="9" goto run_InterfaceDetailsDemo
if "%choice%"=="10" goto run_ArraysDemo
if "%choice%"=="11" goto run_CollectionDemo
if "%choice%"=="12" goto run_QueueStackDemo
if "%choice%"=="13" goto run_MapDetailsDemo
if "%choice%"=="14" goto run_ExceptionDemo
if "%choice%"=="15" goto run_ExceptionDetailsDemo
if "%choice%"=="16" goto run_FileDemo
if "%choice%"=="17" goto run_NioSerializationDemo
if "%choice%"=="18" goto run_GenericsDemo
if "%choice%"=="19" goto run_LambdaDemo
if "%choice%"=="20" goto run_StreamDemo
if "%choice%"=="21" goto run_EnumDemo
if "%choice%"=="22" goto run_ThreadDemo
if "%choice%"=="23" goto run_ThreadPoolDemo
if "%choice%"=="24" goto run_SynchronizationDemo
if "%choice%"=="25" goto run_CallableFutureDemo
if "%choice%"=="26" goto run_CompletableFutureDemo
if "%choice%"=="27" goto run_JVMMemoryDemo
if "%choice%"=="28" goto run_GarbageCollectionDemo
if "%choice%"=="29" goto run_ClassLoaderDemo
if "%choice%"=="30" goto run_SocketServer
if "%choice%"=="31" goto run_SocketClient
if "%choice%"=="32" goto compile_all
if "%choice%"=="33" goto exit

echo.
echo 无效选项，请重新输入！
pause
goto menu

:run_Variables
echo.
echo ========== 运行 Variables.java ==========
echo.
java -Dfile.encoding=UTF-8 basic_syntax.Variables
goto end

:run_ControlFlow
echo.
echo ========== 运行 ControlFlow.java ==========
echo.
java -Dfile.encoding=UTF-8 basic_syntax.ControlFlow
goto end

:run_OperatorsDemo
echo.
echo ========== 运行 OperatorsDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 basic_syntax.OperatorsDemo
goto end

:run_StringOperations
echo.
echo ========== 运行 StringOperations.java ==========
echo.
java -Dfile.encoding=UTF-8 basic_syntax.StringOperations
goto end

:run_TypeConversion
echo.
echo ========== 运行 TypeConversion.java ==========
echo.
java -Dfile.encoding=UTF-8 basic_syntax.TypeConversion
goto end

:run_Person
echo.
echo ========== 运行 Person.java ==========
echo.
java -Dfile.encoding=UTF-8 object_oriented.Person
goto end

:run_Student
echo.
echo ========== 运行 Student.java ==========
echo.
java -Dfile.encoding=UTF-8 object_oriented.Student
goto end

:run_InnerClassesDemo
echo.
echo ========== 运行 InnerClassesDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 object_oriented.InnerClassesDemo
goto end

:run_InterfaceDetailsDemo
echo.
echo ========== 运行 InterfaceDetailsDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 object_oriented.InterfaceDetailsDemo
goto end

:run_ArraysDemo
echo.
echo ========== 运行 ArraysDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 data_structures.ArraysDemo
goto end

:run_CollectionDemo
echo.
echo ========== 运行 CollectionDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 data_structures.CollectionDemo
goto end

:run_QueueStackDemo
echo.
echo ========== 运行 QueueStackDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 data_structures.QueueStackDemo
goto end

:run_MapDetailsDemo
echo.
echo ========== 运行 MapDetailsDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 data_structures.MapDetailsDemo
goto end

:run_ExceptionDemo
echo.
echo ========== 运行 ExceptionDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 exception_handling.ExceptionDemo
goto end

:run_ExceptionDetailsDemo
echo.
echo ========== 运行 ExceptionDetailsDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 exception_handling.ExceptionDetailsDemo
goto end

:run_FileDemo
echo.
echo ========== 运行 FileDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 io_operations.FileDemo
goto end

:run_NioSerializationDemo
echo.
echo ========== 运行 NioSerializationDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 io_operations.NioSerializationDemo
goto end

:run_GenericsDemo
echo.
echo ========== 运行 GenericsDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 advanced_syntax.GenericsDemo
goto end

:run_LambdaDemo
echo.
echo ========== 运行 LambdaDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 advanced_syntax.LambdaDemo
goto end

:run_StreamDemo
echo.
echo ========== 运行 StreamDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 advanced_syntax.StreamDemo
goto end

:run_EnumDemo
echo.
echo ========== 运行 EnumDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 advanced_syntax.EnumDemo
goto end

:run_ThreadDemo
echo.
echo ========== 运行 ThreadDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 concurrency.ThreadDemo
goto end

:run_ThreadPoolDemo
echo.
echo ========== 运行 ThreadPoolDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 concurrency.ThreadPoolDemo
goto end

:run_SynchronizationDemo
echo.
echo ========== 运行 SynchronizationDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 concurrency.SynchronizationDemo
goto end

:run_CallableFutureDemo
echo.
echo ========== 运行 CallableFutureDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 concurrency.CallableFutureDemo
goto end

:run_CompletableFutureDemo
echo.
echo ========== 运行 CompletableFutureDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 concurrency.CompletableFutureDemo
goto end

:run_JVMMemoryDemo
echo.
echo ========== 运行 JVMMemoryDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 jvm.JVMMemoryDemo
goto end

:run_GarbageCollectionDemo
echo.
echo ========== 运行 GarbageCollectionDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 jvm.GarbageCollectionDemo
goto end

:run_ClassLoaderDemo
echo.
echo ========== 运行 ClassLoaderDemo.java ==========
echo.
java -Dfile.encoding=UTF-8 jvm.ClassLoaderDemo
goto end

:run_SocketServer
echo.
echo ========== 运行 SocketServer.java ==========
echo 注意：这是服务器程序，启动后按 Ctrl+C 停止
echo.
java -Dfile.encoding=UTF-8 network.SocketServer
goto end

:run_SocketClient
echo.
echo ========== 运行 SocketClient.java ==========
echo 注意：请先启动 SocketServer
echo.
java -Dfile.encoding=UTF-8 network.SocketClient
goto end

:compile_all
echo.
echo ========== 编译所有 Java 文件 ==========
echo.
javac -encoding UTF-8 basic_syntax/*.java object_oriented/*.java data_structures/*.java exception_handling/*.java io_operations/*.java advanced_syntax/*.java advanced_oop/*.java concurrency/*.java jvm/*.java network/*.java database/*.java -d .
echo.
echo 编译完成！
goto end

:end
echo.
echo.
pause
goto menu

:exit
echo.
echo 感谢使用！
exit
