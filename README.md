# 📚 Java 学习项目

本项目旨在帮助熟悉 Git 和 Java 操作，同时也可作为 Java 学习路线的参考。如有不足之处，欢迎指正。

---

## 📁 项目结构

```
JAVA/
├── basic/                    # Java 基础学习
│   ├── basic_syntax/         # 基础语法
│   ├── object_oriented/      # 面向对象
│   ├── data_structures/      # 数据结构
│   ├── exception_handling/   # 异常处理
│   ├── io_operations/        # IO 操作
│   ├── advanced_syntax/      # 高级语法
│   ├── advanced_oop/         # 高级面向对象
│   ├── concurrency/          # 并发编程
│   ├── jvm/                  # JVM 原理
│   ├── network/              # 网络编程
│   ├── database/             # 数据库操作
│   ├── frameworks/           # 框架入门
│   ├── README.md             # Java 学习指南
│   ├── tutorial.html         # 可视化教程
│   └── run.bat               # 运行脚本
└── README.md                 # 项目总览
```

---

## 📖 学习内容

### 一、Java 基础入门
| 模块 | 内容 | 文件 |
|------|------|------|
| 基础语法 | 变量、数据类型、控制流程 | `basic_syntax/` |
| 面向对象 | 类、继承、多态、封装 | `object_oriented/` |
| 数据结构 | 数组、集合框架 | `data_structures/` |
| 异常处理 | try-catch、自定义异常 | `exception_handling/` |
| IO 操作 | 文件读写、序列化 | `io_operations/` |

### 二、Java 进阶
| 模块 | 内容 | 文件 | 最低版本 |
|------|------|------|----------|
| 高级语法 | 泛型、Lambda、Stream API、枚举 | `advanced_syntax/` | JDK 8 |
| 设计模式 | 单例、工厂等模式 | `advanced_oop/` | JDK 8 |
| 并发编程 | 多线程、线程池、CompletableFuture | `concurrency/` | JDK 8 |
| JVM 原理 | 内存模型、垃圾回收、类加载 | `jvm/` | JDK 8 |
| 网络编程 | Socket、HttpClient | `network/` | JDK 11 |
| 数据库 | JDBC、SQLite | `database/` | JDK 8 |
| 框架 | Spring IOC/DI | `frameworks/` | JDK 8 |

---

## 🚀 快速开始

### 1. 环境要求
- **基础模块**：JDK 8 或更高版本
- **网络编程（HttpClient）**：需要 JDK 11+
- **部分 IO 操作（Files.writeString）**：需要 JDK 11+
- Git
- 代码编辑器（IntelliJ IDEA / Eclipse / VS Code）

### 2. 编译运行

```bash
# 编译 Java 文件
javac -encoding UTF-8 -d . basic/basic_syntax/Variables.java

# 运行程序
java basic.basic_syntax.Variables
```

### 3. 使用脚本运行

```bash
# Windows
basic/run.bat

# 查看可视化教程（启动本地服务器）
python -m http.server 8000
# 然后访问 http://localhost:8000/basic/tutorial.html
```

---

## 📚 学习路径建议

| 阶段 | 时间 | 学习内容 |
|------|------|----------|
| 第一阶段 | 1-2 周 | 基础语法、类型转换、控制流程 |
| 第二阶段 | 2-3 周 | 面向对象、异常处理 |
| 第三阶段 | 2-3 周 | 数据结构、IO 操作 |
| 第四阶段 | 2-3 周 | 高级语法（泛型、Lambda、Stream、枚举） |
| 第五阶段 | 2-3 周 | 并发编程、JVM 原理 |
| 第六阶段 | 1-2 周 | 网络编程、数据库、框架入门 |

---

## 🔧 开发工具

- **编译器**：JDK 8+
- **IDE**：IntelliJ IDEA（推荐）、Eclipse、VS Code
- **版本控制**：Git + GitHub

---

## 🤝 贡献指南

欢迎提交 Issue 和 Pull Request！

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开 Pull Request

---

## 📄 许可证

本项目采用 MIT 许可证 - 详见 [LICENSE](LICENSE) 文件

---

## 📫 联系我

如有问题或建议，欢迎通过以下方式联系：

- GitHub：[@Chick-Gu](https://github.com/Chick-Gu)

---

⭐ **如果这个项目对你有帮助，请给个 Star！**