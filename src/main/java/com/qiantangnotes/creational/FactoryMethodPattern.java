package com.qiantangnotes.creational;

public class FactoryMethodPattern
{
    public static void main(String[] args)
    {
        LoggerFactory factory;
        Logger logger;
        // 可以引入配置文件和反射机制实现
        factory = new DatabaseLoggerFactory();
        logger = factory.createLogger();
        logger.writeLog();
    }
}

/**
 * 日志记录器接口，充当抽象产品角色
 */
interface Logger
{
    void writeLog();
}

/**
 * 数据库日志记录器：充当具体产品角色
 */
class DatabaseLogger implements Logger
{
    @Override
    public void writeLog()
    {
        System.out.println("数据库记录日志");
    }
}

/**
 * 文件日志记录器，充当具体产品角色
 */
class FileLogger implements Logger
{
    @Override
    public void writeLog()
    {
        System.out.println("文件日志记录");
    }
}

/**
 * 日志记录器工厂接口，充当抽象工厂角色
 */
interface LoggerFactory
{
    Logger createLogger();
}

/**
 * 数据库日志记录器工厂类，充当具体工厂角色
 */
class DatabaseLoggerFactory implements LoggerFactory
{
    @Override
    public Logger createLogger()
    {
        return new DatabaseLogger();
    }
}
/**
 * 文件日志记录器工厂类，充当具体工厂角色
 */
class FileLoggerFactory implements LoggerFactory
{
    @Override
    public Logger createLogger()
    {
        return new FileLogger();
    }
}